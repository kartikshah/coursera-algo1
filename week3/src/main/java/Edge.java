/**
 * Created by kartik on 2/15/15.
 */
public class Edge
{
    private Integer toNode;
    private Boolean marked;

    public Edge(Integer toNode, Boolean marked)
    {
        this.toNode = toNode;
        this.marked = marked;
    }

    public Edge(Integer toNode)
    {
        this.toNode = toNode;
        this.marked = false;
    }

    public Boolean getMarked()
    {
        return marked;
    }

    public Boolean isMarked(){return getMarked();}
    public Boolean isNotMarked(){return !getMarked();}

    public void setMarked(Boolean marked)
    {
        this.marked = marked;
    }

    public Integer getToNode()
    {
        return toNode;
    }

    public void setToNode(Integer toNode)
    {
        this.toNode = toNode;
    }

    @Override
    public String toString()
    {
        String strMarked =  marked?"M":"";
        return "" + toNode + "" + strMarked;
    }
}
