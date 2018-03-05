class Cat extends Animal {

    Cat(int x, int y) {
        super();
        setX(x);
        setY(y);
    }

    public void hunt(Mouse mouse) {
        setX(mouse.getX());
        setY(mouse.getY());
    }

}
