import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.ifmo.Ex1;

/**
 * Created by bilde_000 on 30.03.2016.
 */
public class Ex1Test {
    Ex1 ex1;

    @Before
    public void prepare() {
        ex1 = new Ex1();
    }

    @Test
    public void negBoundsTest() {
        Assert.assertEquals(Double.NEGATIVE_INFINITY, ex1.sec(-Math.PI/2 - 0.1, 0.001), 0.001);

        Assert.assertEquals(Double.NEGATIVE_INFINITY, ex1.sec(-Math.PI/2, 0.001), 0.001);

        Assert.assertEquals(10.0166, ex1.sec(-Math.PI / 2 + 0.1, 0.0001), 0.001);
    }

    @Test
    public void posBoundsTest() {
        Assert.assertEquals(Double.POSITIVE_INFINITY, ex1.sec(Math.PI/2 + 0.1, 0.001), 0.001);

        Assert.assertEquals(Double.POSITIVE_INFINITY, ex1.sec(Math.PI/2, 0.001), 0.001);

        Assert.assertEquals(10.0166, ex1.sec(Math.PI / 2 - 0.1, 0.0001), 0.001);
    }

    @Test
    public void centerTest() {
        Assert.assertEquals(1.0, ex1.sec(0.0, 0.0001), 0.001);
    }
}
