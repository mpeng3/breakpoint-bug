# breakpoint-bug

This simple example project contains a few UI tests that highlight a bug in Android Studio's debugger.

### The bug

The file [MainActivityTestJava.java](app/src/androidTest/java/com/mpeng3/breakpointbug/MainActivityTestJava.java) contains two Espresso tests, `breakpointWorks()` and `breakpointDoesNotWork()`.

Adding a breakpoint at the designated lines (23 and 29, respectively) and running each test in Debug mode highlights the problem.

In `breakpointWorks()`, the app will successfully pause when it reaches the breakpoint on line 23.

**However, in `breakpointDoesNotWork()`, the app will not pause if you set a breakpoint on line 29 - the only difference between this test and `breakpointWorks()` being the extra newlines.**

### Kotlin
Additionally, I created versions of both of these tests in Kotlin: [MainActivityTest.kt](app/src/androidTest/java/com/mpeng3/breakpointbug/MainActivityTest.kt).  Interestingly, setting a breakpoint on the correct lines (21 and 27) pauses the app correctly in both tests, even with the extra newlines.

### Environment
I reproduced this issue in Android Studio 3.4 on Mac OS 10.14.4 with the UI tests run on both a physical device (Nexus 5X running Android 8.1) and an emulator (Pixel 2 API 28).
