package test;

import static org.junit.Assert.*;
import org.junit.Test;
import com.example.Counter;

public class CounterTest {

    @Test
    public void 증가_테스트() {
        Counter c = new Counter();
        c.increase();
        assertEquals(c.getCount(), 1);
    }
    
    @Test
    public void 감소_테스트() {
        Counter c = new Counter();
        c.decrease();
        assertEquals(c.getCount(), -1);
    }

}
