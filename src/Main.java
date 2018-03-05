import java.util.*;

public class Main {

    private static Scanner scan = new Scanner(System.in);
    private static Cat cat;
    private static int catJumpLength;
    //private static Mouse mice = new Mouse();
    private static List<Mouse> mice = new ArrayList<Mouse>();

    public static void main(String[] args) {
        System.out.println("Set the coordinates for a Cat (x and y): ");
            cat = new Cat(scan.nextInt(), scan.nextInt());

        System.out.println("Set the max jump distance: ");
            catJumpLength = scan.nextInt();

        System.out.println("Set the count of mouses: ");
            int n = scan.nextInt();
            for (int i =0; i<n; i++) {
                mice.add(i, new Mouse());
                mice.get(i).jumpRandom();
            }

        for(int i = 0; i < mice.size(); i++) {
            System.out.println("Mouse №" + (i+1) +" X:"+ mice.get(i).getX()
                    + " Y:" + mice.get(i).getY());
        }

        for(int i = 0; i < mice.size(); i++) {
            System.out.println("\nCat in:" + " X:"+  cat.getX()
                    + " Y:" + cat.getY());

            /*System.out.println("Mouse №" + (i+1) +" X: "+ mice.get(i).getX()
                    + " Y: " + mice.get(i).getY());*/

            System.out.println("Distance to next mouse: " + distance(cat, mice.get(i)));
            if (distance(cat, mice.get(i)) <= catJumpLength) {
                System.out.println("Cat is jumping!");
                cat.hunt(mice.get(i));
                mice.remove(i);
            }
        }

        System.out.println("\nCount of mice that are runaway = " + mice.size());
    }

    private static int distance(Cat cat, Mouse mice) {
        return (int) Math.sqrt(Math.pow(mice.getX() - cat.getX(), 2) + Math.pow(mice.getY() - cat.getY(), 2) );
    }
}
