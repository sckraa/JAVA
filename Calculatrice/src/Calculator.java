import javax.swing.*;
import java.awt.*;

public class Calculator extends JFrame {

    // Attributes
    private String[] tab_buttons = {"1", "2", "3", "4", "5", "6", "7", "8", "9", ".", "0", "=", "C", "+", "-", "*", "/"};
    private JPanel container = new JPanel();
    private JLabel display = new JLabel();

    // Builder
    public Calculator () {
        this.setSize(600,450);
        this.setLocation(600,200);
        this.setResizable( false );
        this.setTitle( "Calculator" );
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        // Adding the components
        init();
        // Adding the container
        this.setContentPane( container );
        this.setVisible( true );
    }


    // Methods
    private void init () {
        // Align the text on the right side
        display.setHorizontalAlignment( JLabel.RIGHT );
        display.setText( "205+5" );
        // Set background color for display
        display.setBackground( Color.cyan );
        display.setOpaque( true );
        // Sett the size for display
        display.setPreferredSize( new Dimension(300, 20) );

        // Display the components
        container.add(display);
    }


}
