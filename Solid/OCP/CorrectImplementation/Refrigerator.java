package Solid.OCP.CorrectImplementation;

public class Refrigerator implements Executable {

    private boolean isOpened;

    public Refrigerator(boolean opened){
        this.isOpened = opened;
    }

    @Override
    public void open() {
        isOpened = true;
        System.out.println("Refrigerator opened");
    }

    @Override
    public void close() {
        isOpened = false;
        System.out.println("Refrigerator closed");
    }

    @Override
    public boolean getOpenned() {
        return isOpened;
    }
}