package Solid.OCP.CorrectImplementation;

public class Main {

    public static void main(String[] args) {

        Hand hand = new Hand();

        Executable door = new Door(false);
        Executable drawer = new Drawer(false);
        Executable fridge = new Refrigerator(false);

        hand.doAction(door);
        hand.doAction(drawer);
        hand.doAction(fridge);
    }
}