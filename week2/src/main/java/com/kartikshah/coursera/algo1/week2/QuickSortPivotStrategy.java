package com.kartikshah.coursera.algo1.week2;

import java.util.List;

/**
 * Created by kartik on 2/3/15.
 */
@FunctionalInterface
public interface QuickSortPivotStrategy
{
    Integer choosePivot(List<Integer> input);
}
