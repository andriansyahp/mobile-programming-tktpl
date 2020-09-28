package id.ac.ui.cs.mobileprogramming.andriansyah.helloworld;

import android.content.Context;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class ConverterInstrumentedTest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("id.ac.ui.cs.mobileprogramming.andriansyah.helloworld", appContext.getPackageName());
    }

    @Test
    public void convertCelciusToFahrenheitAndReamur(){
        onView(withId(R.id.celcius)).perform(click());
        onView(withId(R.id.temperature)).perform(typeText("30"));
        onView(withId(R.id.convert_btn)).perform(click());
        onView(withText(ConverterUtils.convertCelsiusToFahrenheit(30))).check(matches(isDisplayed()));
        onView(withText(ConverterUtils.convertCelsiusToReamur(30))).check(matches(isDisplayed()));
    }

    @Test
    public void convertFahrenheitToCelciusAndReamur(){
        onView(withId(R.id.fahrenheit)).perform(click());
        onView(withId(R.id.temperature)).perform(typeText("86"));
        onView(withId(R.id.convert_btn)).perform(click());
        onView(withText(ConverterUtils.convertFahrenheitToCelsius(86))).check(matches(isDisplayed()));
        onView(withText(ConverterUtils.convertFahrenheitToReamur(86))).check(matches(isDisplayed()));
    }

    @Test
    public void convertReamurToCelciusAndReamur(){
        onView(withId(R.id.reamur)).perform(click());
        onView(withId(R.id.temperature)).perform(typeText("24"));
        onView(withId(R.id.convert_btn)).perform(click());
        onView(withText(ConverterUtils.convertReamurToCelcius(24))).check(matches(isDisplayed()));
        onView(withText(ConverterUtils.convertReamurToFahrenheit(24))).check(matches(isDisplayed()));
    }
}