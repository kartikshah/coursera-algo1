package com.kartikshah.coursera.algo1.week6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by kartik on 3/4/15.
 */
public class SumTwo
{
    public Map<Long, Long> readInput(FileReader fileReader){
        try(BufferedReader reader = new BufferedReader(fileReader)){
            Map<Long, Long> map = reader.lines().distinct().collect(Collectors.toMap(Long::parseLong, line -> Long.parseLong(line)));
            return map;
        }catch(IOException iOException){
            //TODO: Implement
        }
        return null;
    }



    public Map<Long, List<Set<Long>>> findTwoSum(Map<Long, Long> map)
    {
        Map<Long, List<Set<Long>>> result = new HashMap<>();

        for (long t = -10000; t <= 10000; t++)
        {
            System.out.println("Working on t = " + t);
            for (Map.Entry<Long, Long> mapEntry : map.entrySet())
            {
                Long tMinusX = map.get(t - mapEntry.getKey());
                if (tMinusX != null)
                {
                    Set<Long> thisSet = new HashSet<>();
                    thisSet.add(mapEntry.getKey());
                    thisSet.add(tMinusX);

                    if(thisSet.size() == 2 && !result.values().contains(thisSet)){
                        List<Set<Long>> thisTList = result.get(t);
                        if(thisTList != null){
                            thisTList.add(thisSet);
                            result.put(t, thisTList);
                        }else{
                            thisTList = new ArrayList<>();
                            thisTList.add(thisSet);
                            result.put(t, thisTList);
                        }
                    }
                }
            }
        }
        System.out.println(result);
        return result;
    }
}
