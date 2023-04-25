import java.awt.Graphics;

public class Oval extends Shape {

    protected int width = 10;
    protected int height = 5;

    public Oval(int x, int y, int width, int height, String color) {
        super(x, y, color);
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics g) {
        if (g==null)
            System.out.println("drawing a " + width + "x" + height + " " + color + " oval");
        else {
            // add your code for drawing an Oval here
        }
    }
    
}
