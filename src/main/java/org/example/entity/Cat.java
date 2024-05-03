package org.example.entity;

public class Cat extends Animal{
    @Override
    public void makeSound(String sound) {
        System.out.println("Meow meow");
    }
}
