import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;

public class Paint extends JFrame {

    private static final long serialVersionUID = 1L;

    // SECTIONS
    private JPanel west;
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
    private JMenuItem exit;

    // TOOL SECTION
    private Color color;
    private JLabel colorLabel;
    private JPanel colorPanel;
    private JButton colorPick;

    private JLabel colors;
    private JButton red;
    private JButton green;
    private JButton blue;
    private JButton black;

    private JSlider sliderPenSize;

    private JButton eraser;
    private JButton reset;
    private JButton back;

    public Paint() {
        final int width = 900;
        final int height = 700;

        setTitle( "Paint" );
        setSize( width, height );
        setLocation( 300, 10 );
        setIconImage( Toolkit.getDefaultToolkit().getImage(getClass().getResource( "./assets/img/icon.png" ) ) );
        getRootPane().setBorder( BorderFactory.createEmptyBorder( 0, 5, 5, 5 ) );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        // MAIN CONTAINER
        Container mainContainer = this.getContentPane();
        mainContainer.setBackground( new Color(204, 204, 204) );
        mainContainer.setLayout( new BorderLayout( 5, 5 ) );

        // INIT PAINT
        init();

        setVisible( true );
    }

    private void init() {
        Menu();
        PanelWest();
    }

    public void Menu() {
        // MENU BAR
        menu = new JMenuBar();

        // MENU
        file = new JMenu( "File" );
        edit = new JMenu( "Edit" );
        view = new JMenu( "View" );
        selection = new JMenu( "Selection" );
        find = new JMenu( "Find" );
        about = new JMenu( "About" );
        help = new JMenu( "Help" );

        // MENU ITEM
        save = new JMenuItem( "Save" );
        exit = new JMenuItem( "Exit" );

        colorMenu = new Color( 204, 204, 204 );

        // SAVE DRAW
        save.addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent actionEvent ) {
                BufferedImage image = new BufferedImage( paintArea.getWidth(), paintArea.getHeight(), BufferedImage.TYPE_INT_RGB );
                paintArea.paint( image.getGraphics() );
                try{
                    ImageIO.write( image, "png", new File( "./src/assets/draw.png" ) );
                } catch ( Exception e ) {
                    System.out.println( "Draw not saved " + e.getMessage() );
                }
            }
        });

        // EXIT APPLICATION
        exit.setMnemonic( KeyEvent.VK_Q );
        exit.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_Q, InputEvent.CTRL_MASK ) );
        exit.setToolTipText( "Exit application" );
        exit.addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent event ) {
                System.exit( 0 );
            }
        });

        // ADD MENU
        menu.add( file );
        menu.add( edit );
        menu.add( view );
        menu.add( selection );
        menu.add( find );
        menu.add( about );
        menu.add( help );
        file.add( save );
        file.add( exit );
        setJMenuBar( menu );
        menu.setBackground( colorMenu );
    }

    public void PanelWest() {
        west = new JPanel();
        west.setLayout( new FlowLayout() );

        JPanel gridPanel = new JPanel();
        gridPanel.setLayout( new GridLayout( 14, 1, 1, 10 ) );
        gridPanel.setBorder( BorderFactory.createEmptyBorder( 20, 10, 20, 10 ) );


        // COLOR CHOICE
        color = Color.BLACK;
        colorLabel = new JLabel( "Color : " );
        colorPick = new JButton( "Choose a color" );
        colorPanel = new JPanel();
        colorPanel.setBackground( color );

        // ACTION LISTENER FOR COLOR PICK BUTTON
        colorPick.addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent e ) {
                color = JColorChooser.showDialog( null, "Pick your color", color );

                if ( color == null ) {
                    color = Color.BLACK;
                }

                paintArea.setPenColor( color );
                colorPanel.setBackground( color );
            }
        });


        // COLORS RGB
        colors = new JLabel( "Colors : " );
        black = new JButton( "BLACK" );
        black.setBackground( Color.BLACK );
        black.setForeground( Color.WHITE );

        red = new JButton( "RED" );
        red.setBackground( Color.RED );

        blue = new JButton( "BLUE" );
        blue.setBackground( Color.BLUE );
        blue.setForeground( Color.WHITE );

        green = new JButton( "GREEN" );
        green.setBackground( Color.GREEN );


        // ACTION LISTENER FOR BUTTONS BLACK, RED, BLUE, GREEN
        black.addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent e ) {
                color = Color.BLACK;
                paintArea.setPenColor( color) ;
                colorPanel.setBackground( color );
            }
        });

        red.addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent e ) {
                color = Color.RED;
                paintArea.setPenColor( color );
                colorPanel.setBackground( color );
            }
        });

        blue.addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent e ) {
                color = Color.BLUE;
                paintArea.setPenColor( color );
                colorPanel.setBackground( color );
            }
        });

        green.addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent e ) {
                color = Color.GREEN;
                paintArea.setPenColor( color );
                colorPanel.setBackground( color );
            }
        });


        // SLIDER FOR PEN SIZE
        JLabel penSizeLabel = new JLabel( "Pen size :" );
        sliderPenSize = new JSlider( JSlider.HORIZONTAL, 0, 50, 10 );
        JLabel valueSlider = new JLabel( "Size = " + sliderPenSize.getValue() );

        // PEN SIZE CHANGE LISTENER
        sliderPenSize.addChangeListener( new ChangeListener() {
            public void stateChanged( ChangeEvent e ) {
                int size = sliderPenSize.getValue();
                paintArea.setPointRadius( size );
                valueSlider.setText( "Size = " + size );
            }
        });


        // ERASER
        Icon eraserIcon = new ImageIcon( "./src/assets/img/eraser_icon.png" );
        eraser = new JButton( "ERASER", eraserIcon );

        eraser.addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent e ) {
                color = paintArea.getBackgroundColor();
                paintArea.setPenColor( color );
                colorPanel.setBackground( color );
            }
        });


        // RESET
        Icon resetIcon = new ImageIcon( "./src/assets/img/synchronizing_icon.png" );
        reset = new JButton( "RESET", resetIcon );

        reset.addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent e ) {
                paintArea.resetArea();
                colorPanel.setBackground( Color.BLACK );
            }
        });


        // BACK
        Icon backIcon = new ImageIcon( "./src/assets/img/arrow-back_icon.png" );
        back = new JButton( "RETURN", backIcon );

        back.addActionListener( new ActionListener() {
           public void actionPerformed( ActionEvent e ) {
               if ( paintArea.getPointListSize() > 0 ) {
                   paintArea.removeLastElement();
               }
           }
        });


        // PAINT AREA
        paintArea = new PaintArea();

        // GRID PANEL ADD COMPONENTS
        gridPanel.add( colorLabel );
        gridPanel.add( colorPanel );
        gridPanel.add( colorPick );

        gridPanel.add( colors );
        gridPanel.add( red );
        gridPanel.add( green );
        gridPanel.add( blue );
        gridPanel.add( black );

        gridPanel.add( penSizeLabel );
        gridPanel.add( sliderPenSize );
        gridPanel.add( valueSlider );

        gridPanel.add( eraser );
        gridPanel.add( reset );
        gridPanel.add( back );


        // KEY LISTENER
        addKeyListener( new KeyListener() {

            // CTRL + Z EVENT
            @Override
            public void keyTyped( KeyEvent keyEvent ) {;}

            @Override
            public void keyPressed( KeyEvent keyEvent ) {
                if ( keyEvent.getKeyCode() == KeyEvent.VK_Z && paintArea.getPointListSize() > 0 )
                    paintArea.removeLastElement();
            }
            @Override
            public void keyReleased( KeyEvent keyEvent ){
                if ( keyEvent.getKeyCode() == KeyEvent.VK_Z && paintArea.getPointListSize() > 0 )
                    paintArea.removeLastElement();
            }

        });
        setFocusable( true );
        setFocusTraversalKeysEnabled( false );

        // ADD GRID PANEL
        west.add( gridPanel );
        west.setBorder( BorderFactory.createEmptyBorder( 40,0,0,0 ) );

        // ADD TOOL PANEL AND PAINT AREA
        add( paintArea );
        add( west, BorderLayout.WEST );
    }

    // MAIN
    public static void main(final String[] args) {
        new Paint();
    }
}