import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class ArenaTest {
    private int width = 20;
    private int height = 20;
    private Arena arena = new Arena(width,height);

    @Test
    public void draw() throws IOException {
        TextGraphics stubGraphics = Mockito.mock(TextGraphics.class);
        arena.draw(stubGraphics);
        Mockito.verify(stubGraphics, Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString("#336699"));
        Mockito.verify(stubGraphics, Mockito.times(1)).fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
    }

    @Test
    public void verifyMonsterCollisions() {

    }
}
