import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by kartik on 2/15/15.
 */
public class MinimumCutGraph
{
    Random random = new Random();

    public Map<Integer, List<Edge>> parseLine(String eachLine)
    {
        Map<Integer, List<Edge>> adjNode = new HashMap<>();
        List<String> nodeLine1 = Arrays.asList(eachLine.split("(\\s)+"));
        Integer node1 = Integer.parseInt(nodeLine1.stream().findFirst().get());
        List<Edge> edgeList = nodeLine1.stream().skip(1).map(edge -> new Edge(Integer.parseInt(edge))).collect(Collectors.toList());
        adjNode.put(node1, edgeList);
        return adjNode;
    }

    Map<Integer, List<Edge>> readInput(FileReader fileReader)
    {
        Map<Integer, List<Edge>> flattenGraph = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(fileReader))
        {
            List<Map<Integer, List<Edge>>> graph = reader
                    .lines()
                    .map(line -> parseLine(line))
                    .collect(Collectors.toList());

            for (Map<Integer, List<Edge>> graphElement : graph) {
                flattenGraph.putAll(graphElement);
            }

        } catch (IOException ioException){
            System.out.println("IOException reading Input file.");

        }
        return flattenGraph;
    }

    List<UniqueCut> findMinimumCutGraph(Map<Integer, List<Edge>> graph){

        List<List<Integer>> verticesList = new ArrayList<>();

        for (Integer vertices : graph.keySet()){
            List<Integer> list = new ArrayList<>();
            list.add(vertices);
            verticesList.add(list);
        }

        while(verticesList.size() > 2){
            List<Integer> keySetList = new ArrayList<>(graph.keySet());
            Integer v1 =  keySetList.get(selectRandomIndex(graph.keySet().size()));

            List<Integer> verticeSetOne = new ArrayList<>();
            for (int i=0; i< verticesList.size(); i++){
                List<Integer> vertices = verticesList.get(i);
                if (vertices.contains(v1))
                {
                    verticeSetOne = vertices;
                    break;
                }
            }

            List<Edge> edges = graph.get(v1);
            List<Edge> filteredEdgeList = edges.stream().filter(Edge::isNotMarked).collect(Collectors.toList());
            if (filteredEdgeList.size() == 0) continue;
            Integer v2 =  filteredEdgeList.get(selectRandomIndex(filteredEdgeList.size())).getToNode();

            List<Integer> verticeSetTwo = new ArrayList<>();
            int verticesSetTwoIndex = -1;
            for (int i=0; i< verticesList.size(); i++){
                List<Integer> vertices = verticesList.get(i);
                if (vertices.contains(v2))
                {
                    verticesSetTwoIndex = i;
                    verticeSetTwo = vertices;
                    break;
                }
            }

            for (Integer v1s: verticeSetOne) {
                List<Edge> e1 = graph.get(v1s);
                cleanupEdges(e1, verticeSetTwo);
            }

            for(Integer v2s: verticeSetTwo) {
                List<Edge> e2 = graph.get(v2s);
                cleanupEdges(e2,verticeSetOne);
            }

            verticeSetOne.addAll(verticeSetTwo);
            verticesList.remove(verticesSetTwoIndex);
        }
        return countMinCut(graph);
    }

    void cleanupEdges(List<Edge> edges, List<Integer> verticesSet){
        for (Edge e1: edges){
            if(verticesSet.contains(e1.getToNode()))
                e1.setMarked(true);
        }
    }

    public List<UniqueCut> countMinCut(Map<Integer, List<Edge>> graph){
        List<UniqueCut> uniqueCuts = new ArrayList<>();
        for (Integer key : graph.keySet()){
            List<Edge> edgeList = graph.get(key).stream().filter(Edge::isNotMarked).collect(Collectors.toList());
            for (Edge e :edgeList) {
                UniqueCut cut = new UniqueCut(key, e.getToNode());
                if(!isPresent(uniqueCuts, cut)){
                    uniqueCuts.add(cut);
                }
            }
        }
        return uniqueCuts;
    }

    public boolean isPresent(List<UniqueCut> uniqueCutList, UniqueCut cut){
        for(UniqueCut thisCut: uniqueCutList){
            if(thisCut.isEqualTo(cut)) return true;
        }
        return false;
    }

    public Integer selectRandomIndex(int size){
        return random.nextInt(size);
    }
}