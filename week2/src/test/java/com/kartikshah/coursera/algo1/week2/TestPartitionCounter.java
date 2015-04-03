package com.kartikshah.coursera.algo1.week2;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

/**
 * Created by kartik on 2/2/15.
 */
public class TestPartitionCounter
{
    @Test
    public void testReadInputNotNull() throws Exception
    {
        PartitionCounter counter = new PartitionCounter();
        assertNotNull(counter.readInput(new FileReader(new File("").getAbsolutePath() + "/src/test/resources/input1.txt")));
    }

    @Test
    public void testReadInputSixElement() throws Exception
    {
        PartitionCounter counter = new PartitionCounter();
        List<Integer> integers = counter.readInput(new FileReader(new File("").getAbsolutePath() + "/src/test/resources/input1.txt"));
        assertEquals(6, integers.size());
    }

    @Test
    public void testQuickSort() throws Exception
    {
        PartitionCounter counter = new PartitionCounter();
        List<Integer> list = Arrays.asList(3, 1, 2, 5, 4, 7, 8, 10);
        counter.quickSort(list, list.size(), new ChooseFirst());
    }

    @Test
    public void testQuickSortChooseFirst10Elements() throws Exception
    {
        PartitionCounter counter = new PartitionCounter();
        List<Integer> list = Arrays.asList(3,9,8,4,6,10,2,5,7,1);
        long numberOfComparisions = counter.quickSort(list, list.size(), new ChooseFirst());
        assertEquals(25L, numberOfComparisions);
    }

    @Test
    public void testQuickSortChooseLast10Elements() throws Exception
    {
        PartitionCounter counter = new PartitionCounter();
        List<Integer> list = Arrays.asList(3,9,8,4,6,10,2,5,7,1);
        long numberOfComparisions = counter.quickSort(list, list.size(), new ChooseLast());
        assertEquals(29L, numberOfComparisions);
    }

    @Test
    public void testQuickSortChooseMedian10Elements() throws Exception
    {
        PartitionCounter counter = new PartitionCounter();
        List<Integer> list = Arrays.asList(3,9,8,4,6,10,2,5,7,1);
        long numberOfComparisions = counter.quickSort(list, list.size(), new ChooseMedian());
        assertEquals(21L, numberOfComparisions);
    }


    @Test
    public void testQuickSortChooseFirst4Elements() throws Exception
    {
        PartitionCounter counter = new PartitionCounter();
        List<Integer> list = Arrays.asList(3,9,8,4);
        long numberOfComparisions = counter.quickSort(list, list.size(), new ChooseFirst());
        assertEquals(6L, numberOfComparisions);
    }

    @Test
    public void testQuickSortTestInputChooseFirst() throws Exception
    {
        PartitionCounter counter = new PartitionCounter();
        List<Integer> integers = counter.readInput(new FileReader(new File("").getAbsolutePath() + "/src/test/resources/QuickSort.txt"));
        long numberOfComparisions = counter.quickSort(integers, integers.size(), new ChooseFirst());
        System.out.println("Choose First: " + numberOfComparisions);
        assertEquals(162085L, numberOfComparisions);

    }

    @Test
    public void testQuickSortTestInputChooseLast() throws Exception
    {
        PartitionCounter counter = new PartitionCounter();
        List<Integer> integers = counter.readInput(new FileReader(new File("").getAbsolutePath() + "/src/test/resources/QuickSort.txt"));
        long numberOfComparisions = counter.quickSort(integers, integers.size(), new ChooseLast());
        System.out.println("Choose Last: " + numberOfComparisions);
        assertEquals(164123L, numberOfComparisions);

    }

    @Test
    public void testQuickSortTestInputChooseMedian() throws Exception
    {
        PartitionCounter counter = new PartitionCounter();
        List<Integer> integers = counter.readInput(new FileReader(new File("").getAbsolutePath() + "/src/test/resources/QuickSort.txt"));
        long numberOfComparisions = counter.quickSort(integers, integers.size(), new ChooseMedian());
        System.out.println("Choose Median: " + numberOfComparisions);
        assertEquals(138382L, numberOfComparisions);
    }

    @Test
    public void testQuickSort100InputChooseFirst() throws Exception
    {
        PartitionCounter counter = new PartitionCounter();
        List<Integer> integers = counter.readInput(new FileReader(new File("").getAbsolutePath() + "/src/test/resources/100.txt"));
        long numberOfComparisions = counter.quickSort(integers, integers.size(), new ChooseFirst());
        System.out.println("Size 100 - Choose First: " + numberOfComparisions);
        assertEquals(615L, numberOfComparisions);
    }

    @Test
    public void testQuickSort100InputChooseLast() throws Exception
    {
        PartitionCounter counter = new PartitionCounter();
        List<Integer> integers = counter.readInput(new FileReader(new File("").getAbsolutePath() + "/src/test/resources/100.txt"));
        long numberOfComparisions = counter.quickSort(integers, integers.size(), new ChooseLast());
        System.out.println("Size 100 - Choose Last: " + numberOfComparisions);
        assertEquals(587L, numberOfComparisions);
    }

    @Test
    public void testQuickSort100InputChooseMedian() throws Exception
    {
        PartitionCounter counter = new PartitionCounter();
        List<Integer> integers = counter.readInput(new FileReader(new File("").getAbsolutePath() + "/src/test/resources/100.txt"));
        long numberOfComparisions = counter.quickSort(integers, integers.size(), new ChooseMedian());
        System.out.println("Size 100 - Choose Median: " + numberOfComparisions);
        assertEquals(518L, numberOfComparisions);
    }

    @Test
    public void testQuickSort1000InputChooseFirst() throws Exception
    {
        PartitionCounter counter = new PartitionCounter();
        List<Integer> integers = counter.readInput(new FileReader(new File("").getAbsolutePath() + "/src/test/resources/1000.txt"));
        long numberOfComparisions = counter.quickSort(integers, integers.size(), new ChooseFirst());
        System.out.println("Size 1000 - Choose First: " + numberOfComparisions);
        assertEquals(10297L, numberOfComparisions);
    }

    @Test
    public void testQuickSort1000InputChooseLast() throws Exception
    {
        PartitionCounter counter = new PartitionCounter();
        List<Integer> integers = counter.readInput(new FileReader(new File("").getAbsolutePath() + "/src/test/resources/1000.txt"));
        long numberOfComparisions = counter.quickSort(integers, integers.size(), new ChooseLast());
        System.out.println("Size 1000 - Choose Last: " + numberOfComparisions);
        assertEquals(10184L, numberOfComparisions);

    }

    @Test
    public void testQuickSort1000InputChooseMedian() throws Exception
    {
        PartitionCounter counter = new PartitionCounter();
        List<Integer> integers = counter.readInput(new FileReader(new File("").getAbsolutePath() + "/src/test/resources/1000.txt"));
        long numberOfComparisions = counter.quickSort(integers, integers.size(), new ChooseMedian());
        System.out.println("Size 1000 - Choose Median: " + numberOfComparisions);
        assertEquals(8921L, numberOfComparisions);
    }


}
