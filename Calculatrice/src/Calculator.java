import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Calculator extends JFrame {

    // Attributes
    private String[] tab_name = { "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", "0", "=", "C", "+", "-", "*", "/" };
    private JButton[] tab_buttons = new JButton[ tab_name.length ];
    private JPanel container = new JPanel();
    private JLabel display = new JLabel();

    // Builder
    public Calculator () {
        this.setSize(280,320);
        this.setResizable( false );
        this.setTitle( "Calculator" );
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        this.setLocationRelativeTo(null);
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
        // Set the size for display
        display.setPreferredSize( new Dimension(215, 20) );

        // Panel for operators
        JPanel operator = new JPanel();
        operator.setPreferredSize( new Dimension(55,225) );
        operator.setBackground( Color.red );
        operator.setOpaque( true );

        // Panel for numbers
        JPanel number = new JPanel();
        number.setPreferredSize( new Dimension(165, 225) );
        number.setBackground( Color.darkGray );
        number.setOpaque( true );

        // Panel for display
        JPanel panelDisplay = new JPanel();
        panelDisplay.setPreferredSize( new Dimension(225,30) );
        panelDisplay.setBorder( BorderFactory.createLineBorder( Color.black ) );

        // Button creation
        for ( int i=0; i<tab_name.length; i++ ) {
            tab_buttons[i] = new JButton( tab_name[i] );
            tab_buttons[i].setPreferredSize( new Dimension( 50, 40) );
            // container.add( tab_buttons[i] );

            switch (i) {
                // For the operators we will add a specific event

                // Case 11 : Equal
                case 11 :
                    JButton equal = tab_buttons[i];
                    equal.addActionListener( new EqualListener() );
                    number.add( equal );
                break;

                // Case 12 : Reset
                case 12 :
                    JButton reset = tab_buttons[i];
                    reset.addActionListener( new ResetListener() );
                    operator.add( reset );
                break;

                // Case 13 : Addition
                case 13 :
                    JButton addition = tab_buttons[i];
                    addition.addActionListener( new AdditionListener() );
                    addition.setPreferredSize( new Dimension(50, 31) );
                    operator.add( addition );
                break;

                // Case 14 : Subtraction
                case 14 :
                    JButton subtraction = tab_buttons[i];
                    subtraction.addActionListener( new  SubtractionListener() );
                    subtraction.setPreferredSize( new Dimension(50, 31) );
                    operator.add( subtraction );
                break;

                // Case 15 : Multiplication
                case 15 :
                    JButton multiplication = tab_buttons[i];
                    multiplication.addActionListener( new MultiplicationListener() );
                    multiplication.setPreferredSize( new Dimension(50, 31) );
                    operator.add( multiplication );
                break;

                // Case 16 : Division
                case 16 :
                    JButton division = tab_buttons[i];
                    division.addActionListener( new DivisionListener() );
                    division.setPreferredSize( new Dimension(50, 31) );
                    operator.add( division );
                break;

                // Default
                default:
                    JButton selectedNumber = tab_buttons[i];
                    selectedNumber.addActionListener( new NumberListener() );
                    number.add( selectedNumber );
                break;
            }
        }

        // Display/Add the components
        panelDisplay.add( display );
        container.add( panelDisplay, BorderLayout.NORTH );
        container.add( number, BorderLayout.CENTER );
        container.add( operator, BorderLayout.EAST );
    }

}
