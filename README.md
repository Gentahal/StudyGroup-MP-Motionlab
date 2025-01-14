# Firebase for Notes Application

This document provides an overview of how Firebase is utilized in the Notes application to manage backend functionalities seamlessly and efficiently.

---

## Introduction
Firebase is a comprehensive backend-as-a-service (BaaS) platform provided by Google. It simplifies the development process by offering pre-built services such as authentication, real-time databases, and cloud functions. In this Notes application, Firebase powers core features such as user authentication, data storage, and file management.

---

## Firebase Services Used
1. **Authentication**: To manage user login and registration securely.
2. **Cloud Firestore**: For storing and managing notes data in a NoSQL cloud database.
3. **Storage**: For handling file uploads, such as images or attachments associated with notes.
4. **Hosting** (Optional): If the application is deployed as a web app.

---

## Project Configuration
To integrate Firebase with the Notes application, the following steps were performed:

1. **Firebase Project Setup**:
   - Created a Firebase project in the [Firebase Console](https://console.firebase.google.com).
   - Added an Android/iOS/Web app to the project.

2. **SDK Integration**:
   - Integrated Firebase SDK into the application codebase.
   - Configuration files such as `google-services.json` (for Android) or `GoogleService-Info.plist` (for iOS) were added.

3. **Environment Variables**:
   - Firebase configuration details (API Key, Project ID, etc.) were stored securely using `.env` files or similar methods.

---

## Authentication
Firebase Authentication is used to manage user accounts securely. The following authentication methods are enabled:

- **Email and Password Authentication**: Allows users to register and log in using their email and password.
- **Google Sign-In** (Optional): Provides a convenient way to log in using Google accounts.

### Implementation
- Users can sign up, log in, and log out seamlessly.
- Authentication states are monitored to ensure a smooth user experience.

---

## Firestore Database
Firestore is a NoSQL cloud database that stores structured data in the form of collections and documents.

### Usage in Notes Application
- **Notes Storage**:
  - Each user has a dedicated collection of notes.
  - Notes include fields like `title`, `content`, `timestamp`, and optional `attachments`.

- **Real-Time Updates**:
  - Changes made to notes are reflected instantly across all devices.

### Security Rules
- Read and write access is restricted based on user authentication to ensure data privacy.

---

## Storage
Firebase Storage is used for managing media files such as images or attachments associated with notes.

### Key Features
- Securely stores files with access control based on user authentication.
- Files are linked to notes in the Firestore database using URLs.

### Example
- When a user uploads an image, the file is stored in a specific folder structure (e.g., `users/{userId}/attachments/`).

---

## Deployment
If the Notes application includes a web interface, Firebase Hosting can be used for deployment:

1. **Install Firebase CLI**:
   ```bash
   npm install -g firebase-tools
   ```
2. **Initialize Hosting**:
   ```bash
   firebase init hosting
   ```
3. **Deploy Application**:
   ```bash
   firebase deploy
   ```

---

## Conclusion
Firebase provides an all-in-one solution to handle backend functionalities for the Notes application, ensuring scalability, security, and ease of use. With its robust features like authentication, Firestore, and storage, the development process is significantly streamlined.

For more information, visit the [Firebase Documentation](https://firebase.google.com/docs).

## Implement

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
