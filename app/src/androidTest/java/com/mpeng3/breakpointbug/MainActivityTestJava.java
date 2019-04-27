package com.mpeng3.breakpointbug;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MainActivityTestJava {
    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class, true, true);

    @Test
    public void breakpointWorks() {
        ///// Setting a breakpoint on the next line will work
        onView(withId(R.id.hello_world_text)).check(matches(withText("Hello World!")));
    }

    @Test
    public void breakpointDoesNotWork() {
        ///// Setting a breakpoint on the next line will NOT work (it's the same as the other one, just with some newlines added)
        onView(withId(R.id.hello_world_text)).check(matches(
                withText("Hello World!"))
        );
    }
}
