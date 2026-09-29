package com.example.offlinechess

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.v2.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.offlinechess.Home.HomeScreen

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.offlinechess", appContext.packageName)
    }
}

@RunWith(AndroidJUnit4::class)
class HomeScreenUiTest{
    @get:Rule
    val composeTestRule= createComposeRule()


    @Test
    fun isGreetingMessageDisplayed(){
        composeTestRule.setContent{
            HomeScreen()
        }

        composeTestRule.onNodeWithTag("GreetingText")
            .assertIsDisplayed()

        composeTestRule.onNodeWithTag("NextMatchText")
            .assertIsDisplayed()

        composeTestRule.onNodeWithTag("Card1")
            .assertIsDisplayed()
            .performClick()

        composeTestRule.onNodeWithTag("Card2")
            .assertIsDisplayed()
            .performClick()
    }
}