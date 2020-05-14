import java.awt.*;

public class Point {

    private int pointX, pointY, pointR;
    private Color color;

    public Point( int pointX, int pointY, int pointR, Color color ) {
        this.pointX = pointX;
        this.pointY = pointY;
        this.pointR = pointR;
        this.color = color;
    }

    public void drawPoint( Graphics graphic ) {
        graphic.setColor( color );
        graphic.fillOval( pointX, pointY, pointR, pointR );
    }
}