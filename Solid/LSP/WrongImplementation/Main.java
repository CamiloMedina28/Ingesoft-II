package Solid.LSP.WrongImplementation;

public class Main {
    public static void main(String[] args){

    }
    public void resize(Rectangle rectangle) {
        rectangle.setWidth(5);
        rectangle.setHeight(10);
        System.out.println(rectangle.getArea());
    }
}
