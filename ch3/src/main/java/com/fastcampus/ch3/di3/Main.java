package com.fastcampus.ch3.di3;

import com.fastcampus.ch3.di3.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

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
}
class Engine{}
class Door{}
public class Main {
    public static void main(String[] args) {
    //AC를 생성 - AC의 설정파일은 AppConfig.class 자바설정
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
//        Car car =  (Car)ac.getBean("car");  //byName 객체(빈)을 조회
        Car car = ac.getBean("car",com.fastcampus.ch3.di3.Car.class);  //위와 동일
        Engine engine = ac.getBean(Engine.class);
        Engine engine2 = ac.getBean(Engine.class);
        Engine engine3 = ac.getBean(Engine.class);
        System.out.println("car = " + car);
        System.out.println("engine = " + engine);
        System.out.println("engine2 = " + engine2);
        System.out.println("engine3 = " + engine3);

        System.out.println("ac.getBeanDefinitionCount() = " + ac.getBeanDefinitionCount());
        System.out.println("ac.getBeanDefinitionName() = " + Arrays.toString(ac.getBeanDefinitionNames()));
    }
}
