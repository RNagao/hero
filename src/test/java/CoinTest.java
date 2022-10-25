import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class CoinTest {
    private Coin coin;

    @BeforeEach
    public void setupCoin() { coin = new Coin(2,3);}

    @Test
    public void draw() throws IOException {
        TextGraphics stubGraphics = Mockito.mock(TextGraphics.class);
        coin.draw(stubGraphics);
        Mockito.verify(stubGraphics, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
        Mockito.verify(stubGraphics, Mockito.times(1)).enableModifiers(SGR.BOLD);
        Mockito.verify(stubGraphics, Mockito.times(1)).putString(new TerminalPosition(coin.getPosition().getX(), coin.getPosition().getY()), "$");
    }
}
