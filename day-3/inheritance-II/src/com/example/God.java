package com.example;

// coding principle : Open for extension ,closed  for modification

public class God {
//
//    public void manageHuman(Human human) {
//        human.eat();
//        human.study();
//        human.work();
//        human.sleep();
//    }
//    public void manageAnimal(Animal animal) {
//        animal.eat();
//        animal.work();
//        animal.sleep();
//    }
//    public void manageRobot(Robot robot) {
//        robot.eat();
//        robot.work();
//        robot.sleep();
//    }

    public void manageLT(LivingThing livingThing) {
        livingThing.eat();
        if(livingThing instanceof Human){
            Human human=(Human) livingThing;
            human.study();
        }
        livingThing.work();
        livingThing.sleep();
    }

}
