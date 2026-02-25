package Solid.OCP.WrongImplementation;

public class Refrigerator{

    private boolean isOpened;

    public Refrigerator(boolean opened){
        this.isOpened = opened;
    }

    public void open() {
        isOpened = true;
        System.out.println("Refrigerator opened");
    }

    public void close() {
        isOpened = false;
        System.out.println("Refrigerator closed");
    }

    public boolean getOpenned() {
        return isOpened;
    }
}