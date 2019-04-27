package com.mpeng3.breakpointbug

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @Rule @JvmField
    var activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java, true, true)

    @Test
    fun breakpointWorks() {
        ///// Setting a breakpoint on the next line will work
        onView(withId(R.id.hello_world_text)).check(matches(withText("Hello World!")))
    }

    @Test
    fun breakpointWorksInKotlinButNotInJava() {
        ///// Unlike in Java, setting a breakpoint on the next line WILL work in Kotlin, even with the newlines
        onView(withId(R.id.hello_world_text)).check(matches(
            withText("Hello World!"))
        )
    }
}
