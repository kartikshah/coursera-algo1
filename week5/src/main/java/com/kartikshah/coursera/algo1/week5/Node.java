package com.kartikshah.coursera.algo1.week5;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kartik on 2/18/15.
 */
public class Node
{
    private Long label;
    private boolean explored;
    private Map<Long, Edge> edges;
    private Map<Long, Edge> reverseEdges;

    public Node(Long label)
    {
        this.label = label;
        this.edges = new HashMap<>();
        this.reverseEdges = new HashMap<>();
    }

    public Long getLabel()
    {
        return label;
    }

    public void setLabel(Long label)
    {
        this.label = label;
    }

    public boolean isExplored()
    {
        return explored;
    }

    public void setExplored(boolean explored)
    {
        this.explored = explored;
    }

    public Map<Long, Edge> getEdges()
    {
        return edges;
    }

    public void setEdges(Map<Long, Edge> edges)
    {
        this.edges = edges;
    }

    public Map<Long, Edge> getReverseEdges()
    {
        return reverseEdges;
    }

    public void setReverseEdges(Map<Long, Edge> reverseEdges)
    {
        this.reverseEdges = reverseEdges;
    }

    public void addEdge(Long index, Edge edge){
        assert edge != null;
        edges.put(index, edge);
    }

    public void addReverseEdge(Long index, Edge edge){
        assert edge != null;
        reverseEdges.put(index, edge);
    }


    @Override
    public String toString()
    {
        return "Node: {" + label + ", " + explored + ", Edges:" + edges.values() + ", RevEdge:" + reverseEdges.values() + "} \n";
    }
}
