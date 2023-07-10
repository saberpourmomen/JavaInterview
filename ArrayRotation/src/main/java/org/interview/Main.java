package org.interview;

import org.interview.classes.Intermediate;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        Intermediate intermediate=new Intermediate();
        intermediate.setRate(3);
        intermediate.setInputArray(Arrays.stream(new int[]{1, 2, 3, 4, 5, 6,7,8}).boxed().collect(Collectors.toList()));
        intermediate.getOutputArray().forEach(System.out::print);
    }
}