package test;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

/**
 * @author chenyuqun
 */
public class IsNotANumber extends TypeSafeMatcher<Double> {
    @Override
    protected boolean matchesSafely(Double item) {
        return item.isNaN();
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("not a number");
    }

    @Factory
    public static Matcher notANumber() {
        return new IsNotANumber();
    }
}
