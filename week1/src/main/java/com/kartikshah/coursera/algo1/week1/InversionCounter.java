package com.kartikshah.coursera.algo1.week1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by kartik on 1/25/15.
 */
public class InversionCounter
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

    ListCountTuple countInversion(List<Integer> integerList, Integer length){
        if (length == 1) return new ListCountTuple(integerList, 0L);
        List<Integer> partitionOne = integerList.subList(0, integerList.size()/2);
        List<Integer> partitionTwo = integerList.subList(length/2, length);
        ListCountTuple b = countInversion(partitionOne, partitionOne.size());
        ListCountTuple c = countInversion(partitionTwo, partitionTwo.size());
        ListCountTuple d = countSplitInversion(b.getSortedList(), c.getSortedList(), length);
        return new ListCountTuple(d.getSortedList(), b.getInversionCount() + c.getInversionCount() + d.getInversionCount());
    }

    ListCountTuple countSplitInversion(List<Integer> bList, List<Integer> cList, Integer length){
        int i = 0; int j = 0;
        long count = 0;

        List<Integer> result = new ArrayList<>();
        for (int k = 0; k < length; k++) {
            if (bList.get(i) < cList.get(j)){
                result.add(k, bList.get(i));
                i++;
                if (i >= bList.size()) break;
            }
            else if (cList.get(j) < bList.get(i)){
                result.add(k, cList.get(j));
                j++;
                count += bList.size() - i;
                if (j >= cList.size()) break;
            }
        }

        if (i < bList.size()) result.addAll(bList.subList(i, bList.size()));
        if (j < cList.size()) result.addAll(cList.subList(j, cList.size()));

        return new ListCountTuple(result, count);
    }
}
