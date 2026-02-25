package Solid.OCP.WrongImplementation;

public class Drawer{
    private boolean isOpened;

    public Drawer(boolean opened){
        this.isOpened = opened;
    }

    public void open(){
        this.isOpened = true;
        System.out.println("Drawer Opened");
    }

    public void close(){
        isOpened = false;
        System.out.println("Drawer closed");
    }

    public boolean getOpenned(){
        return isOpened;
    }
}
