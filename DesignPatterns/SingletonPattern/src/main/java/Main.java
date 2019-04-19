/**
 * Created by mars on 16/11/25.
 */
public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 10; ++i) {
            System.out.println(SingletonOne.getInstance().info());
            System.out.println(SingletonTwo.getInstance().info());
            System.out.println(SingletonThree.getInstance().info());
        }
        Animal[] animals = AnimalHelperSingleton.INSTANCE.buildAnimalList();
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }
}
