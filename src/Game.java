import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Game {
    private GameViewer window;
    private ArrayList<Card> cards;
    private ArrayList<Card> faceUpCards;

    public Game() {
        // Get images and shuffle them
        ArrayList<Image> images = loadCardImages();
        shuffle(images);

        // Initialize cards
        this.cards = new ArrayList<>();

        // Initialize window
        this.window = new GameViewer(this);

        // Initialize faceUpCards
        this.faceUpCards = new ArrayList<Card>();

        // Variables for putting images in cards

        int cardWidth = 100;
        int cardHeight = 150;
        int space = 20;
        int startX = 100;
        int startY = 100;

        // Put images in cards

        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                // Set x and y
                int x = startX + col * (cardWidth + space);
                int y = startY + row * (cardHeight + space);

                // Take an image
                Image img = images.remove(0);

                // Make card and add it
                Card card = new Card(x, y, cardWidth, cardHeight, img, window);
                cards.add(card);
            }
        }
    }

    public void cardClick(Card c) {
        if (faceUpCards.size() == 2) {
            // Flip the first one back down and remove it
            Card flip = faceUpCards.remove(0);
            flip.flip();
        }

        // Flip the clicked card and add it
        c.flip();
        faceUpCards.add(c);

        // Repaint
        window.repaint();
    }

    private ArrayList<Image> loadCardImages() {
        ArrayList<Image> images = new ArrayList<Image>();
        for (int i = 0; i < 8; i++) {
            String fileName = "Resources/";
            Image img = new ImageIcon(fileName + i + ".png").getImage();
            images.add(img);
            images.add(img);
        }
        return images;
    }

    private void shuffle(ArrayList<Image> images) {
        // Loop backwards to swap each item with a random item earlier in the arraylist
        for (int i = images.size() - 1; i > 0; i--) {
            // Random index between 0 and i (inclusive)
            int j = (int) (Math.random() * (i+1));

            // Swap the images
            Image temp = images.get(i);
            images.set(i, images.get(j));
            images.set(j, temp);
        }
    }

    public static void main (String[] args){
        Game game = new Game();
        game.getWindow().repaint();
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public GameViewer getWindow() {
        return window;
    }
}