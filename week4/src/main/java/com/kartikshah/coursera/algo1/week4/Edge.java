package com.kartikshah.coursera.algo1.week4;

/**
 * Created by kartik on 2/18/15.
 */
public class Edge
{
    private Node toNode;

    public Edge(Node toNode)
    {
        this.toNode = toNode;
    }

    public Node getToNode()
    {
        return toNode;
    }

    public void setToNode(Node toNode)
    {
        this.toNode = toNode;
    }

    @Override
    public String toString()
    {
        return "" + toNode.getLabel();
    }
}
