package com.hatch.damon;

public class B extends A {
    private String nameB = "B";

    @Override
    public void getName() {
        System.out.println("子类" + nameB);
//        super.getName();
    }

    public static void main(String[] args) {
        A b = new B();
        b.getName();

    }
}