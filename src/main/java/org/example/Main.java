package org.example;

import java.util.Random;

public class Main {
    public static void main(String[] args) {



        System.out.println("Hello worl!");
    }


    public int roll(int pins) {
        Random rand = new Random();
        return rand.nextInt(11);
    }
}