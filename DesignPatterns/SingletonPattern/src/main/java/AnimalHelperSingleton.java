/**
 * Created by Administrator on 2016/11/26.
 */

import java.awt.*;

/**
 * Example of a Java Singleton.
 * It is suggested to use an enum as a singleton. The Class
 * cannot be instantiated more then once, specifically when
 * using reflection.
 *
 * @author keaplogik
 */
public enum AnimalHelperSingleton {

    INSTANCE;

    private AnimalHelperSingleton() {

    }

    public Animal[] buildAnimalList() {
        final Animal[] animals = new Animal[10];

        animals[0] = new SimpleAnimal(Animal.AnimalClass.MAMMAL,
                "Dog", true, Color.GRAY);
        animals[1] = new SimpleAnimal(Animal.AnimalClass.MAMMAL,
                "Cat", true, Color.YELLOW);
        animals[2] = new SimpleAnimal(Animal.AnimalClass.AMPHIBIAN,
                "Frog", true, Color.GREEN);
        animals[3] = new SimpleAnimal(Animal.AnimalClass.BIRD,
                "Crow", true, Color.BLACK);
        animals[4] = new SimpleAnimal(Animal.AnimalClass.BIRD,
                "Cardinal", true, Color.RED);
        animals[5] = new SimpleAnimal(Animal.AnimalClass.ARTHROPOD,
                "Mantis", false, Color.GREEN);
        animals[6] = new SimpleAnimal(Animal.AnimalClass.ARTHROPOD,
                "Spider", false, Color.ORANGE);
        animals[7] = new SimpleAnimal(Animal.AnimalClass.MAMMAL,
                "Tiger", true, Color.ORANGE);
        animals[8] = new SimpleAnimal(Animal.AnimalClass.MAMMAL,
                "Bear", true, Color.BLACK);
        animals[9] = new SimpleAnimal(Animal.AnimalClass.BIRD,
                "Owl", true, Color.BLACK);

        return animals;
    }

}

interface Animal {
    enum AnimalClass {
        MAMMAL,
        AMPHIBIAN,
        BIRD,
        ARTHROPOD,
        ;
    }
}

class SimpleAnimal implements Animal {
    private Animal.AnimalClass type;
    private String name;
    private boolean isBeautiful;
    private Color color;

    public SimpleAnimal(Animal.AnimalClass type, String name, boolean isBeautiful, Color color) {
        this.type = type;
        this.name = name;
        this.isBeautiful = isBeautiful;
        this.color = color;
    }

    @Override
    public String toString() {
        return "SimpleAnimal{" +
                "type=" + type +
                ", name='" + name + '\'' +
                ", isBeautiful=" + isBeautiful +
                ", color=" + color +
                '}';
    }
}
