import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;
import javax.swing.event.MenuKeyEvent;

public class ShapeSwingProgram extends JFrame implements ActionListener {

    protected PaintPanel paintPanel = new PaintPanel();
    protected JTextField widthTextField = new JTextField(5);
    protected JTextField heightTextField = new JTextField(5);
    protected ButtonGroup shapeButtonGroup;
    protected ButtonGroup colorButtonGroup;

    public ShapeSwingProgram(String title) {
        super(title);

        // Set up window properties
        this.setSize(800, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        // Initialize width and height fields with default values
        widthTextField.setText("50");
        heightTextField.setText("25");

        // Set up top panel with text fields for shape dimensions
        JPanel topPanel = new JPanel(new FlowLayout());
        JLabel widthLabel = new JLabel("Width");
        JLabel heightLabel = new JLabel("Height");
        topPanel.add(widthLabel);
        topPanel.add(widthTextField);
        topPanel.add(heightLabel);
        topPanel.add(heightTextField);
        widthTextField.addActionListener(this);
        heightTextField.addActionListener(this);
        this.add(topPanel, BorderLayout.PAGE_START);

        // Create the menu bar
        JMenuBar menuBar = new JMenuBar();

        // Build the file menu
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(MenuKeyEvent.VK_F);
        menuBar.add(fileMenu);

        // Add file menu items
        JMenuItem openMenuItem = new JMenuItem("Open", MenuKeyEvent.VK_O);
        openMenuItem.addActionListener(this);
        fileMenu.add(openMenuItem);

        JMenuItem saveMenuItem = new JMenuItem("Save", MenuKeyEvent.VK_S);
        saveMenuItem.addActionListener(this);
        fileMenu.add(saveMenuItem);

        JMenuItem saveAsMenuItem = new JMenuItem("Save As...", MenuKeyEvent.VK_A);
        saveAsMenuItem.addActionListener(this);
        fileMenu.add(saveAsMenuItem);

        JMenuItem exitMenuItem = new JMenuItem("Exit", MenuKeyEvent.VK_X);
        exitMenuItem.addActionListener(this);
        fileMenu.add(exitMenuItem);

        // Build the shape menu
        JMenu shapeMenu = new JMenu("Shape");
        shapeButtonGroup = new ButtonGroup();
        String[] shapeNames = { "Rectangle", "Square", "Oval", "Circle", "Triangle" };
        for (String shapeName : shapeNames) {
            JRadioButtonMenuItem shapeMenuItem = new JRadioButtonMenuItem(shapeName);
            shapeMenuItem.addActionListener(this);
            shapeButtonGroup.add(shapeMenuItem);
            shapeMenu.add(shapeMenuItem);
        }
        menuBar.add(shapeMenu);

        // Build the color menu
        JMenu colorMenu = new JMenu("Color");
        colorButtonGroup = new ButtonGroup();
        String[] colorNames = {"Red", "Yellow", "Green", "Black", "White"};
        for (String colorName : colorNames) {
            JRadioButtonMenuItem colorMenuItem = new JRadioButtonMenuItem(colorName);
            colorMenuItem.addActionListener(this);
            colorMenuItem.setSelected(colorName.equals("Red"));
            colorButtonGroup.add(colorMenuItem);
            colorMenu.add(colorMenuItem);
        }
        menuBar.add(colorMenu);

        // Add the menu bar to the window
        this.setJMenuBar(menuBar);

        // Set up the paint panel
        paintPanel.setPreferredSize(new Dimension(500, 500));
        paintPanel.setBackground(Color.WHITE);
        this.getContentPane().add(paintPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        ShapeSwingProgram paintprogram = new ShapeSwingProgram("Shape Dropper Paint Program");
        paintprogram.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        switch (actionCommand) {
            case "Rectangle" -> paintPanel.setCurrentShape(ShapeType.RECTANGLE);
            case "Square" -> paintPanel.setCurrentShape(ShapeType.SQUARE);
            case "Oval" -> paintPanel.setCurrentShape(ShapeType.OVAL);
            case "Circle" -> paintPanel.setCurrentShape(ShapeType.CIRCLE);
            case "Triangle" -> paintPanel.setCurrentShape(ShapeType.TRIANGLE);
            case "Red" -> paintPanel.setCurrentColor("#FF0000");
            case "Yellow" -> paintPanel.setCurrentColor("#FFFF00");
            case "Green" -> paintPanel.setCurrentColor("#00FF00");
            case "Black" -> paintPanel.setCurrentColor("#000000");
            case "White" -> paintPanel.setCurrentColor("#FFFFFF");
            default -> {
                int width = Integer.parseInt(widthTextField.getText());
                int height = Integer.parseInt(heightTextField.getText());
                paintPanel.setCurrentWidth(width);
                paintPanel.setCurrentHeight(height);
            }
        }

        switch (paintPanel.getCurrentShape()) {
            case CIRCLE, SQUARE -> heightTextField.setEnabled(false);
            default -> heightTextField.setEnabled(true);
        }
    }

}
