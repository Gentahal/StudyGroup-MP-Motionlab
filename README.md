# Retrofit for Fetching Cat Facts

This document provides an overview of how Retrofit is utilized to fetch random cat facts from an API efficiently in an Android application.

---

## Introduction
Retrofit is a type-safe HTTP client for Android and Java, which simplifies network requests by converting API responses into Java objects. In this project, we use Retrofit to fetch random cat facts from the `https://catfact.ninja/fact` API and display them in the application.

---

## Dependencies
To use Retrofit in your Android project, add the following dependencies to your `build.gradle` (Module: app):

```gradle
implementation 'com.squareup.retrofit2:retrofit:2.9.0'
implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
```

Additionally, ensure you have `Gson` for JSON parsing:

```gradle
implementation 'com.google.code.gson:gson:2.8.9'
```

---

## Project Configuration

1. **Create API Interface**
   Define an interface to specify the API endpoints.

   ```java
   import retrofit2.Call;
   import retrofit2.http.GET;

   public interface CatFactApi {
       @GET("fact")
       Call<CatFact> getCatFact();
   }
   ```

2. **Model Class**
   Create a model class to map the JSON response.

   ```java
   import com.google.gson.annotations.SerializedName;

   public class CatFact {
       @SerializedName("fact")
       private String fact;

       public String getFact() {
           return fact;
       }
   }
   ```
---

## Conclusion
Retrofit simplifies API integration in Android applications by providing a clean and efficient way to fetch and parse data. By implementing Retrofit in this project, we can easily retrieve and display random cat facts from an API.

For more details, visit the [Retrofit Documentation](https://square.github.io/retrofit/).



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

### 6. **Cat Fact (screen)**
   - Here, users can see data about facts about cats that are taken from the API..
   <div style="display: flex;">
     <img src="app/src/main/res/drawable/fetch_1.jpeg" width="200" style="margin-right: 10px;"/>
     <img src="app/src/main/res/drawable/fetch_2.jpeg" width="200"/>
     <img src="app/src/main/res/drawable/fetch_3.jpeg" width="200"/>
     <img src="app/src/main/res/drawable/fetch_4.jpeg" width="200"/>
   </div>     

## Technology Used
- **Kotlin** 
- **Jetpack Compose**
- **FIREBASE**
- **Retrofit**

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
