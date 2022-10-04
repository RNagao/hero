import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class Hero {
    private int x;
    private int y;

    public Hero(int column, int row) {
        x = column;
        y = row;
    }

    public void moveRight() {
        x += 1;
    }

    public void moveLeft() {
        x -= 1;
    }

    public void moveUp() {
        y -= 1;
    }

    public void moveDown() {
        y += 1;
    }

    public void draw(Screen screen) throws IOException {
        screen.setCharacter(x, y, TextCharacter.fromCharacter('X')[0]);
    }
}
