import java.awt.*;
import java.awt.geom.*;
/**
 * Write a description of class BoxBall here.
 * 
 * @author Erick M
 * @version 2015.10.22
 */
public class BoxBall
{
    private static final int GRAVITY = 3;  // effect of gravity
    private Ellipse2D.Double circle;
    private Color color;
    private int diameter;
    private int xPosition;
    private int yPosition;
    private final int bottomwall;      // y position of ground
    private final int topwall;
    private final int leftwall;
    private final int rightwall;   
    private Canvas canvas;
    private int ySpeed = 4;                // initial downward speed
    private int xSpeed = 7;

    /**
     * Constructor for objects of class BouncingBall
     *
     * @param xPos  the horizontal coordinate of the ball
     * @param yPos  the vertical coordinate of the ball
     * @param ballDiameter  the diameter (in pixels) of the ball
     * @param ballColor  the color of the ball
     * @param groundPos  the position of the ground (where the wall will bounce)
     * @param drawingCanvas  the canvas to draw this ball on
     */
    public BoxBall(int xPos, int yPos, int ballDiameter, Color ballColor,
                          Canvas drawingCanvas)
    {
        xPosition = xPos;
        yPosition = yPos;
        color = ballColor;
        diameter = ballDiameter;
        canvas = drawingCanvas;
        leftwall = 0;
        rightwall = 600;
        topwall = 0;
        bottomwall = 500;
    }

    /**
     * Draw this ball at its current position onto the canvas.
     **/
    public void draw()
    {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition, diameter);
    }

    /**
     * Erase this ball at its current position.
     **/
    public void erase()
    {
        canvas.eraseCircle(xPosition, yPosition, diameter);
    }    

    /**
     * Move this ball according to its position and speed and redraw.
     **/
    public void move()
    {
        erase();

        yPosition += ySpeed;
        xPosition += xSpeed;

        if (xPosition < leftwall){
                xSpeed = -xSpeed;
            }
        if (xPosition > rightwall){
                xSpeed = -xSpeed;
            }
            if (yPosition < topwall){
                ySpeed = -ySpeed;
            }
        if (yPosition > bottomwall){
                ySpeed = -ySpeed;
            }
        // draw again at new position
        draw();
    }    

    /**
     * return the horizontal position of this ball
     */
    public int getXPosition()
    {
        return xPosition;
    }
}