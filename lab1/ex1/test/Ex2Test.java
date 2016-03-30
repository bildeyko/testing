import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.ifmo.Ex2;

/**
 * Created by bilde_000 on 30.03.2016.
 */
public class Ex2Test {
    StringBuilder tstString;
    Ex2 ex2;

    @Before
    public void prepare() {
        ex2 = new Ex2();
        tstString = new StringBuilder();
    }

    @Test
    public void sortTest() {
        int[] arr ={2,1,0,6};

        ex2.sort(arr, tstString);

        Assert.assertEquals("s1s1s2s2m1f4f2s1s2s2m1f3f1m1f4f3f3f1", tstString.toString());
    }

    @Test
    public void emptyArrTest() {
        int[] arr ={};

        ex2.sort(arr, tstString);

        Assert.assertEquals("s2", tstString.toString());
    }


    @Test
    public void sameElementsTest() {
        int[] arr ={2,2,2,2};

        ex2.sort(arr, tstString);

        Assert.assertEquals("s1s1s2s2m1f4f2s1s2s2m1f4f2m1f4f4f2f2", tstString.toString());
    }
}
