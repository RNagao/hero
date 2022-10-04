import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class Hero {
    int x;
    int y;

    public Hero(int column, int row) {
        x = column;
        y = row;
    }

    public void HeroRight() {
        x += 1;
    }

    public void HeroLeft() {
        x -= 1;
    }

    public void HeroUp() {
        y -= 1;
    }

    public void HeroDown() {
        y += 1;
    }

    public void draw(Screen screen) throws IOException {
        screen.setCharacter(x, y, TextCharacter.fromCharacter('X')[0]);
    }
}
