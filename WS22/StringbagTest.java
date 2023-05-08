import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringbagTest {

    private Stringbag sb;
    private String [] xs;
   //Aufgabe 1b
    @Before
    public void init(){
        xs = new String[]{"","bb","cc","dd","eee","ff"};
        sb = new Stringbag(xs);
    }
    @Test
    //1a
    public void Constructor(){

        Stringbag s = new Stringbag(new String []  { "never","gonna","give"});
        assertEquals("never",s.get(0));
        assertEquals(3,s.size());
    }
    @Test(expected = IllegalArgumentException.class)
    public void NullTest(){
        Stringbag s = new Stringbag(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void EintragNullTest(){
        String [] xs = new String [2];
        xs [1] = null;
        Stringbag s = new Stringbag(xs);
    }
    //1c
    @Test
    public void picktest(){
        assertEquals("",sb.pick(0));
        assertNull(sb.pick(4));
    }
    //1d
    @Test
    public void picktest2(){
        String s = sb.pick(2);
        assertTrue(s.equals("bb") | s.equals("ff")| s.equals("dd") );
    }

}
