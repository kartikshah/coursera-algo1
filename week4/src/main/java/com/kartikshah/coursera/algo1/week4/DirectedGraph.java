package com.kartikshah.coursera.algo1.week4;

import javax.swing.*;
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
    private Map<Long, Node> leader;
    private Node s;
    private Long t = 0L;
    private Map<Long, Node> finishingTime;

    public DirectedGraph()
    {
        this.nodes = new HashMap<>();
        this.leader = new HashMap<>();
        Comparator cmp = new TreeMap<Long, Node>().comparator();
        this.finishingTime = new TreeMap<>(Collections.reverseOrder(cmp));
    }

    public void addNode(long index, Node node){
        this.nodes.put(index, node);
    }

    public void parseLine(String line){
        List<String> nodeLine1 = Arrays.asList(line.split("(\\s)+"));
        Long nodeValue = Long.parseLong(nodeLine1.stream().findFirst().get());
        Long edgeValue = Long.parseLong(nodeLine1.stream().skip(1).findFirst().get());
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
        toNode.addReverseEdge(nodeValue, new Edge(thisNode));
        thisNode.addEdge(edgeValue, new Edge(toNode));
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


    public void dfs(Node node, boolean forward){
        node.setExplored(true);
        if (forward) leader.put(node.getLabel(), s);

        Collection<Edge> progressionEdges = forward?node.getEdges().values():node.getReverseEdges().values();
        for (Edge edge : progressionEdges)
        {
            if (!edge.getToNode().isExplored())
            {
                dfs(edge.getToNode(), forward);
            }
        }
        if(!forward)
        {
            t++;
            finishingTime.put(t, node);
        }
    }

    public void dfsloop_one(boolean forward){
        long maxValue = Collections.max(nodes.keySet());
        for(long i = maxValue; i > 0; i--){
            Node thisNode = nodes.get(i);
            if(thisNode != null && !thisNode.isExplored()){
                s = thisNode;
                dfs(thisNode, forward);
            }
        }
    }

    public void dfsloop_two(boolean forward){
        for(long i : finishingTime.keySet()){
            Node thisNode = finishingTime.get(i);
            if(thisNode != null && ! thisNode.isExplored()){
                s = thisNode;
                dfs(thisNode, forward);
            }
        }
    }

    public void scc(){

        dfsloop_one(false);
        resetExplored();
        dfsloop_two(true);

        Map<Long, Long> scc = leader.values().stream().collect(Collectors.groupingBy(Node::getLabel, Collectors.counting()));
//        System.out.println("SCC Leaders: " + scc);
        System.out.println("SCC Count:" + scc.values().stream().sorted(Collections.reverseOrder()).limit(5).collect(Collectors.toList()));
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
