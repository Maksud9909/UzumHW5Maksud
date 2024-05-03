import org.example.entity.Animal;
import org.example.entity.Cat;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CatTest {




    @Test
    public void testCatFields() throws Exception {
        Cat cat = new Cat();

        Field nameField = Animal.class.getDeclaredField("name");
        Field ageField = Animal.class.getDeclaredField("age");

        nameField.setAccessible(true);
        ageField.setAccessible(true);

        nameField.set(cat, "Tom");
        ageField.set(cat, 3);

        assertEquals("Tom", nameField.get(cat));
        assertEquals(3, ageField.get(cat));
    }
    @Test
    public void testCatCreationWithReflection() throws Exception {

        Class<?> catClass = Class.forName("org.example.entity.Cat");
        Cat cat = (Cat) catClass.getDeclaredConstructor().newInstance();


        assertNotNull(cat);
    }

    @Test
    public void testCatSound() throws Exception {
        // Создаем объект Cat с использованием рефлексии
        Class<?> catClass = Class.forName("org.example.entity.Cat");
        Cat cat = (Cat) catClass.getDeclaredConstructor().newInstance();

        // Вызываем метод makeSound() и проверяем, что он возвращает ожидаемое значение
        Method makeSoundMethod = catClass.getDeclaredMethod("makeSound");
        makeSoundMethod.setAccessible(true);
        String sound = (String) makeSoundMethod.invoke(cat);
        assertEquals("Meow meow", sound);
    }


}
