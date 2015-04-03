package com.kartikshah.coursera.algo1.week1;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class InversionCounterTest
{

    @Test
    public void testReadInputNotNull() throws Exception
    {
        InversionCounter counter = new InversionCounter();
        System.out.println(new File("").getAbsolutePath());
        assertNotNull(counter.readInput(new FileReader(new File("").getAbsolutePath() + "/src/test/resources/input1.txt")));
    }

    @Test
    public void testReadInputSixElement() throws Exception
    {
        InversionCounter counter = new InversionCounter();
        List<Integer> integers = counter.readInput(new FileReader(new File("").getAbsolutePath()+ "/src/test/resources/input1.txt"));
        assertEquals(6, integers.size());
    }

    @Test
    public void testCountInversion1() throws Exception
    {
        InversionCounter counter = new InversionCounter();
        List<Integer> integers = Arrays.asList(1,3,5,2,4,6);
        ListCountTuple result = counter.countInversion(integers, integers.size());
        assertEquals(3, result.getInversionCount().intValue());
        System.out.println(result.getInversionCount());
        System.out.println(result.getSortedList());
    }

    @Test
    public void testCountInversion2() throws Exception
    {
        InversionCounter counter = new InversionCounter();
        List<Integer> integers = Arrays.asList(1,2,3,4,5,6);
        ListCountTuple result = counter.countInversion(integers, integers.size());
        assertEquals(0, result.getInversionCount().intValue());
        System.out.println(result.getInversionCount());
        System.out.println(result.getSortedList());
    }

    @Test
    public void testCountInversion3() throws Exception
    {
        InversionCounter counter = new InversionCounter();
        List<Integer> integers = Arrays.asList(6,5,4,3,2,1);
        ListCountTuple result = counter.countInversion(integers, integers.size());
        System.out.println(result.getInversionCount());
        System.out.println(result.getSortedList());
        assertEquals(15, result.getInversionCount().intValue());

    }

    @Test
    public void testCountInversion4() throws Exception
    {
        InversionCounter counter = new InversionCounter();
        List<Integer> integers = Arrays.asList(6,5,4,3,2);
        ListCountTuple result = counter.countInversion(integers, integers.size());
        System.out.println(result.getInversionCount());
        System.out.println(result.getSortedList());
        assertEquals(10, result.getInversionCount().intValue());
    }

    @Test
    public void testCountInversion5() throws Exception
    {
        InversionCounter counter = new InversionCounter();
        List<Integer> integers = Arrays.asList(6,5,4,2,2);
        ListCountTuple result = counter.countInversion(integers, integers.size());
        System.out.println(result.getInversionCount());
        System.out.println(result.getSortedList());
        assertEquals(9, result.getInversionCount().intValue());
    }

    @Test
    public void testCountInversion6() throws Exception
    {
        InversionCounter counter = new InversionCounter();
        List<Integer> integers = Arrays.asList(37, 7, 2, 14, 35, 47, 10, 24, 44, 17, 34, 11, 16, 48, 1, 39, 6, 33, 43, 26, 40, 4, 28, 5, 38, 41, 42, 12, 13, 21, 29, 18, 3, 19, 0, 32, 46, 27, 31, 25, 15, 36, 20, 8, 9, 49, 22, 23, 30, 45);
        ListCountTuple result = counter.countInversion(integers, integers.size());
        System.out.println(result.getInversionCount());
        System.out.println(result.getSortedList());
        assertEquals(590, result.getInversionCount().intValue());
    }

    @Test
    public void testCountInversion7() throws Exception
    {
        InversionCounter counter = new InversionCounter();
        List<Integer> integers = Arrays.asList(9, 12, 3, 1, 6, 8, 2, 5, 14, 13, 11, 7, 10, 4, 0);
        ListCountTuple result = counter.countInversion(integers, integers.size());
        System.out.println(result.getInversionCount());
        System.out.println(result.getSortedList());
        assertEquals(56, result.getInversionCount().intValue());
    }


    @Test
    public void testCountInversion8() throws Exception
    {
        InversionCounter counter = new InversionCounter();
        List<Integer> integers = Arrays.asList(4, 80, 70, 23, 9, 60, 68, 27, 66, 78, 12, 40, 52, 53, 44, 8, 49, 28, 18, 46, 21, 39, 51, 7, 87, 99, 69, 62, 84, 6, 79, 67, 14, 98, 83, 0, 96, 5, 82, 10, 26, 48, 3, 2, 15, 92, 11, 55, 63, 97, 43, 45, 81, 42, 95, 20, 25, 74, 24, 72, 91, 35, 86, 19, 75, 58, 71, 47, 76, 59, 64, 93, 17, 50, 56, 94, 90, 89, 32, 37, 34, 65, 1, 73, 41, 36, 57, 77, 30, 22, 13, 29, 38, 16, 88, 61, 31, 85, 33, 54);
        ListCountTuple result = counter.countInversion(integers, integers.size());
        System.out.println(result.getInversionCount());
        System.out.println(result.getSortedList());
        assertEquals(2372, result.getInversionCount().intValue());
    }

    @Test
    public void testAssignment() throws Exception
    {
        long startTime = System.currentTimeMillis();
        InversionCounter counter = new InversionCounter();
        List<Integer> integers = counter.readInput(new FileReader(new File("").getAbsolutePath() + "/src/test/resources/IntegerArray.txt"));
        long stepOneTime = System.currentTimeMillis();
        ListCountTuple result = counter.countInversion(integers, integers.size());
        long endTime = System.currentTimeMillis();
        System.out.println(result.getSortedList());
        System.out.println(result.getInversionCount());
        System.out.println("End : " + endTime);
        System.out.println("Total Runtime : " +  (endTime - startTime));
        System.out.println("Inversion Runtime : " + (endTime - stepOneTime));

    }
}