package Solid.OCP.WrongImplementation;

public class Door{

    private boolean isOpened;

    public Door(boolean opened){
        this.isOpened = opened;
    }

    public void open() {
        isOpened = true;
        System.out.println("Door opened");
    }

    public void close() {
        isOpened = false;
        System.out.println("Door closed");
    }

    public boolean getOpenned(){
        return isOpened;
    }
}