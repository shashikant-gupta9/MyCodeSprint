import java.util.Random;

// Interface representing a pet
interface Pet {
    void play();
    void feed();
    void sleep();
}

// Base class for pets
abstract class Animal {
    String name;
    int energy;
    Random random;

    Animal(String name) {
        this.name = name;
        energy = 100;
        random = new Random();
    }

    abstract void makeSound();

    void decreaseEnergy(int amount) {
        energy = Math.max(0, energy - amount);
    }

    void increaseEnergy(int amount) {
        energy = Math.min(100, energy + amount);
    }

    void printStatus() {
        System.out.println(name + "'s energy level: " + energy);
    }
}

// Dog class extending Animal and implementing Pet interface
class Dog extends Animal implements Pet {
    Dog(String name) {
        super(name);
    }

    @Override
    void makeSound() {
        System.out.println(name + " says: Woof!");
    }

    @Override
    public void play() {
        System.out.println(name + " plays fetch!");
        decreaseEnergy(20);
    }

    @Override
    public void feed() {
        System.out.println(name + " eats dog food.");
        increaseEnergy(15);
    }

    @Override
    public void sleep() {
        System.out.println(name + " takes a nap.");
        increaseEnergy(30);
    }
}

public class VirtualPetSimulator {
    public static void main(String[] args) {
        Dog dog = new Dog("Buddy");

        dog.printStatus();

        dog.makeSound();
        dog.play();
        dog.feed();
        dog.sleep();

        dog.printStatus();
    }
}
