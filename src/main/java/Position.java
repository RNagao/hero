public class Position {
    private int x;
    private int y;

    public Position(int column, int row) {
        x = column;
        y = row;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
