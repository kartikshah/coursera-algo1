package com.kartikshah.coursera.algo1.week5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by kartik on 2/18/15.
 */
public class DirectedGraph
{
    private Map<Long, Node> nodes;
    private Map<Long, Node> processedNode;

    public Map<Long, Long> getMinimumPathLength()
    {
        return minimumPathLength;
    }

    public void setMinimumPathLength(Map<Long, Long> minimumPathLength)
    {
        this.minimumPathLength = minimumPathLength;
    }

    private Map<Long, Long> minimumPathLength;

    public DirectedGraph()
    {
        this.nodes = new HashMap<>();
        this.processedNode = new HashMap<>();
        this.minimumPathLength = new HashMap<>();
    }

    public void parseLine(String line){
        List<String> nodeLine1 = Arrays.asList(line.split("(\\s)+"));
        Long nodeValue = Long.parseLong(nodeLine1.stream().findFirst().get());

        List<String> edges = nodeLine1.stream().skip(1).collect(Collectors.toList());

        for(String edgeStr : edges){

            String[] edgeWithWeight = edgeStr.split(",");
            Long edgeValue = Long.parseLong(edgeWithWeight[0]);
            Long weightValue = Long.parseLong(edgeWithWeight[1]);
            Node thisNode = nodes.get(nodeValue);

            if (thisNode == null) {
                thisNode = new Node(nodeValue);
                nodes.put(nodeValue, thisNode);
            }
            Node toNode = nodes.get(edgeValue);
            if (toNode == null) {
                toNode = new Node(edgeValue);
                nodes.put(edgeValue, toNode);
            }
            thisNode.addEdge(edgeValue, new Edge(toNode, weightValue));
        }
    }

    public void readFile(FileReader fileReader){
        try (BufferedReader reader = new BufferedReader(fileReader))
        {
            reader.lines()
                    .forEach(line -> parseLine(line));

        } catch (IOException ioException){
            //TODO: Implement
        }
    }

    public void findShortestPath(Long sourceLabel){
        System.out.println(nodes);
        Node source = nodes.get(sourceLabel);
        minimumPathLength.put(sourceLabel,0L);
        System.out.println(source);
        source.setExplored(true);
        while (nodes.values().stream().filter(node -> !node.isExplored()).count() > 0) {
            System.out.println(nodes.values().stream().filter(node -> !node.isExplored()).count());
            System.out.println(nodes);
            loop();
        }
        System.out.println(minimumPathLength);
    }

    public void loop(){
        Node fromNode = null;
        Edge minEdge = null;
        long minDist = 1000000;
        for (Node node : nodes.values())
        {
            if(node.isExplored())
            {
                for (Edge edge : node.getEdges().values())
                {
                    if (!edge.getToNode().isExplored())
                    {
                        if (minimumPathLength.get(node.getLabel()) + edge.getLength() <= minDist)
                        {
                            minDist = minimumPathLength.get(node.getLabel()) + edge.getLength();
                            minEdge = edge;
                            fromNode = node;
                        }
                    }
                }
            }
        }
        if(minEdge != null)
        {
            Long currentNodePathLength = minimumPathLength.get(fromNode.getLabel());
            System.out.println("MinEdge:" + minEdge +" From Node:" + fromNode.getLabel() + " currentNodePathLength:" + currentNodePathLength);
            minimumPathLength.put(minEdge.getToNode().getLabel(),  minDist);
            processedNode.put(minEdge.getToNode().getLabel(), minEdge.getToNode());
            minEdge.getToNode().setExplored(true);
        }else{
            System.out.println("Not Found");
        }
    }

    public void resetExplored(){
        for (Node node : nodes.values()) node.setExplored(false);
    }



    @Override
    public String toString()
    {
        return "{" + nodes.values() + '}';
    }


}
