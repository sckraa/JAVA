import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class PaintArea extends JPanel {

    private static final long serialVersionUID = 1L;

    private Color backgroundColor;
    private Color penColor;
    private int pointX, pointY, pointR;
    private ArrayList<Point> pointList;

    public PaintArea() {

        this.addMouseListener( new MouseEventHandler() );
        this.addMouseMotionListener( new MouseMotionHandler() );

        backgroundColor = new Color( 255, 255, 255 );
        penColor = new Color( 0, 0, 0 );
        this.setBackground( backgroundColor );

        pointList = new ArrayList<Point>();
        pointR = 10;
    }

    public void paintComponent( Graphics graphics ) {
        super.paintComponent( graphics );

        for ( Point point : pointList ) {
            point.drawPoint( graphics );
        }
    }

    public void setBackgroundColor( Color color ) {
        this.backgroundColor = color;
    }

    public void setPenColor( Color color ) {
        this.penColor = color;
    }

    public void setPointRadius( int radius ) {
        this.pointR = radius;
    }

    public Color getBackgroundColor() { return this.backgroundColor; }

    public int getPointListSize() { return this.pointList.size(); }

    public void removeLastElement() {
        this.pointList.remove( this.pointList.size() - 1 );
        repaint();
    }

    public void resetArea() {
        backgroundColor = new Color( 255, 255, 255 );
        penColor = new Color( 0, 0, 0 );
        pointList.clear();
        repaint();
    }

    private class MouseEventHandler implements MouseListener {
        @Override
        public void mousePressed( MouseEvent e ) {
            pointX = e.getX() - ( pointR / 2 );
            pointY = e.getY() - ( pointR / 2 );

            pointList.add( new Point( pointX, pointY, pointR, penColor ) );
            repaint();
        }

        @Override
        public void mouseReleased( MouseEvent e ) {
            ;
        }

        @Override
        public void mouseClicked( MouseEvent e ) {
            ;
        }

        @Override
        public void mouseEntered( MouseEvent e ) {
            ;
        }

        @Override
        public void mouseExited( MouseEvent e ) {
            ;
        }
    }

    private class MouseMotionHandler implements MouseMotionListener {
        @Override
        public void mouseDragged( MouseEvent e ) {
            pointX = e.getX() - ( pointR / 2 );
            pointY = e.getY() - ( pointR / 2 );

            pointList.add( new Point( pointX, pointY, pointR, penColor ) );
            repaint();
        }

        @Override
        public void mouseMoved( MouseEvent e ) {
            ;
        }
    }

}