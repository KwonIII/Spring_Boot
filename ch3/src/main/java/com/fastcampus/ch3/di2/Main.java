package com.fastcampus.ch3.di2;

class Car{
    Engine engine;
    Door door;

    @Override
    public String toString() {
        return "Car{" +
                "engine=" + engine +
                ", door=" + door +
                '}';
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setDoor(Door door) {
        this.door = door;
    }
}
class SportsCar extends Car{
    @Override
    public String toString() {
        return "SportsCar{" +
                "engine=" + engine +
                ", door=" + door +
                '}';
    }
}
class Engine{}
class Door{}
public class Main {
    public static void main(String[] args) {
        AppContext ac = new AppContext();
        Car car = (Car)ac.getBean("car");    //byName
        Car car2 = (Car)ac.getBean(Car.class);    //byType
        Engine engine =(Engine)ac.getBean("engine");    //byName
        Door door = (Door)ac.getBean(Door.class);   //byType
        System.out.println("car = " + car);
        System.out.println("car2 = " + car2);
        System.out.println("engine = " + engine);
        System.out.println("door = " + door);
    }
}
