# Firebase

This document provides an overview of how Firebase is utilized in the Notes application to manage backend functionalities seamlessly and efficiently.

Firebase is a comprehensive backend-as-a-service (BaaS) platform provided by Google. It simplifies the development process by offering pre-built services such as authentication, real-time databases, and cloud functions. In this Notes application, Firebase powers core features such as user authentication, data storage, and file management.

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

### 5. **Notes Screen (add & delete notes)**
   - In this feature, users can create/save notes, and also delete their notes.
   <div style="display: flex;">
     <img src="app/src/main/res/drawable/doc_notes1.jpeg" width="200" style="margin-right: 10px;"/>
     <img src="app/src/main/res/drawable/doc_notes2.jpeg" width="200"/>
     <img src="app/src/main/res/drawable/doc_notes3.jpeg" width="200"/>
   </div>  

## Technology Used
- **Kotlin** 
- **Jetpack Compose**
- **FIREBASE**

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
