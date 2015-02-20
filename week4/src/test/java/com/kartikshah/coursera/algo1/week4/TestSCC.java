package com.kartikshah.coursera.algo1.week4;

import org.junit.Test;

import java.io.FileReader;
import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

/**
 * Created by kartik on 2/18/15.
 */
public class TestSCC
{
    @Test
    public void testReadInputNotNull() throws Exception
    {
        DirectedGraph graph = new DirectedGraph();
        graph.readFile(new FileReader("/Users/kartik/dev/code/algo1/week4/src/test/resources/testcase1.txt"));
//        System.out.println(graph);
    }

    @Test
    public void testSCC1() throws Exception
    {
        System.out.println("testcase1.txt");
        DirectedGraph graph = new DirectedGraph();
        graph.readFile(new FileReader("/Users/kartik/dev/code/algo1/week4/src/test/resources/testcase1.txt"));
        graph.scc();
    }

    @Test
    public void testSCC2() throws Exception
    {
        System.out.println("testcase2.txt");
        DirectedGraph graph = new DirectedGraph();
        graph.readFile(new FileReader("/Users/kartik/dev/code/algo1/week4/src/test/resources/testcase2.txt"));
        graph.scc();
    }

    @Test
    public void testSCC3() throws Exception
    {
        System.out.println("testcase3.txt");
        DirectedGraph graph = new DirectedGraph();
        graph.readFile(new FileReader("/Users/kartik/dev/code/algo1/week4/src/test/resources/testcase3.txt"));
        graph.scc();
    }

    @Test
    public void testSCC4() throws Exception
    {
        System.out.println("testcase4.txt");
        DirectedGraph graph = new DirectedGraph();
        graph.readFile(new FileReader("/Users/kartik/dev/code/algo1/week4/src/test/resources/testcase4.txt"));
        graph.scc();
    }

    @Test
    public void testSCC5() throws Exception
    {
        System.out.println("testcase5.txt");
        DirectedGraph graph = new DirectedGraph();
        graph.readFile(new FileReader("/Users/kartik/dev/code/algo1/week4/src/test/resources/testcase5.txt"));
        graph.scc();
    }

    @Test
    public void testSCCMediumDG() throws Exception
    {
        System.out.println("mdeiumDG.txt");
        DirectedGraph graph = new DirectedGraph();
        graph.readFile(new FileReader("/Users/kartik/dev/code/algo1/week4/src/test/resources/mediumDG.txt"));
        graph.scc();
    }

    @Test
    public void testSCCFinal() throws Exception
    {
        System.out.println("SCC.txt");
        DirectedGraph graph = new DirectedGraph();
        graph.readFile(new FileReader("/Users/kartik/dev/code/algo1/week4/src/test/resources/SCC.txt"));
        graph.scc();
    }






}
