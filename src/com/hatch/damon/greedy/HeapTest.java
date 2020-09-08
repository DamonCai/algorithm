package com.hatch.damon.greedy;

import java.util.ArrayList;
import java.util.List;


//java.lang.OutOfMemoryError: GC overhead limit exceeded
public class HeapTest {
    public static void main(String[] args) {
        List<String> list =new ArrayList<>();
        for (int i = 0; true; i++) {

            list.add("碍事了的交付好的 "+i);
            System.out.println(i);

        }



    }


}
