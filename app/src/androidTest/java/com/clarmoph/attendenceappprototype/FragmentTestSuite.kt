package com.clarmoph.attendenceappprototype


import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.clarmoph.attendenceappprototype.views.AdjustCheckInTimeFragment
import com.clarmoph.attendenceappprototype.views.AdjustProximityFragment
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FragmentTestSuite {

    @get:Rule
    var activityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testCheckInTimeFragmentIsDisplayed() {
        launchFragmentInContainer<AdjustCheckInTimeFragment>()

        onView(withId(R.id.checktime_fragment))
            .check(matches(isDisplayed()))
    }

    @Test
    fun testAdjustProximityFragmentIsDisplayed() {
        launchFragmentInContainer<AdjustProximityFragment>()

        onView(withId(R.id.adjust_proximity))
            .check(matches(isDisplayed()))
    }

    @Test
    fun testNextButtonDisplayedOnFirstScreen() {
        onView(withId(R.id.btn_next))
            .check(matches(isDisplayed()))
    }

//    @Test
//    fun testBackButtonDisplayedOnSecondScreen() {
//        launchFragmentInContainer<AdjustProximityFragment>()
//
//        onView(withId(R.id.btn_next))
//            .perform(click())
//        onView(withId(R.id.btn_back))
//            .check(matches(isDisplayed()))
//    }

}