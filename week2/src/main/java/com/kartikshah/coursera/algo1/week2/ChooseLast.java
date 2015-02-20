package com.kartikshah.coursera.algo1.week2;

import java.util.List;

/**
 * Created by kartik on 2/3/15.
 */
public class ChooseLast implements QuickSortPivotStrategy
{
    public Integer choosePivot(List<Integer> list){
        return list.size()-1;
    }
}
