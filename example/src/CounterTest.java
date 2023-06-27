package com.example;

import static org.junit.Assert.*;
import org.junit.Test;
import com.example.Counter;

public class CounterTest {
    
    @Test
    public void 초기화_테스트() {
        Counter c = new Counter();
        assertEquals(c.getCount(), 0);
    }
    
    @Test
    public void 할당_테스트() {
        Counter c = new Counter();
        c.setCount(5);
        assertEquals(c.getCount(), 5);
    }

    @Test
    public void 증가_테스트() {
        Counter c = new Counter();
        c.increase();
        assertEquals(c.getCount(), 1);
    }

}
