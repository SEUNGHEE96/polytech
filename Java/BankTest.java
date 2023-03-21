package test;

import static org.junit.Assert.*;
import org.junit.Test;
import com.example.Account;
import com.example.Bank;

public class BankTest {

    @Test
    public void test() {
        //성공
        Bank b = new Bank();
        b.setName("김히어라");
        assertEquals(b.getName(),"김히어라");
        //실패
        Bank b2 = new Bank();
        b2.setName("이승희");
        assertEquals(b2.getName(),"이승희");
    }

}
