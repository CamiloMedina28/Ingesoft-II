package Solid.OCP.WrongImplementation;

public class Hand {

    public void doAction(Door door) {
        if (!door.getOpenned()) {
            door.open();
        } else {
            door.close();
        }
    }

    public void doAction(Drawer drawer) {
        if (!drawer.getOpenned()) {
            drawer.open();
        } else {
            drawer.close();
        }
    }

    public void doAction(Refrigerator refrigerator) {
        if (!refrigerator.getOpenned()) {
            refrigerator.open();
        } else {
            refrigerator.close();
        }
    }
}
