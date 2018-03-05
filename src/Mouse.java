import java.util.Random;

public class Mouse extends Animal {

    private Random rand = new Random();

    Mouse() {
        super();
    }

    public void jumpRandom() {
        setX(rand.nextInt(50 - (-50)) + (-50));
        setY(rand.nextInt(50 - (-50)) + (-50));
    }

    public void jump(int x, int y) {
        setX(x);
        setY(y);
    }

    /*public int runAway(Mouse[] mice) {
        return mice.length;
    }*/

}
