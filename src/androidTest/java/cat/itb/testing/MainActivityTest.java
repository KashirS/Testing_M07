package cat.itb.testing;

import android.os.Parcelable;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    private static final String USER_TO_BE_TYPE="kashir";
    private static final String PASS_TO_BE_TYPE="kashir123";

    @Rule
   public ActivityScenarioRule<MainActivity> activityScenarioRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void elements_on_activityMain_are_displayed() {
        onView(withId(R.id.button_next))
                .check(matches(isDisplayed()));
        onView(withId(R.id.title))
                .check(matches(isDisplayed()));
    }

    @Test
    public void element_have_the_correct_text() {
        onView(withId(R.id.title))
                .check(matches(withText(R.string.title)));
        onView(withId(R.id.button_next))
                .check(matches(withText(R.string.next_button)));
    }

    @Test
    public void nextButton_is_clickable_and_change_text_to_back_when_clicked() {
        onView(withId(R.id.button_next))
                .check(matches(isClickable()))
                .perform(click())
                .check(matches(withText(R.string.back_button)));
    }

    @Test
    public void login_form_behaviour() {
        onView(withId(R.id.editText_userName))
                .check(matches(withText(USER_TO_BE_TYPE)))
                .perform(closeSoftKeyboard());
        onView(withId(R.id.editText_userPass))
                .check(matches(withText(PASS_TO_BE_TYPE)))
                .perform(closeSoftKeyboard());
        onView(withId(R.id.button_next))
                .perform(click());
        onView(withId(R.id.button_next))
                .check(matches(withText(R.string.logged)));
    }
    @Test
    public void activity_changed_verificacion(){
        onView(withId(R.id.button_next))
                .check(matches(isClickable()))
                .perform(click());
        onView(withId(R.id.welcome_layout))
                .check(matches(isDisplayed()));
    }
    @Test
    public void activity_navigation(){
        onView(withId(R.id.main_activity))
                .check(matches(isDisplayed()));
    }
    @Test
    public void large_test_function(){
        onView(withId(R.id.editText_userName))
                .check(matches(withText(USER_TO_BE_TYPE)))
                .perform(closeSoftKeyboard());
        onView(withId(R.id.editText_userPass))
                .check(matches(withText(PASS_TO_BE_TYPE)))
                .perform(closeSoftKeyboard());
        onView(withId(R.id.button_next))
                .check(matches(isClickable()))
                .perform(click());
        onView(withId(R.id.welcome_text))
                .check(matches(withText("Welcome back kashir")));
        onView(withId(R.id.button_back))
                .check(matches(isClickable()))
                .perform(click());
        onView(withId(R.id.main_activity))
                .check(matches(isDisplayed()));
        onView(withId(R.id.editText_userName))
                .perform(clearText());
        onView(withId(R.id.editText_userPass))
                .perform(clearText());
    }
}
