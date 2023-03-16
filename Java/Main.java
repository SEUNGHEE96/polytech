package com.example;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        //1.
        Date now = new Date(System.currentTimeMillis());
        //2.
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        //3.
        int day = cal.get(Calendar.DATE);
        //4.
        cal.set(Calendar.DATE, day);
        //5.
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        System.out.println(format.format(now));
    }

}
