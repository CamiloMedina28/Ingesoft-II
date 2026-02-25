package Solid.OCP.CorrectImplementation;

public class Door implements Executable {

    private boolean isOpened;

    public Door(boolean opened){
        this.isOpened = opened;
    }

    @Override
    public void open() {
        isOpened = true;
        System.out.println("Door opened");
    }

    @Override
    public void close() {
        isOpened = false;
        System.out.println("Door closed");
    }

    @Override
    public boolean getOpenned(){
        return isOpened;
    }
}