import com.kartikshah.coursera.algo1.week6.SumTwo;
import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by kartik on 3/4/15.
 */
public class TestSumTwo
{
    @Test
    public void testFileRead() throws Exception{
        SumTwo sumTwo = new SumTwo();
        Map<Long, Long> map = sumTwo.readInput(new FileReader(new File("").getAbsolutePath() + "/src/test/resources/testcase1.txt"));
        assertNotNull(map);
    }

    @Test
    public void testTestCase1() throws Exception{
        SumTwo sumTwo = new SumTwo();
        Map<Long, Long> map = sumTwo.readInput(new FileReader(new File("").getAbsolutePath() + "/src/test/resources/testcase1.txt"));
        Map<Long, List<Set<Long>>> result = sumTwo.findTwoSum(map);
        assertEquals(3, result.size());
    }

    @Test
    public void testTestCase2() throws Exception{
        SumTwo sumTwo = new SumTwo();
        Map<Long, Long> map = sumTwo.readInput(new FileReader(new File("").getAbsolutePath() + "/src/test/resources/testcase2.txt"));
        Map<Long, List<Set<Long>>> result = sumTwo.findTwoSum(map);
        assertEquals(5, result.size());
    }

    @Test
    public void testTestCase3() throws Exception{
        SumTwo sumTwo = new SumTwo();
        Map<Long, Long> map = sumTwo.readInput(new FileReader(new File("").getAbsolutePath() + "/src/test/resources/testcase3.txt"));
        Map<Long, List<Set<Long>>> result = sumTwo.findTwoSum(map);
        assertEquals(6, result.size());
    }

    public void testTestCase4() throws Exception{
        SumTwo sumTwo = new SumTwo();
        Map<Long, Long> map = sumTwo.readInput(new FileReader(new File("").getAbsolutePath() + "/src/test/resources/testcase4.txt"));
        Map<Long, List<Set<Long>>>result = sumTwo.findTwoSum(map);
        assertEquals(3, result.size());
    }

    @Test
    public void testTestFinal() throws Exception{
        SumTwo sumTwo = new SumTwo();
        Map<Long, Long> map = sumTwo.readInput(new FileReader(new File("").getAbsolutePath() + "/src/test/resources/algo1-programming_prob-2sum.txt"));
        Map<Long, List<Set<Long>>> result = sumTwo.findTwoSum(map);
        assertEquals(427, result.size());
    }
}
