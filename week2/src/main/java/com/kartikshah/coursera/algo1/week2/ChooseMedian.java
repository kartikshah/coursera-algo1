package com.kartikshah.coursera.algo1.week2;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by kartik on 2/3/15.
 */
public class ChooseMedian implements QuickSortPivotStrategy
{
    public Integer choosePivot(List<Integer> list){
        int first = list.get(0);
        int middleIndex = (list.size() % 2 == 0)?(list.size()/2-1):((list.size()-1)/2);
        int middle = list.get(middleIndex);
        int last = list.get(list.size()-1);
        List<Integer> list1 = Arrays.asList(first, middle, last);
        Collections.sort(list1);
        int returnIndex = list1.get(1)==first?0:list1.get(1)==last?list.size()-1:middleIndex;
//        System.out.println(returnIndex);
        return returnIndex;
    }
}
