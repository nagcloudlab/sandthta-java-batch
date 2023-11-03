package com.example.wheel;

public class CEATWheel implements Wheel {

    public CEATWheel(){
        System.out.println("CEAT wheel instance created");
    }

    public int rotate(int speed){
        System.out.println("CEAT wheel rotating..");
        return (int)(speed*0.7);
    }
}
