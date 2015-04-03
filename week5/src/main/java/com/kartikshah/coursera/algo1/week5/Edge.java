package com.kartikshah.coursera.algo1.week5;

/**
 * Created by kartik on 2/18/15.
 */
public class Edge
{
    private Node toNode;
    private Long length;

    public Edge(Node toNode, Long length)
    {
        this.toNode = toNode;
        this.length = length;
    }

    public Node getToNode()
    {
        return toNode;
    }

    public void setToNode(Node toNode)
    {
        this.toNode = toNode;
    }

    public Long getLength()
    {
        return length;
    }

    public void setLength(Long length)
    {
        this.length = length;
    }

    @Override
    public String toString()
    {
        return "" + toNode.getLabel() + "{" + getLength() + "}";
    }
}
