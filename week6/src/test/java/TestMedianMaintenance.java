import com.kartikshah.coursera.algo1.week6.MedianMaintenance;
import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.util.Map;

/**
 * Created by kartik on 3/4/15.
 */
public class TestMedianMaintenance
{

    @Test
    public void testMedianMaintenanceTestCase1() throws Exception{
        MedianMaintenance mm = new MedianMaintenance();
        Map<Integer, Long> result = mm.findMedian(new FileReader(new File("").getAbsolutePath() + "/src/test/resources/MedianTestCase1.txt"));
        System.out.println(result);
        System.out.println(result.values().stream().mapToLong(lng -> new Long(lng)).sum() % 10000);

    }


    @Test
    public void testMedianMaintenance() throws Exception{
        MedianMaintenance mm = new MedianMaintenance();
        Map<Integer, Long> result = mm.findMedian(new FileReader(new File("").getAbsolutePath() + "/src/test/resources/Median.txt"));
        System.out.println(result);
        System.out.println(result.values().stream().mapToLong(lng -> new Long(lng)).sum() % 10000);

    }
}
