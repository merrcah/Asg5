import shapes.*; 
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class PaintPanel extends JPanel implements MouseListener, MouseMotionListener {
    protected ArrayList<Shape> shapes = new ArrayList<>();
    protected ShapeType currentShape = ShapeType.RECTANGLE;
    protected String currentColor = "#ff0000";
    protected int currentWidth = 50;
    protected int currentHeight = 25;

    public PaintPanel() {
        super();
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    // Getter and setter methods for shape, color, width, and height attributes
    public ShapeType getCurrentShape() {
        return currentShape;
    }

    public void setCurrentShape(ShapeType currentShape) {
        this.currentShape = currentShape;
    }

    public String getCurrentColor() {
        return currentColor;
    }

    public void setCurrentColor(String currentColor) {
        this.currentColor = currentColor;
    }

    public int getCurrentWidth() {
        return currentWidth;
    }

    public void setCurrentWidth(int currentWidth) {
        this.currentWidth = currentWidth;
    }

    public int getCurrentHeight() {
        return currentHeight;
    }

    public void setCurrentHeight(int currentHeight) {
        this.currentHeight = currentHeight;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int mousex = e.getX();
        int mousey = e.getY();
        int topleftx = mousex - currentWidth / 2;
        int toplefty = mousey - currentHeight / 2;
        System.out.println(mousex + " " + mousey);
        Shape s;
        if (currentShape == ShapeType.RECTANGLE) {
            s = new Rectangle(topleftx, toplefty, currentWidth, currentHeight, currentColor);
        } else if (currentShape == ShapeType.SQUARE) {
            s = new Square(topleftx, toplefty, currentWidth, currentColor);
        } else if (currentShape == ShapeType.OVAL) {
            s = new Oval(topleftx, toplefty, currentWidth, currentHeight, currentColor);
        } else if (currentShape == ShapeType.CIRCLE) {
            s = new Circle(topleftx, toplefty, currentWidth, currentColor);
        } else if (currentShape == ShapeType.TRIANGLE) {
            int x1 = mousex;
            int y1 = mousey - currentHeight / 2;
            int x2 = mousex - currentWidth / 2;
            int y2 = mousey + currentHeight / 2;
            int x3 = mousex + currentWidth / 2;
            int y3 = mousey + currentHeight / 2;
            s = new Triangle(x1, y1, x2, y2, x3, y3, currentColor);
        } else {
            // draw a rectangle by default
            s = new Rectangle(topleftx, toplefty, currentWidth, currentHeight, currentColor);
        }
        shapes.add(s);
        s.draw(getGraphics());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // handled in mouseClicked
        System.out.println("released");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // handled in mouseClicked
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // ignored
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // ignored
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mouseClicked(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

}
