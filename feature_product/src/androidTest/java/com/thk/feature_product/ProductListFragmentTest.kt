package com.thk.feature_product

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.scrollTo
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import com.thk.feature_product.util.TestUtils.withRecyclerView
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.thk.feature_product.presentation.list.recyclerview.ProductRecyclerViewAdapter
import com.thk.feature_product.test.EspressoIdlingResource
import com.thk.menu.core.presentation.NavHostActivity
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.core.IsInstanceOf
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4ClassRunner::class)
class ProductListFragmentTest {

    @get: Rule
    val activityRule: ActivityScenarioRule<NavHostActivity> =
        ActivityScenarioRule(NavHostActivity::class.java)

    @Before
    fun registerIdlingResource() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.countingIdlingResource)
    }

    @After
    fun unregisterIdlingResource() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.countingIdlingResource)
    }

    @Test
    fun testIsFragmentInActivity() {
        onView(withId(com.thk.menu.R.id.navHostFragment)).check(matches(isDisplayed()))
    }

    @Test
    fun testIsProductListRendered() {
        onView(allOf(
            withId(R.id.recyclerViewProduct),
            withParent(
                withRecyclerView(R.id.recyclerViewCategory).atPosition(0)
            )
        )
        ).perform(actionOnItemAtPosition<ProductRecyclerViewAdapter.ViewHolder>(0, scrollTo()))
            .check(matches(hasDescendant(withText("Bread"))))
    }

    @Test
    fun testIsNavigationToDetailWithSalePrice() {
        val recyclerView = onView(
            allOf(
                withId(R.id.recyclerViewProduct),
                childAtPosition(
                    withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
                    1
                )
            )
        )
        recyclerView.perform(actionOnItemAtPosition<RecyclerView.ViewHolder>(3, click()))

        val textView = onView(
            allOf(
                withId(R.id.salePrice), withText("EUR 0.01"),
                isDisplayed()
            )
        )
        textView.check(matches(withText("EUR 0.01")))
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
