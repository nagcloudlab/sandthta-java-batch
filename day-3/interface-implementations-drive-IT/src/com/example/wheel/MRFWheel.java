package com.example.wheel;

public class MRFWheel implements Wheel {

    public MRFWheel(){
        System.out.println("MRFWheel instance created...");
    }

    public int rotate(int speed){
        System.out.println("MRF wheel rotating...");
        return (int)(speed * 0.5);
    }
}
