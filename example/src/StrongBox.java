package com.example;

import java.util.Objects;

public class StrongBox<E> {
    private KeyType key;
    private E instance;
    private int cnt;

    StrongBox(KeyType key) {
        this.key = key;
    }

    public void put(E instance) {
        if (Objects.isNull(this.instance)) {
            this.instance = instance;
        }
    }

    public E get() {
        cnt++;
        E result = null;
        switch (this.key) {
            case PADLOCK:
                if (this.cnt > 1024) {
                    result = instance;
                }
                break;
            case BUTTON:
                if (this.cnt > 10000) {
                    result = instance;
                }
                break;
            case DIAL:
                if (this.cnt > 30000) {
                    result = instance;
                }
                break;
            case FINGER:
                if (this.cnt > 1000000) {
                    result = instance;
                }
                break;
        }
        return result;
    }

    public enum KeyType {
        PADLOCK, BUTTON, DIAL, FINGER
    }

    // 확인
    public static void main(String[] args) {
        StrongBox<String> sb = new StrongBox<>(KeyType.PADLOCK);
        sb.put("백만원");
        System.out.println(sb.get());
        for (int i = 0; i < 1030; i++) {
            sb.get();
        }
        System.out.println(sb.get());
    }

}
