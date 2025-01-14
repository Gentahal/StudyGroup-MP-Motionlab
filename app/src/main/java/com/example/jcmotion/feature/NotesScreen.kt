package com.example.jcmotion.feature

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.jcmotion.model.Note

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotesScreen(navController: NavController? = null) {
    var notes by remember { mutableStateOf(listOf<Note>()) }
    var newNote by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "My Notes",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    if (newNote.isNotBlank()) {
                        notes = notes + Note(content = newNote)
                        newNote = ""
                    }
                },
                containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                shape = FloatingActionButtonDefaults.largeShape
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add Note",
                    tint = MaterialTheme.colorScheme.onTertiaryContainer
                )
            }
        }
    ) { innerPadding ->
        NotesContent(
            notes = notes,
            newNote = newNote,
            onNewNoteChange = { newNote = it },
            onNoteAdded = {
                notes = notes + Note(content = newNote)
                newNote = ""
            },
            onNoteDeleted = { index ->
                notes = notes.filterIndexed { i, _ -> i != index }
            },
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotesContent(
    notes: List<Note>,
    newNote: String,
    onNewNoteChange: (String) -> Unit,
    onNoteAdded: () -> Unit,
    onNoteDeleted: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        OutlinedTextField(
            value = newNote,
            onValueChange = onNewNoteChange,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(MaterialTheme.colorScheme.surfaceVariant, RoundedCornerShape(8.dp))
                .border(1.dp, MaterialTheme.colorScheme.primary, RoundedCornerShape(8.dp)),
            placeholder = { Text("Write something...") },
            shape = RoundedCornerShape(8.dp),
            trailingIcon = {
                if (newNote.isNotBlank()) {
                    IconButton(onClick = onNoteAdded) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Add Note",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            },
            textStyle = LocalTextStyle.current.copy(color = MaterialTheme.colorScheme.onSurface)
        )
        
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Your Notes",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 8.dp, bottom = 8.dp)
        )

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            itemsIndexed(notes) { index, note ->
                NoteItem(
                    note = note,
                    onDelete = { onNoteDeleted(index) }
                )
            }
        }
    }
}

@Composable
fun NoteItem(note: Note, onDelete: () -> Unit, modifier: Modifier = Modifier) {
    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface
        ),
        modifier = modifier
            .fillMaxWidth()
            .shadow(4.dp, RoundedCornerShape(12.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = note.content,
                fontSize = 16.sp,
                modifier = Modifier.weight(1f)
            )
            IconButton(
                onClick = onDelete,
                modifier = Modifier
                    .background(
                        MaterialTheme.colorScheme.errorContainer,
                        shape = RoundedCornerShape(50)
                    )
                    .padding(8.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Delete Note",
                    tint = MaterialTheme.colorScheme.onErrorContainer
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewNotesScreen() {
    NotesScreen()
}