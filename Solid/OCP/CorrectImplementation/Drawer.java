package Solid.OCP.CorrectImplementation;

public class Drawer implements Executable{
    private boolean isOpened;

    public Drawer(boolean opened){
        this.isOpened = opened;
    }

    @Override
    public void open(){
        this.isOpened = true;
        System.out.println("Drawer Opened");
    }

    @Override
    public void close(){
        isOpened = false;
        System.out.println("Drawer closed");
    }

    @Override
    public boolean getOpenned(){
        return isOpened;
    }
}
