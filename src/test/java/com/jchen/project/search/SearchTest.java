import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.jchen.project.search.BinarySearch;
import com.jchen.project.search.LinearSearch;

import java.util.Random;

public class SearchTest {
    //int
    private String[] strArr;

    //string
    private int[] intArr;

    //double
    private double[] doubleArr;

    private Random RANDOM = new Random();

    private static final int SIZE = 10000;

    @Before
    public void setUp() {
        intArr = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            intArr[i] = i;
        }
    }

    @Test
    public void BinarySearchTest() {

        BinarySearch bs = new BinarySearch();

        int target = RANDOM.nextInt(SIZE);
        int result = bs.search(intArr, target);
        assertEquals(target, result);

        //will not find,will return -1
        target = -1;
        int invalidNum = 10000;
        result = bs.search(intArr, invalidNum);
        assertEquals(target, result);

    }

    @Test
    public void LinearSearchTest() {

        LinearSearch ls = new LinearSearch();

        int target = RANDOM.nextInt(SIZE);
        int result = ls.search(intArr, target);
        assertEquals(target, result);

        //will not find,will return -1
        target = -1;
        int invalidNum = 10000;
        result = ls.search(intArr, invalidNum);
        assertEquals(target, result);
    }
}
