package com.kartikshah.coursera.algo1.week5;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * Created by kartik on 2/27/15.
 */
public class TestDijkstraGraph
{
    @Test
    public void testReadInputNotNull() throws Exception
    {
        DirectedGraph graph = new DirectedGraph();
        graph.readFile(new FileReader(new File("").getAbsolutePath() + "/src/test/resources/testcase1.txt"));
        System.out.println(graph);
    }

    @Test
    public void testTestcase1() throws Exception
    {
        DirectedGraph graph = new DirectedGraph();
        graph.readFile(new FileReader(new File("").getAbsolutePath() + "/src/test/resources/testcase1.txt"));
        graph.findShortestPath(1L);
    }

    @Test
    public void testTestcase2() throws Exception
    {
        DirectedGraph graph = new DirectedGraph();
        graph.readFile(new FileReader(new File("").getAbsolutePath() + "/src/test/resources/testcase2.txt"));
        graph.findShortestPath(1L);
    }

    @Test
    public void testTestcase3() throws Exception
    {
        DirectedGraph graph = new DirectedGraph();
        graph.readFile(new FileReader(new File("").getAbsolutePath() + "/src/test/resources/testcase3.txt"));
        graph.findShortestPath(1L);
    }

    @Test
    public void testTestcase4() throws Exception
    {
        DirectedGraph graph = new DirectedGraph();
        graph.readFile(new FileReader(new File("").getAbsolutePath() + "/src/test/resources/testcase4.txt"));
        graph.findShortestPath(1L);
    }

    @Test
    public void testTestcase5() throws Exception
    {
        DirectedGraph graph = new DirectedGraph();
        graph.readFile(new FileReader(new File("").getAbsolutePath() + "/src/test/resources/testcase5.txt"));
        graph.findShortestPath(0L);
    }

    @Test
    public void testTestcase6() throws Exception
    {
        DirectedGraph graph = new DirectedGraph();
        graph.readFile(new FileReader(new File("").getAbsolutePath() + "/src/test/resources/testcase6.txt"));
        graph.findShortestPath(0L);
    }


    @Test
    public void testTestcaseFinal() throws Exception
    {
        DirectedGraph graph = new DirectedGraph();
        graph.readFile(new FileReader(new File("").getAbsolutePath() + "/src/test/resources/dijkstraData.txt"));
        graph.findShortestPath(1L);
        List<Long> longList = Arrays.asList(7L,37L,59L,82L,99L,115L,133L,165L,188L,197L);

        for(Map.Entry<Long, Long> entrySet : graph.getMinimumPathLength().entrySet()){
            if(longList.contains(entrySet.getKey().longValue())){
                System.out.println("Key: " + entrySet.getKey() + " Path: " + entrySet.getValue());
            }
        }
    }
}
