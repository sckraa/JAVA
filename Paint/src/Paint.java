import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

public class Paint extends JFrame {

    private static final long serialVersionUID = 1L;

    // SECTIONS
    private JPanel west;
    private Color colorWestPanel;
    private PaintArea paintArea;

    // MENU
    private JMenuBar menu;
    private JMenu file;
    private JMenu edit;
    private JMenu view;
    private JMenu selection;
    private JMenu find;
    private JMenu about;
    private JMenu help;
    private Color colorMenu;

    // MENU ITEMS
    private JMenuItem save;
    private JMenuItem saveAs;
    private JMenuItem exit;

    // TOOL SECTION
    private Color color;
    private JSlider sliderPenSize;
    private JLabel colorLabel;
    private JButton colorPick;
    private JPanel colorPanel;
    private JButton gum;

    public Paint() {
        final int width = 1500;
        final int height = 1000;

        setTitle("Paint");
        setSize(width, height);
        setLocation(300, 10);

        Container mainContainer = this.getContentPane();
        mainContainer.setLayout(new BorderLayout(5, 5));
        this.getRootPane().setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 5));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("./assets/img/icon.png")));
        init();

        setVisible(true);
    }

    private void init() {
        Menu();
        PanelWest();
    }

    public void Menu() {
        this.menu = new JMenuBar();

        this.file = new JMenu("File");
        this.edit = new JMenu("Edit");
        this.view = new JMenu("View");
        this.selection = new JMenu("Selection");
        this.find = new JMenu("Find");
        this.about = new JMenu("About");
        this.help = new JMenu("Help");

        this.save = new JMenuItem("Save");
        this.saveAs = new JMenuItem("Save As...");
        this.exit = new JMenuItem("Exit");

        this.colorMenu = new Color(204, 204, 204);

        this.menu.add(this.file);
        this.menu.add(this.edit);
        this.menu.add(this.view);
        this.menu.add(this.selection);
        this.menu.add(this.find);
        this.menu.add(this.about);
        this.menu.add(this.help);
        this.file.add(this.save);
        this.file.add(this.saveAs);
        this.file.add(this.exit);
        setJMenuBar(this.menu);
        this.menu.setBackground(this.colorMenu);
    }

    public void PanelWest() {
        this.west = new JPanel();
        this.west.setLayout(new FlowLayout());

        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(10, 1, 1, 10));

        // COLOR choice
        this.color = Color.RED;
        this.colorLabel = new JLabel("Color : ");
        this.colorPick = new JButton("Choose a color");
        this.colorPanel = new JPanel();
        this.colorPanel.setBackground(color);

        colorPick.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                color = JColorChooser.showDialog(null, "Pick your color", color);
                paintArea.setPenColor(color);
                colorPanel.setBackground(color);
            }
        });

        // SLIDER FOR PEN SIZE
        JLabel penSizeLabel = new JLabel("Pen size :");
        this.sliderPenSize = new JSlider(JSlider.HORIZONTAL, 0, 50, 10);
        JLabel valueSlider = new JLabel("Size = " + this.sliderPenSize.getValue());

        // PEN SIZE CHANGE LISTENER
        this.sliderPenSize.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int size = sliderPenSize.getValue();
                paintArea.setPointRadius(size);
                valueSlider.setText("Size = " + size);
            }
        });

        // GUM
        this.gum = new JButton("GUM");

        gum.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                color = paintArea.getBackgroundColor();
                paintArea.setPenColor(color);
                colorPanel.setBackground(color);
            }
        });

        // PAINT AREA
        paintArea = new PaintArea();

        gridPanel.add(colorLabel);
        gridPanel.add(colorPanel);
        gridPanel.add(colorPick);

        gridPanel.add(penSizeLabel);
        gridPanel.add(this.sliderPenSize);
        gridPanel.add(valueSlider);

        gridPanel.add(gum);

        this.colorWestPanel = new Color(204, 204, 204);

        gridPanel.setBackground(this.colorWestPanel);
        this.west.add(gridPanel);
        this.add(paintArea);
        add(this.west, BorderLayout.WEST);
    }

    public static void main(final String[] args) {
        new Paint();
    }
}