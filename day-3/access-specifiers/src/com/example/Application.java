package com.example;

import com.example.p1.A;
import com.example.p1.B;
import com.example.p1.C;
import com.example.p2.D;

public class Application {
    public static void main(String[] args) {

        A a=new A();
        a.aObjMethod();
        System.out.println();
        B b=new B();
        b.bObjMethod();

        System.out.println();
        C c=new C();
        c.cObjMethod();

        System.out.println();

        D d=new D();
        d.dObjMethod();


    }
}
