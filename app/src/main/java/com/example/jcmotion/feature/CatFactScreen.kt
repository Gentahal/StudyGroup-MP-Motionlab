package com.example.jcmotion.feature

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jcmotion.viewmodel.CatFactViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatFactScreen(viewModel: CatFactViewModel = viewModel()) {
    val catFact by viewModel.catFact.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchCatFact()
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Cat Facts", style = MaterialTheme.typography.headlineSmall) },
            )
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(24.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Card(
                    shape = RoundedCornerShape(16.dp),
                    elevation = CardDefaults.elevatedCardElevation(6.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Box(
                        modifier = Modifier.padding(16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Crossfade(targetState = catFact) { fact ->
                            if (fact != null) {
                                Text(
                                    text = fact.fact,
                                    style = MaterialTheme.typography.bodyLarge,
                                    modifier = Modifier.padding(8.dp)
                                )
                            } else {
                                CircularProgressIndicator()
                            }
                        }
                    }
                }
                ElevatedButton(
                    onClick = { viewModel.fetchCatFact() },
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text("Get New Fact")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCatFactScreen() {
    CatFactScreen()
}
