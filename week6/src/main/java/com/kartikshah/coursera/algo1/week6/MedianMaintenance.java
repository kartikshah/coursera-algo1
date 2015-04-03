package com.kartikshah.coursera.algo1.week6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by kartik on 3/4/15.
 */
public class MedianMaintenance
{
    public Map<Integer, Long> findMedian(FileReader fileReader){
        try(BufferedReader reader = new BufferedReader(fileReader)){
            String line = reader.readLine();
            List<Long> elementArray = new ArrayList<>();
            Map<Integer, Long> result = new HashMap<>();
            int i = 0;
            while (line != null){
                System.out.println("Getting... " + i);
                Long element = Long.parseLong(line);
                elementArray.add(i, element);
                Long medianElement = findMedianForThisIteration(elementArray.stream().sorted().collect(Collectors.toList()));
                result.put(i, medianElement);
                line = reader.readLine();
                i++;
            }
            return result;
        }catch (IOException ioException){
            //TODO: Implement later
        }
        return null;
    }

    public Long findMedianForThisIteration(List<Long> thisList){
        int size = thisList.size();
        System.out.println(thisList);
        if(size % 2 == 0) return thisList.get(size/2-1);
        return thisList.get((size+1)/2-1);
    }
}
