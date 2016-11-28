public class Brick {
    int[] theArray = new int[10];
    public int x, y;
    public int length, width;

    public Brick(int x, int y, int length, int width) {
        length = 4;
        width = 4;
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth(){
        return width;
    }

    public int getLength() {
        return length;
    }
}
