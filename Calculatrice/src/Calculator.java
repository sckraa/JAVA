import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {

    // Attributes
    private String[] tab_name = { "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", "0", "=", "C", "+", "-", "*", "/" };
    private JButton[] tab_buttons = new JButton[ tab_name.length ];
    private JPanel container = new JPanel();
    private JLabel display = new JLabel();
    private double number;
    private String operator = "";
    private boolean update = false;
    private boolean clickOperator = false;

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
        // Set the size for display
        display.setPreferredSize( new Dimension(215, 20) );

        // Panel for operators
        JPanel operatorPanel = new JPanel();
        operatorPanel.setPreferredSize( new Dimension(55,225) );
        operatorPanel.setBackground( Color.red );
        operatorPanel.setOpaque( true );

        // Panel for numbers
        JPanel numbersPanel = new JPanel();
        numbersPanel.setPreferredSize( new Dimension(165, 225) );
        numbersPanel.setBackground( Color.darkGray );
        numbersPanel.setOpaque( true );

        // Panel for display
        JPanel displayPanel = new JPanel();
        displayPanel.setPreferredSize( new Dimension(225,30) );
        displayPanel.setBorder( BorderFactory.createLineBorder( Color.black ) );

        // Button creation
        for ( int i=0; i<tab_name.length; i++ ) {
            tab_buttons[i] = new JButton( tab_name[i] );
            tab_buttons[i].setPreferredSize( new Dimension( 50, 43) );
            // container.add( tab_buttons[i] );

            switch (i) {
                // For the operators we will add a specific event

                // Case 11 : Equal
                case 11 :
                    JButton equal = tab_buttons[i];
                    equal.addActionListener( new EqualListener() );
                    numbersPanel.add( equal );
                break;

                // Case 12 : Reset
                case 12 :
                    JButton reset = tab_buttons[i];
                    reset.addActionListener( new ResetListener() );
                    operatorPanel.add( reset );
                break;

                // Case 13 : Addition
                case 13 :
                    JButton addition = tab_buttons[i];
                    addition.addActionListener( new AdditionListener() );
                    addition.setPreferredSize( new Dimension(50, 31) );
                    operatorPanel.add( addition );
                break;

                // Case 14 : Subtraction
                case 14 :
                    JButton subtraction = tab_buttons[i];
                    subtraction.addActionListener( new  SubtractionListener() );
                    subtraction.setPreferredSize( new Dimension(50, 31) );
                    operatorPanel.add( subtraction );
                break;

                // Case 15 : Multiplication
                case 15 :
                    JButton multiplication = tab_buttons[i];
                    multiplication.addActionListener( new MultiplicationListener() );
                    multiplication.setPreferredSize( new Dimension(50, 31) );
                    operatorPanel.add( multiplication );
                break;

                // Case 16 : Division
                case 16 :
                    JButton division = tab_buttons[i];
                    division.addActionListener( new DivisionListener() );
                    division.setPreferredSize( new Dimension(50, 31) );
                    operatorPanel.add( division );
                break;

                // Default
                default:
                    JButton selectedNumber = tab_buttons[i];
                    selectedNumber.addActionListener( new NumberListener() );
                    numbersPanel.add( selectedNumber );
                break;
            }
        }

        // Display/Add the components
        displayPanel.add( display );
        container.add( displayPanel, BorderLayout.NORTH );
        container.add( numbersPanel, BorderLayout.CENTER );
        container.add( operatorPanel, BorderLayout.EAST );
    }


    // Method of calculation
    private void calculation() {
        if ( operator.equals("+") ) {
            number += Double.parseDouble( display.getText() );
            display.setText( String.valueOf(number) );
        }
        if ( operator.equals("-") ) {
            number -= Double.parseDouble( display.getText() );
            display.setText( String.valueOf( number ) );
        }
        if ( operator.equals("*") ) {
            number *= Double.parseDouble( display.getText() );
            display.setText( String.valueOf( number ) );
        }
        if ( operator.equals("/") ) {
            number /= Double.parseDouble( display.getText() );
            display.setText( String.valueOf( number ) );
        }
    }


    // Reset Listener

    public class ResetListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            clickOperator = false;
            update = true;
            number = 0;
            operator = "";
            display.setText("");
        }
    }

    // Number Listener

    public class NumberListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String s = ((JButton) actionEvent.getSource()).getText();

            if ( update ) {
                update = false;
            } else {
                if ( !display.getText().equals("0") )
                    s = display.getText() + s;
            }
            display.setText(s);
        }
    }

    // Equal Listener

    public class EqualListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            calculation();
            update = true;
            clickOperator = false;
        }
    }

    // Addition Listener

    public class AdditionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if ( clickOperator ) {
                calculation();
                display.setText( String.valueOf( number ) );
            } else {
                number = Double.parseDouble( display.getText() );
                clickOperator = true;
            }
            operator = "+";
            update = true;
        }
    }

    // Subtraction Listener

    public class SubtractionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if ( clickOperator ) {
                calculation();
                display.setText( String.valueOf( number ));
            } else {
                number = Double.parseDouble( display.getText() );
                clickOperator = true;
            }
            operator = "-";
            update = true;
        }
    }

    // Multiplication Listener

    public class MultiplicationListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if ( clickOperator ) {
                calculation();
                display.setText( String.valueOf( number ) );
            } else {
                number = Double.parseDouble( display.getText() );
                clickOperator = true;
            }
            operator = "*";
            update = true;
        }
    }

    // Division Listener

    public class DivisionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if ( clickOperator ) {
                calculation();
                display.setText( String.valueOf( number ) );
            } else {
                number = Double.parseDouble( display.getText() );
                clickOperator = true;
            }
            operator = "/";
            update = true;
        }
    }
}


