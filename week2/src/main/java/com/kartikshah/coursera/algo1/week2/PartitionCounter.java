package com.kartikshah.coursera.algo1.week2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by kartik on 2/2/15.
 */
public class PartitionCounter
{
    List<Integer> readInput(FileReader fileReader){
        try(BufferedReader reader = new BufferedReader(fileReader)){
            return reader
                    .lines()
                    .map(line -> new Integer(line))
                    .collect(Collectors.toList());

        }catch(IOException ioException){
            //TODO: Implement
        }
        return null;
    }

    Long quickSort(List<Integer> input, Integer length, QuickSortPivotStrategy pivotStrategy){
        if (length == 1) return 0L;

        Integer pivotIndex = pivotStrategy.choosePivot(input);

        if (pivotIndex != 0) {
            Collections.swap(input,0, pivotIndex);
            pivotIndex = 0;
        }
        Integer partitionIndex = partitionArray(input, pivotIndex, length);
        Long count = (input.size() - 1L > 0)?(input.size()-1L):0L;

        Long countLeft = 0L;
        if(pivotIndex != partitionIndex-1)
        {
            List<Integer> partitionOne = input.subList(pivotIndex, partitionIndex - 1);
            countLeft = quickSort(partitionOne, partitionOne.size(), pivotStrategy);
        }

        Long countRight = 0L;
        if(partitionIndex != length)
        {
            List<Integer> partitionTwo = input.subList(partitionIndex, length);
            countRight = quickSort(partitionTwo, partitionTwo.size(), pivotStrategy);
        }
        return count.longValue() + countLeft.longValue() + countRight.longValue();
    }

    Integer partitionArray(List<Integer> input, Integer left, Integer right)
    {
        if (left < right)
        {
            Integer pivotValue = input.get(left);
            Integer i = left + 1;
            for (int j = left + 1; j < right; j++)
            {
                if (input.get(j) < pivotValue)
                {
                    Collections.swap(input,i, j);
                    i = i + 1;
                }
            }
            Collections.swap(input, left, i-1);
            return i;
        }
        return left;
   }
}