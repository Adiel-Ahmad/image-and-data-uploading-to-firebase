**Firebase Profile Editing App**

 Developer: **M-A-R-I-N-D**

This project is a simple Android application that allows users to upload, store, and retrieve their profile data (such as name, email, nickname, date of birth) along with an image to Firebase. The app also provides a user interface for profile management and interaction with Firebase Storage and Realtime Database.



 Features:
 **Profile Editing**: Users can input their personal information (email, name, nickname, password, date of birth).
 **Image Upload**: Users can upload a profile picture from their gallery, and the image is stored in Firebase Storage.
 **Realtime Data**: The user's profile data is stored in Firebase Realtime Database, making it available across multiple devices.
 **Firebase Authentication**: New users can register using their email and password, with Firebase Authentication managing the login process.



 Technologies Used:
 **Kotlin**: Programming language used for Android development.
 **Firebase**: 
   **Firebase Authentication**: For handling user authentication.
   **Firebase Storage**: For storing images.
   **Firebase Realtime Database**: For storing user details like name, email, and nickname.
 **Glide**: An image loading and caching library for displaying images.
 **Android SDK**: For building the Android application.



 Screenshots:

Here are some screenshots of the app to give you an idea of its functionality and design:

 1. **Main Activity (Home Screen)**:
   ![WhatsApp Image 2025-04-05 at 2 11 18 PM](https://github.com/user-attachments/assets/119a3c99-f3d6-440f-ae20-9309f8aa66ac)

    The entry point of the app where users can navigate to the profile editing screen.

 2. **Profile Editing Screen**:
   ![WhatsApp Image 2025-04-05 at 2 11 18 PM (1)](https://github.com/user-attachments/assets/4c22e491-31be-4e0d-9849-bc56673a1994)

    Allows users to input their personal information such as name, email, nickname, password, and date of birth.


    The screen where users can upload and view their profile image.

 4. **Firebase Profile Saved**:
   ![Profile Saved](path_to_your_image/profile_saved_screenshot.png)

    Once the user uploads the image and saves the profile, this screen shows the saved data.



 Setup Instructions:

 Prerequisites:
 Android Studio installed.
 A Firebase project created (with Firebase Authentication, Firebase Storage, and Firebase Realtime Database enabled).

 Steps to Run:

1. **Clone the repository**:
   ```bash
   git clone https://github.com/yourusername/suffifirebase2.git
   ```

2. **Open the project**:
   Open the project in Android Studio.

3. **Firebase Setup**:
    Go to the [Firebase Console](https://console.firebase.google.com/).
    Create a new Firebase project or use an existing one.
    Add your Android app to the Firebase project and download the `googleservices.json` file.
    Place the `googleservices.json` file in the `app/` directory of your project.

4. **Dependencies**:
   Ensure you have the following dependencies in your `build.gradle` file:
   ```gradle
   implementation 'com.google.firebase:firebaseauth:21.0.3'
   implementation 'com.google.firebase:firebasedatabase:20.0.5'
   implementation 'com.google.firebase:firebasestorage:20.0.0'
   implementation 'com.github.bumptech.glide:glide:4.13.2'
   ```

5. **Sync the project**:
   Sync the project with the Firebase dependencies.

6. **Run the App**:
    Build and run the app on an emulator or physical device.
    Sign up with an email and password to test user registration.
    Upload a profile image and test retrieving and displaying the image.



 How the App Works:

 1. **MainActivity (Profile Editing Screen)**:
    The main activity contains a button (`btn1`) that, when clicked, navigates to the `EditProfileActivity`.
    The `EditProfileActivity` allows users to input their details such as email, password, name, nickname, and date of birth.

 2. **Profile Image Upload**:
    Users can select a profile image from the gallery.
    The selected image is uploaded to Firebase Storage, and the image URL is retrieved.
    The URL is stored in the Firebase Realtime Database, and the image is displayed in the UI using Glide.

 3. **Saving Profile Data**:
    The profile data (name, email, nickname, password, date of birth) is saved in Firebase Realtime Database.
    A progress dialog is shown while the image is being uploaded to Firebase Storage.

 4. **Firebase Authentication**:
    Firebase Authentication is used for user signup with email and password. If the registration is successful, the user can log in and access the profile.

 5. **Image Retrieval**:
    The profile image and data can be retrieved from Firebase and displayed on the app UI.

 6. **Navigation**:
    The app uses Intents to navigate between `MainActivity` and `EditProfileActivity`.



 File Breakdown:

 `MainActivity.kt`
    The entry point of the app.
    Displays a button to navigate to the profile editing screen (`editeprofile1`).

 `editeprofile1.kt`
    Allows the user to edit their profile and upload an image.
    Handles the interaction with Firebase for uploading images and storing user data.
    Uses `Glide` to display images and `FirebaseStorage` for uploading images.
    Retrieves and saves user profile data in `FirebaseDatabase`.



 Known Issues:
 If the email format is invalid or fields are empty, the user will be prompted with a toast message.
 The app requires an active internet connection for Firebase functionality.



 Contribution:

Contributions are welcome! If you find any bugs or want to improve the app, feel free to fork the repository and submit a pull request.



 License:
This project is opensource and available under the [MIT License](LICENSE).



 Contact:
If you have any questions or suggestions, feel free to reach out.

**M-A-R-I-N-D**  Developer

