package com.kartikshah.coursera.algo1.week1;

import java.util.List;

/**
 * Created by kartik on 1/25/15.
 */
public class ListCountTuple
{
    private List<Integer> sortedList;
    private Long inversionCount;

    public List<Integer> getSortedList()
    {
        return sortedList;
    }

    public void setSortedList(List<Integer> sortedList)
    {
        this.sortedList = sortedList;
    }

    public Long getInversionCount()
    {
        return inversionCount;
    }

    public void setInversionCount(Long inversionCount)
    {
        this.inversionCount = inversionCount;
    }

    public ListCountTuple(List<Integer> sortedList, Long inversionCount)
    {
        this.sortedList = sortedList;
        this.inversionCount = inversionCount;
    }


}
