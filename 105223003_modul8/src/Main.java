class Animal {

}

class Mammal extends Animal {

}

class Reptile extends Animal {

}

class Dog extends Mammal {

}

public class Main {
    public static void main(String[] args) {
        Animal animal1 = new Animal();
        Mammal mammal1 = new Mammal();
        Dog dog1 = new Dog();
        Reptile reptile1 = new Reptile();

        System.out.println(mammal1 instanceof Animal);
        System.out.println(dog1 instanceof Animal);
        System.out.println(dog1 instanceof Mammal);
        // System.out.println(dog1 instanceof Reptile);

        Animal animal2 = new Mammal();

        // Dog dog2 = (Dog) animal2;

        if (animal2 instanceof Dog) {
            Dog dog2 = (Dog) animal2;
            System.out.println("objek berhasil dibuat");
        } else {
            System.out.println("gagak membuat objek");
        }
    }
}
