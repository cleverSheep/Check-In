package com.clarmoph.attendenceappprototype


import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.clarmoph.attendenceappprototype.views.AdjustCheckInTimeFragment
import com.clarmoph.attendenceappprototype.views.AdjustProximityFragment
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FragmentTestSuite {

    @Test
    fun testCheckInTimeFragmentIsDisplayed() {
        launchFragmentInContainer<AdjustCheckInTimeFragment>()

        onView(withId(R.id.checkdate_dialog))
            .check(matches(isDisplayed()))
    }

    @Test
    fun testAdjustProximityFragmentIsDisplayed() {
        launchFragmentInContainer<AdjustProximityFragment>()

        onView(withId(R.id.adjust_proximity))
            .check(matches(isDisplayed()))
    }

    @Test
    fun testCheckInTimeSetDateButtonIsInvisible() {
        launchFragmentInContainer<AdjustCheckInTimeFragment>()

        onView(withId(R.id.btn_checkin_date))
            .perform(click())
        onView(withId(R.id.btn_checkin_date))
            .check(matches(isDisplayed()))
    }

}