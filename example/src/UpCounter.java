package com.example;

public class UpCounter implements Counter{

    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int count() {
        count++;
        return count;
    }

}
