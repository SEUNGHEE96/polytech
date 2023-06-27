package com.example;

import static org.junit.Assert.*;
import org.junit.Test;
import com.example.Account;
import com.example.Bank;

public class BankTest {

    @Test(expected = IllegalArgumentException.class)
    public void test() {
        //예외가 발생하는 것을 원하는 코드는 해당 코드처럼 작성하면 된다!
        //위에 expected를 명시해주면, 해당 예외가 발생한 것이 테스트 통과 처리가 된다!
        Bank b2 = new Bank();
        b2.setName("이승희");
        assertEquals(b2.getName(),"이승희");
    }

}
