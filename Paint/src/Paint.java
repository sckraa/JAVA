import java.awt.*;
import javax.swing.*;

public class Paint extends JFrame {

    private static final long serialVersionUID = 1L;

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

    public Paint() {
        final int width = 1500;
        final int height = 1000;

        setLayout(new FlowLayout());
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Paint");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("./assets/img/icon.png")));
        init();

        setVisible(true);
    }

    private void init() {
        Menu();
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

    public static void main(final String[] args) {
        new Paint();
    }
}