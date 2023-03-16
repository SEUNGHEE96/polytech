package com.example;

public class B extends Y {

    @Override
    public void a() {
        System.out.println("Ba");

    }

    @Override
    public void b() {
        System.out.println("Bb");

    }

    public void c() {
        System.out.println("Bc");

    }

    public static void main(String[] args) {
        A a = new A();
        B b = new B();

        Y[] arrY = new Y[2];
        arrY[0] = a;
        arrY[1] = b;

        for (Y y : arrY) {
            y.b();
        }
    }

}
