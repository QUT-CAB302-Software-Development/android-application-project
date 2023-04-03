# Android Application

This is a sample application that demonstrates how to build an Android application. This application has a single screen that allows you to sign up for an account, log in, and view a list of users.

It is not required of you to use this application as a starting point for your project. You may choose to start from scratch, or use another sample application as a starting point. This application is provided as a reference for you to use if you find it helpful.

To create an Android project in IntelliJ IDEA (Ultimate), follow the instructions in the [Create your first Android application](https://www.jetbrains.com/help/idea/create-your-first-android-application.html) tutorial.

## Dependencies

This project uses the following dependencies:

- Amazon Corretto 11.0.8
- Android SDK 33

***Note:** Other dependencies may be added to the project as needed.*

## Software Requirements

This project requires the following software:

- IntelliJ IDEA Community
  - Download: https://www.jetbrains.com/idea/download/
- Android Emulator (should be automatically installed when downloading the Android SDK from IntelliJ IDEA)
  - Download: https://developer.android.com/studio/run/emulator

*While IntelliJ IDEA Community is sufficient for this project, we recommend using IntelliJ IDEA Ultimate. IntelliJ IDEA Ultimate has additional features that may be useful for your project, especially the ability to add SQLite support.*

## Getting Started

To get started, clone this repository and open the project in IntelliJ IDEA Ultimate. There are a few things you need to do before you can start coding.

<!-- Gradle will download the required dependencies defined in the `build.gradle` file.

You may need to `Reload All Gradle Projects` in IntelliJ IDEA if the project does not build successfully. This can be done by searching for `Reload All Gradle Projects` in the `Search Everywhere` dialog (Ctrl + Shift + A). -->

### 1. Setting up the Gradle JVM

First, you need to set the Gradle JVM to use the Amazon Corretto 11.0.8 JDK. To do this in IntelliJ IDEA, goto `Settings > Build, Execution, Deployment > Build Tools > Gradle`.

Click `Edit` on the `Gradle JVM` and you will be prompted to setup the Gradle JVM. Select Version 11, vendor `Amazon Corretto`, and click `OK`.

Navigate to the `Gradle` tab (on the right) and click `Reload All Gradle Projects`.

### 2. Setting up the Android SDK

Next, you need to download the Android SDK. To do this in IntelliJ IDEA, goto `Settings > Appearance & Behavior > System Settings > Android SDK`.

Click `Edit` on the `Android SDK Location` and you will be prompted to setup the Android SDK. Select `Android SDK` and `API 33: Android Tiramisu (R)`. Click `Next` to review the SDK components that will be installed, then `Next` and agree to the license agreements. Click `Next` again to begin the installation. Once the installation is complete, click `Finish`.

Then, you will need to create an Android Virtual Device (AVD) via the Android Emulator to run the application. To manage virtual devices, click the `No Devices` button in the top right corner of the IDE (next to the `Run` button).

### 3. Creating an Android Virtual Device (AVD)

Then, select `Device manager` and click the `Create device` button. Select an appropriate device to emulate, then click `Next`. Select an appropriate system image. If no system images are available, click the `Download` icon next to `Tiramisu` to download the system image. Once the system image is downloaded, click `Next` to review the AVD configuration. Click `Finish` to create the AVD.

### 4. Turning off the Android Emulator Tool Window

After creating the virtual device, we recommend you to turn off the `Android Emulator > Launch in a tool window` option. 

### 5. Running the Application

Now, when you click the `Run` button, the Android Emulator will launch and run the application. For the first time, you may be asked to `Install Haxm` to speed up the emulator. Click `OK` to begin the installation. You will be asked to allocate a certain amount of memory to Haxm, then click `Next` to begin the installation. Once the installation is complete, click `Finish`.

### Project Structure

Before coding, we also recommend setting Intellij IDEA to use the `Android` view rather than `Project` view.

Additionally, please read the [Android Developer Guides - Fundamentals](https://developer.android.com/guide/components/fundamentals) to get familiar with the Android application file structure, including the following:
- [AndroidManifest.xml](https://developer.android.com/guide/topics/manifest/manifest-intro)
- [Activity](https://developer.android.com/guide/components/activities/intro-activities)
- [res](https://developer.android.com/guide/topics/resources/providing-resources)

In this project, the Java code is located in the `app/src/main/java` directory. The XML code is located in the `app/src/main/res` directory (specifically, the `layout` directory contains the XML code I created for the UI). The `AndroidManifest.xml` file is located in the `app/src/main` directory.

Tests are located in the `app/src/androidTest/java` directory. The `AndroidManifest.xml` file for tests is located in the `app/src/androidTest` directory.

## Recommended Tutorials

Please note that this is not an exhaustive list of tutorials. These are just some tutorials that I found helpful. You may find other tutorials more useful to you, depending on your learning style and your project requirements.

- Videos:
  - [(LinkedIn Learning) Android Development - by Todd Perkins](https://www.linkedin.com/learning/learning-java-applications-14700256/creating-an-android-project-in-android-studio) - This is a collection of short videos to get you started with Android Development in Java.
  - [(YouTube) Android Development for Beginners - by freeCodeCamp](https://youtu.be/fis26HvvDII) - This is a long video that covers the basics of Android Development in Java. You may skip to 5:39:40 if you are already familiar with Java.

- Articles / Guides:
  - [Build your first Android App](https://developer.android.com/training/basics/firstapp) - Official Android guide to building your first Android app.
  - [Android Developer Guides](https://developer.android.com/guide) - Official Android developer guides.
  - [Android Tutorial (JavaPoint)](https://www.javatpoint.com/android-tutorial) - A collection of tutorials to get you started with Android Development in Java. Please feel free to skip to the section that applies to your project.
