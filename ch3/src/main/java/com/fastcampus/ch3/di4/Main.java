package com.fastcampus.ch3.di4;

import com.fastcampus.ch3.Ch3Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.data.relational.core.sql.FalseCondition;
import org.springframework.stereotype.Component;

import java.util.Arrays;

class Car {
    public String toString() {
        return "Car{}";
    }
}

class SportsCar extends Car {
    public String toString() {
        return "SportsCar{}";
    }

    class SportsCar2 extends Car {
        public String toString() {
            return "SportsCar2{}";
        }
    }

    @Component
    @Conditional(TrueCondition.class)
    class Engine {
        @Override
        public String toString() {
            return "Engine{}";
        }
    }

    @Component
    @Conditional(OSCondition.class)
    class Door {
        @Override
        public String toString() {
            return "Door{}";
        }
    }

    class TrueCondition implements Condition {

        @Override
        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
            return true;
        }
    }

    class OSCondition implements Condition {
        @Override
        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
            Environment env = context.getEnvironment();
//        System.out.println("System.getProperties() = " + System.getProperties());
            return env.getProperty("sun.desktop").equals("windows");

        }
    }


    @Configuration
    @Import({Config1.class, Config2.class})
    class MainConfig {
        @Bean
        Car car() {
            return new Car();
        }
    }

    class Config1 {
        @Bean
        Car sportsCar() {
            return new SportsCar();
        }
    }

    class Config2 {
        @Bean
        Car sportsCar() {
            return new SportsCar2();
        }
    }

    @EnableConfigurationProperties({MyProperties.class})
    @Configuration  //@SpringBootConfiguration과 동일
//@EnableAutoConfiguration
    @ComponentScan

    public class Main {
        public static void main(String[] args) {

            ApplicationContext ac = SpringApplication.run(Main.class, args);
//        ApplicationContext ac = new AnnotationConfigApplicationContext(MainConfig.class,Config1.class,Config2.class);   //자바설정을 이용하는 ac
//        ApplicationContext ac = new AnnotationConfigApplicationContext(MainConfig.class);
//        System.out.println("ac = " + ac);
            String[] beanDefinitionNames = ac.getBeanDefinitionNames();

            Arrays.sort(beanDefinitionNames);   //빈 목록이 담긴 배열을 정렬
            Arrays.stream(beanDefinitionNames)  //배열을 스트림으로 변환
                    .filter(b -> !b.startsWith("org"))       //org로 시작하는 빈의 이름을 제외
                    .forEach(System.out::println);  //스트림의 요소를 하나씩 꺼내서 출력

//        System.out.println("ac.getBean(\"sportsCar\") = " + ac.getBean("sportsCar"));
            MyProperties prop = ac.getBean(MyProperties.class);
            System.out.println("prop.getDomain() = " + prop.getDomain());
            System.out.println("prop.getEmail() = " + prop.getEmail());
        }

        @Bean
        MyBean myBean() {
            return new MyBean();
        }

    }

    class MyBean {
    }
}