import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

import javax.swing.*;
import java.io.IOException;

public class Arena {
    private int width;
    private int height;
    private Hero hero;

    public Arena (int width, int height) {
        this.height = height;
        this.width = width;
        hero = new Hero(width / 2, height / 2);
    }

    public void draw(Screen screen) throws IOException {
        hero.draw(screen);
    }

    private void moveHero(Position position) {
        if (canHeroMove(position)) {
            hero.setPosition(position);
        }
    }

    private boolean canHeroMove(Position position) {
        if (position.getX() == 0 || position.getX() == width) {
            return Boolean.FALSE;
        } else if (position.getY() == 0 || position.getY() == height) {
            return Boolean.FALSE;
        } else {
            return Boolean.TRUE;
        }
    }

    public void processKey(com.googlecode.lanterna.input.KeyStroke key) {
        if (key.getKeyType() == KeyType.ArrowUp) {
            moveHero(hero.moveUp());
        } else if (key.getKeyType() == KeyType.ArrowDown) {
            moveHero(hero.moveDown());
        } else if (key.getKeyType() == KeyType.ArrowLeft) {
            moveHero(hero.moveLeft());
        } else if (key.getKeyType() == KeyType.ArrowRight) {
            moveHero(hero.moveRight());
        }
    }
}
