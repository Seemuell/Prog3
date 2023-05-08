import org.junit.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class VecTest {

    @Test
    public void getMagTest(){
        Vec c = new Vec(-2,1);
       assertEquals(2.236,c.getMag(),1e-2);
       Vec d = new Vec(0,0);
       assertEquals(0,d.getMag(),1e-2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullVectorTest(){
        Vec c = new Vec(0,0);
        c.norm();
    }

    @Test
    public void normTest(){
        Vec d = new Vec(-2,1).norm();
        assertEquals(-0.894, d.getX(), 1e-2);

    }



}
