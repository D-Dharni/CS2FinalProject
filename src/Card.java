// Deven Dharni

import javax.swing.*;
import java.awt.*;

public class Card {
    // Instance Variables
    private int x;
    private int y;
    private int width;
    private int height;
    private boolean faceUp;
    private boolean matched;
    private Image image;
    private Image faceDownImage;
    private GameViewer window;

    // Main Constructor
    public Card (int x, int y, int width, int height, Image image, GameViewer window){
        // Initialize Instance Variables
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.image = image;
        this.window = window;
        this.faceUp = false;
        this.matched = false;
        this.faceDownImage = new ImageIcon("Resources/down.png").getImage();
    }

    public Image getImage() {
        return image;
    }

    public boolean isMatched() {
        return matched;
    }

    public void setMatched(boolean matched) {
        this.matched = matched;
    }

    public boolean hasCoordinates(int mouseX, int mouseY) {
        // Is mouse to right or left?
        boolean check1 = mouseX >= x;
        boolean check2 = mouseX <= (x+width);

        // Is mouse above or below?
        boolean check3 = mouseY >= y;
        boolean check4 = mouseY <= (y+height);

        return check1 && check2 && check3 && check4;
    }

    public void draw (Graphics g) {
        if (matched) {
            return;
        }
        // If it is face down then just draw the grey rectangle
        if (!faceUp) {
            g.drawImage(faceDownImage, x, y, width, height, window);
        }
        // If it isn't draw the specified image
        else if(faceUp) {
            g.drawImage(image, x, y, width, height, window);
        }
    }

    public void flip() {
        this.faceUp = !faceUp;
    }

    public boolean getFaceUp() {
        return this.faceUp;
    }
}
