import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


public class GameViewer extends JFrame implements MouseListener, MouseMotionListener {
    private Game game;

    public GameViewer(Game game) {
        // Initialize Game
        this.game = game;

        // Set up Window
        setTitle("Memory Match Game");
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // MouseListener stuff
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    public Game getGame() {
        return game;
    }

    public void paint(Graphics g) {
        for (Card c: game.getCards()) {
            c.draw(g);
        }
    }


    // Used MouseListener Methods

    @Override
    public void mousePressed(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();
        // check if it is in bounds if it is then flip
        for (Card c: game.getCards()) {
            if (c.hasCoordinates(mouseX, mouseY)) {
                game.cardClick(c);
                break;
            }
        }
    }

    // Functions necessary for MouseListener and MouseMotionListener

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }
}
