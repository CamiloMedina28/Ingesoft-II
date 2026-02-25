package Solid.OCP.CorrectImplementation;

public class Hand {

    public void doAction(Executable executable) {

        if (!executable.getOpenned()) {
            executable.open();
        } else {
            executable.close();
        }
    }
}