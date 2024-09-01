package com.amazon.ata.unittesting.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * We're keeping the tests for {@code add()} from the pre-work, and adding new ones for {@code average()}.
 */
public class AtaMathTest {

    // add()

    @Test
    public void add_singleInteger_returnsTheInteger() {
        // GIVEN
        int[] oneInteger = {42};
        AtaMath ataMath = new AtaMath();

        // WHEN
        int result = ataMath.add(oneInteger);

        // THEN
        assertEquals(42, result, "Expected adding a single int to return the int");
    }

    @Test
    public void add_twoIntegers_returnsTheirSum() {
        // GIVEN
        int[] tuple = {6, 9};
        AtaMath ataMath = new AtaMath();

        // WHEN
        int result = ataMath.add(tuple);

        // THEN
        assertEquals(15, result, String.format(
            "Expected adding two ints (%s) to return their sum (15)",
            Arrays.toString(tuple))
        );
    }

    @Test
    public void add_emptyArray_returnsZero() {
        // GIVEN
        int[] emptyArray = {};
        AtaMath ataMath = new AtaMath();

        // WHEN
        int result = ataMath.add(emptyArray);

        // THEN
        assertEquals(0, result, "Expected empty array to sum to zero");
    }

    @Test
    public void add_nullArray_returnsZero() {
        // GIVEN
        int[] nullArray = null;
        AtaMath ataMath = new AtaMath();

        // WHEN
        int result = ataMath.add(nullArray);

        // THEN
        assertEquals(0, result, "Expected null array to sum to zero");
    }

    @Test
    public void add_sumOutOfBounds_throwsArithmeticException() {
        // GIVEN
        int[] values = {Integer.MAX_VALUE - 5, 3, 3};
        AtaMath ataMath = new AtaMath();

        // WHEN - attempt to compute the sum
        // THEN - exception thrown

        // the following syntax is a little fancy, just know that it's
        // asserting that when the second line calls the add()
        // method that we should see an `ArithmeticException` thrown
        assertThrows(ArithmeticException.class,
                     () -> ataMath.add(values),
                     "Summing above MAX_VALUE should result in ArithmeticException thrown");
    }

    @Test
    public void add_sumOutofBoundsUnderflow_throwsArithmeticException() {
        // GIVEN
        int[] values = {Integer.MIN_VALUE + 5, -3, -3};
        AtaMath ataMath = new AtaMath();

        // WHEN - attempt to compute the sum
        // THEN - exception thrown
        assertThrows(ArithmeticException.class,
                     () -> ataMath.add(values),
                     "Summing below MIN_VALUE should result in ArithmeticException thrown");
    }

    // average()

    // PARTICIPANTS: ADD YOUR NEW TESTS HERE (and you can delete this line while you're at it)
    @Test
    public void average_ofSingleInteger_isThatInteger() {
        //GIVEN
        int[] oneInteger = {2};
        AtaMath ataMath = new AtaMath();

        //WHEN
        double result = ataMath.average(oneInteger);

        //THEN
        Assertions.assertEquals(oneInteger[0], result, "Expected averaging one integer should equal that integer");
    }

    @Test
    public void average_ofSeveralIntegers_isCorrect() {
        //GIVEN
        int[] values = {2, 8, 2};
        AtaMath ataMath = new AtaMath();

        //WHEN
        double result = ataMath.average(values);

        //THEN
        Assertions.assertEquals(4, result, String.format(
                "Expected averaging values in array %s to return their average (4)",
                Arrays.toString(values)));
    }

    @Test
    public void average_ofNullArray_throwsIllegalArgumentException() {
        //GIVEN
        int[] values = null;
        AtaMath ataMath = new AtaMath();
        //WHEN - attempt to compute the average
        //THEN - exception thrown
        Assertions.assertThrows(IllegalArgumentException.class, () ->
            ataMath.average(values), "Averaging null should result in IllegalArgumentException thrown");
    }

    @Test
    public void average_ofPositiveAndNegativeIntegers_isCorrect() {
        //GIVEN
        int[] posAndNegValues = {-3, 9, -3};
        AtaMath ataMath = new AtaMath();

        //WHEN
        double result = ataMath.average(posAndNegValues);

        //THEN
        Assertions.assertEquals(1, result, String.format(
                "Expected averaging values in array %s to return their average (1)",
                Arrays.toString(posAndNegValues)));
    }

    @Test
    public void average_ofIntegersIncludingZeroes_isCorrect() {
        //GIVEN
        int[] includesZeroes = {0, 1, 2};
        AtaMath ataMath = new AtaMath();

        //WHEN
        double result = ataMath.average(includesZeroes);

        //THEN
        Assertions.assertEquals(1, result, String.format(
                "Expected averaging values in array %s to return their average (1)",
                Arrays.toString(includesZeroes)));
    }

    @Test
    public void average_ofEmptyArray_throwsIllegalArgumentException() {
        //GIVEN
        int[] emptyArray = {};
        AtaMath ataMath = new AtaMath();

        //WHEN - attempt to compute the average
        //THEN - exception thrown
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                ataMath.average(emptyArray), "Averaging empty array should result in IllegalArgumentException thrown");
    }

    @Test
    public void average_ofLargeNumbersThatOverflow_throwsArithmeticException() {

    }
}
