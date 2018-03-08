import java.util.*;

/**
 * On some field of X, Y landed a cat and some count of mice.
 * Cat can jump and eat a mouse. The distance of a jump of a cat is limited.
 * If the mouse is in range of the jump of the cat, then cat jump to his
 * coordinates and eat this mouse. If not, cat don't do anything, mouse will runaway.
 */

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        // Create a arrayList of mice
        List<Mouse> mice = new ArrayList<>();
        List<Mouse> deadMice = new ArrayList<>();

        // Setting land coordinates and max jump distance for a cat
        System.out.println("Set the coordinates for a Cat (x and y): ");
        Cat cat = new Cat(scan.nextInt(), scan.nextInt());
        System.out.println("Set the max jump distance: ");
        int catJumpLength = scan.nextInt();

        // Setting the count of mice
        // Coordinates of mice will be input randomly (max bounds XY = 50; min = -50)
        System.out.println("Set the count of mice: ");
            int n = scan.nextInt();
            for (int i =0; i<n; i++) {
                mice.add(i, new Mouse());
                mice.get(i).jumpRandom();
            }

        // List of all mice
        System.out.println("List of all mice:\n");
        for(int i = 0; i < mice.size(); i++) {
            System.out.println("Mouse №" + (i+1) +" X:"+ mice.get(i).getX()
                    + " Y:" + mice.get(i).getY());
        }

        // Print information about current position of a cat and distance to next mouse
        // If jump distance <= cat can reach, then cat will jump and eat mouse
            // In list of mice current mouse will be eaten(remove from list) and copy to dead mice list
        for(int i = 0; i < mice.size(); i++) {
            System.out.println("\nCat in:" + " X:"+  cat.getX()
                    + " Y:" + cat.getY());
            System.out.println("Distance to next mouse: " + distance(cat, mice.get(i)));
            if (distance(cat, mice.get(i)) <= catJumpLength) {
                System.out.println("Cat is jumping!");
                cat.hunt(mice.get(i));
                deadMice.add(mice.remove(i));
            }
        }

        // Print list of live mice
        System.out.println("\nList of mice that are runaway = " + mice.size());
            for(int i=0; i< mice.size(); i++) {
                System.out.println("Mouse №" + (i+1) +" X:"+ mice.get(i).getX()
                        + " Y:" + mice.get(i).getY());
            }

        // Print list of dead mice
        System.out.println("\nList of mice that are dead = " + deadMice.size());
        for(int i=0; i< deadMice.size(); i++) {
            System.out.println("Dead Mouse №" + (i+1) +" X:"+ deadMice.get(i).getX()
                    + " Y:" + deadMice.get(i).getY());
        }
    }

    // This function is calculate distance from cat to current mouse
    private static int distance(Cat cat, Mouse mice) {
        return (int) Math.sqrt(Math.pow(mice.getX() - cat.getX(), 2) + Math.pow(mice.getY() - cat.getY(), 2) );
    }
}
