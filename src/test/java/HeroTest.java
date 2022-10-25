import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class HeroTest {
    @BeforeEach
    public void setupHero() {
        hero = new Hero(2, 3);
    }

    private Hero hero;

    @Test
    public void moveRight() {
        Position position = hero.moveRight();

        Assertions.assertEquals(3, position.getX());
        Assertions.assertEquals(3, position.getY());
    }

    @Test
    public void moveLeft() {
        Position position = hero.moveLeft();

        Assertions.assertEquals(1, position.getX());
        Assertions.assertEquals(3, position.getY());
    }

    @Test
    public void moveUp() {
        Position position = hero.moveUp();

        Assertions.assertEquals(2, position.getX());
        Assertions.assertEquals(2, position.getY());
    }

    @Test
    public void moveDown() {
        Position position = hero.moveDown();

        Assertions.assertEquals(2, position.getX());
        Assertions.assertEquals(4, position.getY());
    }

    @Test
    public void draw() throws IOException {
        TextGraphics stubGraphics = Mockito.mock(TextGraphics.class);
        hero.draw(stubGraphics);
        Mockito.verify(stubGraphics, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
        Mockito.verify(stubGraphics, Mockito.times(1)).enableModifiers(SGR.BOLD);
        Mockito.verify(stubGraphics, Mockito.times(1)).putString(new TerminalPosition(hero.getPosition().getX(), hero.getPosition().getY()), "X");
    }
}
