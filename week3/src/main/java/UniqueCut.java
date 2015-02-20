/**
 * Created by kartik on 2/15/15.
 */
public class UniqueCut
{
    public int endOne;
    public int endTwo;

    public UniqueCut(int one, int two) {
        endOne = one;
        endTwo = two;
    }

    boolean isEqualTo(UniqueCut otherCut){
        return (this.endOne == otherCut.endOne && this.endTwo == otherCut.endTwo)
            || (this.endOne == otherCut.endTwo && this.endTwo == otherCut.endOne);
    }

    @Override
    public String toString()
    {
        return "(" + endOne + ", " + endTwo + ")";
    }
}
