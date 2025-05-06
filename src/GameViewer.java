import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class GameViewer extends JFrame implements MouseListener{
    private Game game;
    private final int WINDOW_WIDTH = 1000;
    private final int WINDOW_LENGTH = 800;

    public GameViewer(Game game) {
        // Initialize Game
        this.game = game;

        // Set up Window
        setTitle("Memory Match Game");
        setSize(WINDOW_WIDTH, WINDOW_LENGTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // MouseListener stuff
        this.addMouseListener(this);
    }

    public Game getGame() {
        return game;
    }

    public void paint(Graphics g) {
        // Clear the window.
        g.setColor(Color.black);
        g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_LENGTH);

        if (game.getState().equals("game")) {
            for (Card c: game.getCards()) {
                c.draw(g);
            }

            g.setColor(Color.white);
            g.setFont(new Font("Arial", Font.BOLD, 24));
            g.drawString("Moves: " + game.getMoves(), 100, 100);
        }
        else {
            // Draw Game Over
            g.setFont(new Font("Arial", Font.BOLD, 36));
            g.drawImage(new ImageIcon("Resources/GameOver.png").getImage(), 0, 0, WINDOW_WIDTH, WINDOW_LENGTH, this);

            g.setColor(Color.white);
            g.drawString("Final Number of Moves: " + game.getMoves(), 225, 100);
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
}
