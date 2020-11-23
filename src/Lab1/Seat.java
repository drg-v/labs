package Lab1;

public class Seat implements ShowDimensions {
    private float height;
    private float width;

    public Seat() {
        height = width = (float) 10;
    }

    public Seat(float h, float w) {
        height = h;
        width = w;
    }

    public float getHeight(){
        return height;
    }

    public float getWidth(){
        return width;
    }

    public void show(){
        System.out.println("Class seat:\nHeight: " + height + ".\nWidth: " + width + ".\n");
    }
}
