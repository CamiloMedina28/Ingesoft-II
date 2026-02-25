package Solid.LSP.WrongImplementation;

class Square extends Rectangle {
    @Override
    public void setWidth(int width) {
        this.width = width;
        this.height = width; // fuerza lados iguales
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
        this.width = height; // fuerza lados iguales
    }
}