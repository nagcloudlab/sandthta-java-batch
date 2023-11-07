package com.example;

// generics => java 1.5

// box is data-structure with array
class Box<E> {
    Object[] data = new Object[10];
    int index = -1;

    public void add(E s) {
        index++;
        data[index] = s;
    }

    public E get(int i) {
        return (E) data[i];
    }
}

public class Example1 {
    public static void main(String[] args) {

        Box<String> box1 = new Box<>(); // with generic class => can create type-safety object
        box1.add("string");
        //box1.add(123);

        Box<Integer> box2 = new Box<>(); // with generic class => can create type
        box2.add(123);

    }
}
