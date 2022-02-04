![Workouts For Humans](https://github.com/recruitmentvg/ralphevmanzano/blob/feature/assessment/art/workout_for_humans.png)

# Workouts For Humans

Workouts For Humans is a simple project showcasing a list of workouts and a bit of their details (difficulty, primary and secondary muscles targeted). 

## Development setup

You require Android Studio Arctic Fox and up to be able to build the app. 

First, clone the repository: 
```
git clone https://github.com/recruitmentvg/ralphevmanzano.git
```
Then open the project in Android Studio. No other setups are needed to run the app, pressing the green play button does the work.

To run the tests, copy and paste this line in Android Studio's Terminal

For Mac users:
```
./gradlew test
```
For Windows users:
```
gradlew test
```
## Tech Stack

This project is a multi-module Android application. The app is using MVVM as a software design pattern which integrates seamlessly with [Android Jetpack](https://developer.android.com/jetpack) libraries such as Hilt, Room, Navigation, Lifecycle etc. The app uses Room database as the source of data and leverages Kotlin Coroutines for asynchronous processing. 

### Libraries
- Application is written entirely in [Kotlin](https://kotlinlang.org)
- Asynchronous processing using [Coroutines](https://kotlin.github.io/kotlinx.coroutines/)
- Dependency Injecy using [Hilt](https://developer.android.com/training/dependency-injection/hilt-android)
- [Room](https://developer.android.com/training/data-storage/room) for local storage
- [Jetpack Navigation](https://developer.android.com/guide/navigation) for in-app navigations
- Uses [JUnit4](https://developer.android.com/training/testing/junit-rules) for unit tests.
