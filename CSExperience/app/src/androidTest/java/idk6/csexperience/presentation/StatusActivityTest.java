package idk6.csexperience.presentation;


import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import idk6.csexperience.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class StatusActivityTest {

    @Rule
    public ActivityTestRule<NavActivity> mActivityTestRule = new ActivityTestRule<>(NavActivity.class);

    @Test
    public void statusActivityTest() {
//        ViewInteraction appCompatButton = onView(
//                allOf(withId(R.id.buttonStart), withText("START"),
//                        childAtPosition(
//                                allOf(withId(R.id.startScreen),
//                                        childAtPosition(
//                                                withId(android.R.id.content),
//                                                0)),
//                                0),
//                        isDisplayed()));
//        appCompatButton.perform(click());
//
//        ViewInteraction appCompatEditText = onView(
//                allOf(withId(R.id.gameName),
//                        childAtPosition(
//                                allOf(withId(R.id.nameMain),
//                                        childAtPosition(
//                                                withId(android.R.id.content),
//                                                0)),
//                                2),
//                        isDisplayed()));
//        appCompatEditText.perform(replaceText("ROB"), closeSoftKeyboard());

        ViewInteraction appCompatImageButton = onView(
                allOf(withContentDescription("Open navigation drawer"),
                        childAtPosition(
                                allOf(withId(R.id.toolbar),
                                        childAtPosition(
                                                withClassName(is("android.widget.LinearLayout")),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton.perform(click());

        ViewInteraction navigationMenuItemView = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.design_navigation_view),
                                childAtPosition(
                                        withId(R.id.nav_view),
                                        0)),
                        2),
                        isDisplayed()));
        navigationMenuItemView.perform(click());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.buttonSleep), withText("Sleep"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollViewActivities),
                                        0),
                                1)));
        appCompatButton2.perform(scrollTo(), click());

        ViewInteraction floatingActionButton = onView(
                allOf(withId(R.id.closeDialog),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.relativeLayout4),
                                        2),
                                0),
                        isDisplayed()));
        floatingActionButton.perform(click());

        ViewInteraction appCompatImageButton2 = onView(
                allOf(withContentDescription("Open navigation drawer"),
                        childAtPosition(
                                allOf(withId(R.id.toolbar),
                                        childAtPosition(
                                                withClassName(is("android.widget.LinearLayout")),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton2.perform(click());

        ViewInteraction navigationMenuItemView2 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.design_navigation_view),
                                childAtPosition(
                                        withId(R.id.nav_view),
                                        0)),
                        2),
                        isDisplayed()));
        navigationMenuItemView2.perform(click());

        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.buttonEat), withText("Eat"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollViewActivities),
                                        0),
                                2)));
        appCompatButton3.perform(scrollTo(), click());

        ViewInteraction floatingActionButton2 = onView(
                allOf(withId(R.id.closeDialog),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.relativeLayout4),
                                        2),
                                0),
                        isDisplayed()));
        floatingActionButton2.perform(click());

        ViewInteraction appCompatImageButton3 = onView(
                allOf(withContentDescription("Open navigation drawer"),
                        childAtPosition(
                                allOf(withId(R.id.toolbar),
                                        childAtPosition(
                                                withClassName(is("android.widget.LinearLayout")),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton3.perform(click());

        ViewInteraction navigationMenuItemView3 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.design_navigation_view),
                                childAtPosition(
                                        withId(R.id.nav_view),
                                        0)),
                        2),
                        isDisplayed()));
        navigationMenuItemView3.perform(click());

        ViewInteraction appCompatButton4 = onView(
                allOf(withId(R.id.buttonGame), withText("Game"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollViewActivities),
                                        0),
                                3)));
        appCompatButton4.perform(scrollTo(), click());

        ViewInteraction floatingActionButton3 = onView(
                allOf(withId(R.id.closeDialog),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.relativeLayout4),
                                        2),
                                0),
                        isDisplayed()));
        floatingActionButton3.perform(click());

        ViewInteraction appCompatImageButton4 = onView(
                allOf(withContentDescription("Open navigation drawer"),
                        childAtPosition(
                                allOf(withId(R.id.toolbar),
                                        childAtPosition(
                                                withClassName(is("android.widget.LinearLayout")),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton4.perform(click());

        ViewInteraction navigationMenuItemView4 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.design_navigation_view),
                                childAtPosition(
                                        withId(R.id.nav_view),
                                        0)),
                        2),
                        isDisplayed()));
        navigationMenuItemView4.perform(click());

        ViewInteraction appCompatButton5 = onView(
                allOf(withId(R.id.buttonGroceryHaul), withText("Grocery Haul"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollViewActivities),
                                        0),
                                4)));
        appCompatButton5.perform(scrollTo(), click());

        ViewInteraction floatingActionButton4 = onView(
                allOf(withId(R.id.closeDialog),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.relativeLayout4),
                                        2),
                                0),
                        isDisplayed()));
        floatingActionButton4.perform(click());

        ViewInteraction appCompatImageButton5 = onView(
                allOf(withContentDescription("Open navigation drawer"),
                        childAtPosition(
                                allOf(withId(R.id.toolbar),
                                        childAtPosition(
                                                withClassName(is("android.widget.LinearLayout")),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton5.perform(click());

        ViewInteraction navigationMenuItemView5 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.design_navigation_view),
                                childAtPosition(
                                        withId(R.id.nav_view),
                                        0)),
                        2),
                        isDisplayed()));
        navigationMenuItemView5.perform(click());

        ViewInteraction appCompatButton6 = onView(
                allOf(withId(R.id.buttonNightOut), withText("Night Out"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollViewActivities),
                                        0),
                                5)));
        appCompatButton6.perform(scrollTo(), click());

        ViewInteraction floatingActionButton5 = onView(
                allOf(withId(R.id.closeDialog),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.relativeLayout4),
                                        2),
                                0),
                        isDisplayed()));
        floatingActionButton5.perform(click());

        ViewInteraction appCompatImageButton6 = onView(
                allOf(withContentDescription("Open navigation drawer"),
                        childAtPosition(
                                allOf(withId(R.id.toolbar),
                                        childAtPosition(
                                                withClassName(is("android.widget.LinearLayout")),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton6.perform(click());

        ViewInteraction navigationMenuItemView6 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.design_navigation_view),
                                childAtPosition(
                                        withId(R.id.nav_view),
                                        0)),
                        2),
                        isDisplayed()));
        navigationMenuItemView6.perform(click());

        ViewInteraction appCompatButton7 = onView(
                allOf(withId(R.id.buttonSuperSleep), withText("Super Sleep"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollViewActivities),
                                        0),
                                6)));
        appCompatButton7.perform(scrollTo(), click());

        ViewInteraction floatingActionButton6 = onView(
                allOf(withId(R.id.closeDialog),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.relativeLayout4),
                                        2),
                                0),
                        isDisplayed()));
        floatingActionButton6.perform(click());
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
