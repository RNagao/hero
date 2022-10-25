import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class MonsterTest {
    private Monster monster;

    @BeforeEach
    public void setupMonster() { monster = new Monster(2, 3);}

    @Test
    public void move() {
        Position position = monster.move();

        Assertions.assertInstanceOf(Position.class, position);
    }

    @Test
    public void draw() throws IOException {
        TextGraphics stubGraphics = Mockito.mock(TextGraphics.class);
        monster.draw(stubGraphics);
        Mockito.verify(stubGraphics, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
        Mockito.verify(stubGraphics, Mockito.times(1)).enableModifiers(SGR.BOLD);
        Mockito.verify(stubGraphics, Mockito.times(1)).putString(new TerminalPosition(monster.getPosition().getX(), monster.getPosition().getY()), "M");
    }
}
