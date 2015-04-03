import junit.framework.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

/**
 * Created by kartik on 2/15/15.
 */

public class TestMinimumCutGraph
{
    @Test
    public void testReadInputNotNull() throws Exception
    {
        MinimumCutGraph graph = new MinimumCutGraph();
        assertNotNull(graph.readInput(new FileReader(new File("").getAbsolutePath() + "/src/test/resources/testcase1.txt")));
    }

    @Test
    public void testReadInputSixElement() throws Exception
    {
        MinimumCutGraph graph = new MinimumCutGraph();
        Map<Integer, List<Edge>> integers = graph.readInput(new FileReader("/Users/kartik/dev/code/algo1/week3/src/test/resources/testcase1.txt"));
        System.out.println(integers);
        assertEquals(8, integers.keySet().size());
    }

    @Test
    public void testDev() throws Exception
    {

        int minimumCut = 100;
        List<UniqueCut> minimumCuts = null;
        for (int iteration = 0; iteration < 5; iteration++){
            MinimumCutGraph graph = new MinimumCutGraph();
            Map<Integer, List<Edge>> g = graph.readInput(new FileReader(new File("").getAbsolutePath() + "/src/test/resources/testcase0.txt"));
            assertEquals(4, g.keySet().size());
            List<UniqueCut> cuts = graph.findMinimumCutGraph(g);
            int noOfcut = cuts.size();
            if (noOfcut < minimumCut){
                minimumCut = noOfcut;
                minimumCuts = cuts;
            }
        }
        System.out.println("**** Minimum Cuts : " + minimumCut);
        System.out.println("**** Cuts: " + minimumCuts);
        assertEquals(2, minimumCut);

    }

    @Test
    public void testCase1() throws Exception
    {

        int minimumCut = 100;
        List<UniqueCut> minimumCuts = null;

        for (int iteration = 0; iteration < 50; iteration++){
            MinimumCutGraph graph = new MinimumCutGraph();
            Map<Integer, List<Edge>> g = graph.readInput(new FileReader(new File("").getAbsolutePath() + "/src/test/resources/testcase1.txt"));
            List<UniqueCut> cuts = graph.findMinimumCutGraph(g);
            int noOfcut = cuts.size();
            if (noOfcut < minimumCut){
                minimumCut = noOfcut;
                minimumCuts = cuts;
            }
        }
        System.out.println("**** Minimum Cuts : " + minimumCut);
        System.out.println("**** Cuts: " + minimumCuts);        assertEquals(2, minimumCut);

    }

    @Test
    public void testCase2() throws Exception
    {

        int minimumCut = 100;
        List<UniqueCut> minimumCuts = null;

        for (int iteration = 0; iteration < 5; iteration++){
            MinimumCutGraph graph = new MinimumCutGraph();
            Map<Integer, List<Edge>> g = graph.readInput(new FileReader(new File("").getAbsolutePath() + "/src/test/resources/testcase2.txt"));
            List<UniqueCut> cuts = graph.findMinimumCutGraph(g);
            int noOfcut = cuts.size();
            if (noOfcut < minimumCut){
                minimumCut = noOfcut;
                minimumCuts = cuts;
            }
        }
        System.out.println("**** Minimum Cuts : " + minimumCut);
        System.out.println("**** Cuts: " + minimumCuts);        assertEquals(2, minimumCut);

    }

    @Test
    public void testCase3() throws Exception
    {

        int minimumCut = 100;
        List<UniqueCut> minimumCuts = null;

        for (int iteration = 0; iteration < 5; iteration++){
            MinimumCutGraph graph = new MinimumCutGraph();
            Map<Integer, List<Edge>> g = graph.readInput(new FileReader(new File("").getAbsolutePath() + "/src/test/resources/testcase3.txt"));
            List<UniqueCut> cuts = graph.findMinimumCutGraph(g);
            int noOfcut = cuts.size();
            if (noOfcut < minimumCut){
                minimumCut = noOfcut;
                minimumCuts = cuts;
            }
        }
        System.out.println("**** Minimum Cuts : " + minimumCut);
        System.out.println("**** Cuts: " + minimumCuts);        assertEquals(1, minimumCut);

    }

    @Test
    public void testCase4() throws Exception
    {

        int minimumCut = 100;
        List<UniqueCut> minimumCuts = null;

        for (int iteration = 0; iteration < 5; iteration++){
            MinimumCutGraph graph = new MinimumCutGraph();
            Map<Integer, List<Edge>> g = graph.readInput(new FileReader(new File("").getAbsolutePath() + "/src/test/resources/testcase4.txt"));
            List<UniqueCut> cuts = graph.findMinimumCutGraph(g);
            int noOfcut = cuts.size();
            if (noOfcut < minimumCut){
                minimumCut = noOfcut;
                minimumCuts = cuts;
            }
        }
        System.out.println("**** Minimum Cuts : " + minimumCut);
        System.out.println("**** Cuts: " + minimumCuts);        assertEquals(1, minimumCut);

    }

    @Test
    public void testCase5() throws Exception
    {

        int minimumCut = 100;
        List<UniqueCut> minimumCuts = null;

        for (int iteration = 0; iteration < 100; iteration++){
            MinimumCutGraph graph = new MinimumCutGraph();
            Map<Integer, List<Edge>> g = graph.readInput(new FileReader(new File("").getAbsolutePath() + "/src/test/resources/testcase5.txt"));
            List<UniqueCut> cuts = graph.findMinimumCutGraph(g);
            int noOfcut = cuts.size();
            if (noOfcut < minimumCut){
                minimumCut = noOfcut;
                minimumCuts = cuts;
            }
        }
        System.out.println("**** Minimum Cuts : " + minimumCut);
        System.out.println("**** Cuts: " + minimumCuts);
        assertEquals(3, minimumCut);

    }


    @Test
    public void testCase6() throws Exception
    {

        int minimumCut = 100;
        List<UniqueCut> minimumCuts = null;

        for (int iteration = 0; iteration < 5; iteration++){
            MinimumCutGraph graph = new MinimumCutGraph();
            Map<Integer, List<Edge>> g = graph.readInput(new FileReader(new File("").getAbsolutePath() + "/src/test/resources/testcase6.txt"));
            List<UniqueCut> cuts = graph.findMinimumCutGraph(g);
            int noOfcut = cuts.size();
            if (noOfcut < minimumCut){
                minimumCut = noOfcut;
                minimumCuts = cuts;
            }
        }
        System.out.println("**** Minimum Cuts : " + minimumCut);
        System.out.println("**** Cuts: " + minimumCuts);
        assertEquals(2, minimumCut);

    }

    @Test
    public void testCaseFinal() throws Exception
    {

        int minimumCut = 200;
        List<UniqueCut> minimumCuts = null;

        for (int iteration = 0; iteration < 1000; iteration++){
            MinimumCutGraph graph = new MinimumCutGraph();
            Map<Integer, List<Edge>> g = graph.readInput(new FileReader(new File("").getAbsolutePath() + "/src/test/resources/kargerMinCut.txt"));
            List<UniqueCut> cuts = graph.findMinimumCutGraph(g);
            int noOfcut = cuts.size();
            if (noOfcut < minimumCut){
                minimumCut = noOfcut;
                minimumCuts = cuts;
            }
        }
        System.out.println("**** Minimum Cuts : " + minimumCut);
        System.out.println("**** Cuts: " + minimumCuts);
        assertEquals(17, minimumCut);

    }


}
