package com.example;

public class Application {
    public static void main(String[] args) {

        God god = new God();

        System.out.println("-".repeat(50));
        System.out.println("Human");
        System.out.println("-".repeat(50));
        Human human = new Human();
        //god.manageHuman(human);
        god.manageLT(human);

        System.out.println("-".repeat(50));
        System.out.println("Animal");
        System.out.println("-".repeat(50));
        Animal animal = new Animal();
//        god.manageAnimal(animal);
        god.manageLT(animal);

        System.out.println("-".repeat(50));
        System.out.println("Robot");
        System.out.println("-".repeat(50));
        Robot robot=new Robot();
//        god.manageRobot(robot);
        god.manageLT(robot);

    }
}
