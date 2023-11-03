package com.example;

interface  I1{
    void m1();
    void m2();
}

class C1 implements I1{
    public void m1() {}
    public void m2() {}
}
class C2 implements I1{
    public void m1() {}
    public void m2() {}
}

//--------------------------------

interface A{
    void x();
}
interface B{
    void y();
}

class C implements A,B{
    public void x() {}
    public void y() {}
}

//--------------------------------

interface  P{
    void i();
}
interface Q extends P{
    void j();
}

class R implements Q{
    public void i() {}
    public void j() {}
}

public class Ex {
    public static void main(String[] args) {

        //I1 i1 = new I1(); // we cant create instance for interface

        C1 c1=new C1();
        C2 c2=new C2();

        I1 i1=new C1();
        i1=new C2();



    }
}
