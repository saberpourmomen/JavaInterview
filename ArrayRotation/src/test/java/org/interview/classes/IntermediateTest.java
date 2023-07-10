package org.interview.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IntermediateTest {

    @Test
    public void whenOutputArrayTestWillReturnsInvalidInput() throws Exception {
        Intermediate intermediate = new Intermediate();
        intermediate.setInputArray(new ArrayList<>());
        Assertions.assertThrows(IllegalArgumentException.class, intermediate::getOutputArray);
    }

    @Test
    public void whenOutputArrayTestWillReturnsInvalidRate() throws Exception {
        Intermediate intermediate = new Intermediate();
        intermediate.setInputArray(Arrays.stream(new int[]{1, 2, 3, 4, 5, 6}).boxed().collect(Collectors.toList()));
        Assertions.assertThrows(IllegalArgumentException.class, intermediate::getOutputArray);
    }

    @Test
    public void whenOutputArrayTestWillReturnsOutput() throws Exception {
        Intermediate intermediate = new Intermediate();
        List<Integer> input = Arrays.stream(new int[]{1, 2, 3, 4, 5, 6, 7, 8}).boxed().collect(Collectors.toList());
        intermediate.setInputArray(input);
        intermediate.setRate(3);
        List<Integer> result = Arrays.stream(new int[]{3, 2, 1, 6, 5, 4, 8, 7}).boxed().collect(Collectors.toList());
        Assertions.assertAll(
                () -> Assertions.assertEquals(intermediate.getRate(), 3),
                () -> Assertions.assertEquals(intermediate.getInputArray(), input),
                () -> Assertions.assertEquals(true, intermediate.getOutputArray().equals(result))
        );
    }

    @Test
    public void whenBigRateTestWillReturnsOutput() throws Exception {
        Intermediate intermediate = new Intermediate();
        intermediate.setInputArray(Arrays.stream(new int[]{1, 2, 3}).boxed().collect(Collectors.toList()));
        intermediate.setRate(4);
        List<Integer> result = Arrays.stream(new int[]{3, 2, 1}).boxed().collect(Collectors.toList());
        Assertions.assertEquals(true, intermediate.getOutputArray().equals(result));
    }

}
