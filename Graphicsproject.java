import java.awt.Color;
import java.util.Random;
import simplegraphics.*;

public class SGRandomWalk {
    public static void main(String[] args) {
        // Set up the field
        Canvas canvas = new Canvas("Random Walk Field", 300, 300);
        canvas.setBackground(Color.LIGHT_GRAY);

        // Set up the walker
        Ellipse walker = new Ellipse(145, 145, 10, 10);
        walker.setColor(Color.BLUE);
        walker.fill();

        // Draw the enclosing circle
        Ellipse enclosingCircle = new Ellipse(50, 50, 200, 200);
        enclosingCircle.setColor(Color.RED);
        enclosingCircle.draw();

        // Perform the random walk
        int steps = 0;
        while (enclosingCircle.contains(walker.getX(), walker.getY())) {
            int deltaX = getRandomDelta();
            int deltaY = getRandomDelta();

            walker.translate(deltaX, deltaY);

            canvas.pause(100); // pause for 100 milliseconds to visualize the movement

            steps++;
        }

        // Print the number of steps taken
        System.out.println("Number of steps to escape: " + steps);
    }

    private static int getRandomDelta() {
        Random random = new Random();
        return random.nextInt(21) - 10; // random delta in the range -10 to 10 (inclusive)
    }
}
