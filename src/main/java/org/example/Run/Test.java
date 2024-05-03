package org.example.Run;

import org.example.entity.Animal;
import org.example.entity.Cat;

import java.lang.reflect.Field;

public class Test {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchFieldException {
        Cat cat = Cat.class.newInstance();


        Field nameField = Animal.class.getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(cat, "Tom");

        Field ageField = Animal.class.getDeclaredField("age");
        ageField.setAccessible(true);
        ageField.set(cat, 3);


        Object catName = nameField.get(cat);
        int catAge = ageField.getInt(cat);


        System.out.println("Name: " + catName);
        System.out.println("Age: " + catAge);
        System.out.println(cat.makeSound());
    }
}
