# Navigation & Route

Here I create a simple application with login, register, home, and profile features. The application UI that I made is like an online learning UI.

**Navigation** and **Route** in Android Jetpack Compose are essential components of modern application architecture that simplify managing navigation between screens in a declarative UI-based application. Here's a complete explanation:

---

### 1. **Navigation in Jetpack Compose**
Jetpack Compose uses the **Navigation** library to manage screen-to-screen navigation. This library replaces fragments and enables composable-based navigation more straightforwardly.

#### Key Components in Navigation:
1. **NavHost**: 
   - A container where all navigation routes are defined.
   - Acts as the host for screens (composables).
   - Example:
     ```kotlin
     NavHost(navController, startDestination = "home") {
         composable("home") { HomeScreen() }
         composable("profile") { ProfileScreen() }
     }
     ```

2. **NavController**:
   - An object used to control navigation, such as switching between screens or going back.
   - Example:
     ```kotlin
     val navController = rememberNavController()
     ```

3. **Composable**:
   - Represents a screen or a part of the UI in the application.
   - Defined with a unique route name inside `NavHost`.

4. **Routes**:
   - Unique identifiers (strings) used to determine each screen.
   - Example: `"home"`, `"profile/{userId}"`.

---

### 2. **Route**
Routes are used to assign unique names to each composable in the `NavHost`. These routes can also have parameters for passing data between screens.

#### Using Routes:
1. **Static Routes**:
   - Do not require parameters.
   - Example:
     ```kotlin
     NavHost(navController, startDestination = "home") {
         composable("home") { HomeScreen() }
     }
     ```

2. **Dynamic Routes** (with arguments):
   - Used for navigation with parameters.
   - Example:
     ```kotlin
     NavHost(navController, startDestination = "home") {
         composable("profile/{userId}") { backStackEntry ->
             val userId = backStackEntry.arguments?.getString("userId")
             ProfileScreen(userId)
         }
     }
     ```

   - Navigating to a dynamic route:
     ```kotlin
     navController.navigate("profile/123")
     ```

---

### 3. **Screen-to-Screen Navigation**
To move between screens, use `NavController` with the `navigate()` method.

#### Example:
```kotlin
@Composable
fun HomeScreen(navController: NavController) {
    Button(onClick = { navController.navigate("profile/123") }) {
        Text("Go to Profile")
    }
}

@Composable
fun ProfileScreen(userId: String?) {
    Text("Welcome, User ID: $userId")
}
```

---

### 4. **Back Navigation**
Use the `popBackStack()` method on `NavController` to return to the previous screen.

#### Example:
```kotlin
Button(onClick = { navController.popBackStack() }) {
    Text("Back")
}
```

---

### 5. **Arguments & Deep Linking**
Jetpack Compose Navigation supports arguments and deep linking:
- **Arguments**: To pass data between screens.
- **Deep Link**: To open the app directly to a specific screen using a URL.

---

### Advantages of Navigation in Jetpack Compose:
- Declarative: Defined directly in Kotlin code, without additional XML.
- Simple: Navigation is more intuitive compared to fragments.
- Supports deep linking, animations, and arguments effortlessly.

With Navigation & Route in Jetpack Compose, managing navigation becomes more organized, scalable, and closely aligned with the declarative paradigm of Compose.

## Feature

### 1. **Login Features**
   - Users can login with their desired username.
   <div style="display: flex;">
     <img src="app/src/main/res/drawable/doc1.jpg" width="200" style="margin-right: 10px;"/>
     <img src="app/src/main/res/drawable/doc5.jpg" width="200"/>
     <img src="app/src/main/res/drawable/doc6.jpg" width="200"/>
   </div>

### 2. **Register Features**
   - Before entering the application and logging in, users must register an account to enter the user page.
   <div style="display: flex;">
     <img src="app/src/main/res/drawable/doc2.jpg" width="200" style="margin-right: 10px;"/>
     <img src="app/src/main/res/drawable/doc4.jpg" width="200"/>
     <img src="app/src/main/res/drawable/doc3.jpg" width="200"/>
   </div>   

### 3. **Welcoming Home (Home Page)**
   - In this home UI, I designed it to be similar to the UI of most online learning classes.
   <div style="display: flex;">
     <img src="app/src/main/res/drawable/doc7.jpg" width="200" style="margin-right: 10px;"/>
     <img src="app/src/main/res/drawable/doc8.jpg" width="200"/>
     <img src="app/src/main/res/drawable/doc9.jpg" width="200"/>
   </div> 

### 4. **Profile Status (Profile Page)**
   - Here users can see their profile status (dummy data). And there is a logout button for users who want to change accounts.
   - and then it will return to the login page
   <div style="display: flex;">
     <img src="app/src/main/res/drawable/doc10.jpg" width="200" style="margin-right: 10px;"/>
     <img src="app/src/main/res/drawable/doc11.jpg" width="200"/>
   </div>

## Technology Used
- **Kotlin** 
- **Jetpack Compose**

## Instalation
1. Clone this repository:

   ```bash
   https://github.com/Gentahal/StudyGroup-MP-Motionlab.git

2. Open the project in Android Studio

  - Open Android Studio.
  - Click on Open an existing Android Studio project.
  - Navigate to the project directory and select it to open.

3. Sync Gradle
  - Once the project is opened in Android Studio, you’ll need to sync the project with Gradle. This will download any dependencies specified in the project.
  - Click on File > Sync Project with Gradle Files.

4. Configure Android Emulator or Connect a Device
  - Using an Emulator:
  - In Android Studio, click on the AVD Manager (Android Virtual Device) icon.
  - Create a new virtual device or use an existing one.
  - Choose a device specification (such as Pixel 4) and a system image.
  - Click Start to launch the emulator.
  - Using a Physical Device:
  - Enable Developer Options and USB Debugging on your Android device.
  - Connect your device via USB.
  - Confirm any prompts on your device to allow debugging.
5. Build the Project
  - Ensure there are no errors in the project by building it. You can build the project by clicking on Build > Make Project.

6. Run the Application
- Once everything is set up, you can run the app either on an emulator or a physical device:
- Click the Run button (green triangle) in the Android Studio toolbar.
- Select the device/emulator you want to run the app on.
- The app should now build and run on your selected device.

---

Happy to be here and Enjoy with My Code! 🚀
