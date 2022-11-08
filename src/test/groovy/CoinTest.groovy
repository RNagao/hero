import com.googlecode.lanterna.SGR
import com.googlecode.lanterna.TerminalPosition
import com.googlecode.lanterna.TextColor
import com.googlecode.lanterna.graphics.TextGraphics

class CoinTest {
    private Coin coin = new Coin (2,3)

    def "Should verify if draw functions were called"(){
        given:
            def graphics = Mock(TextGraphics)
        when:
            graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
            graphics.enableModifiers(SGR.BOLD);
            graphics.putString(new TerminalPosition(coin.getPosition().getX(), coin.getPosition().getY()), '$');
        then:
            1 * graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
            1 * graphics.enableModifiers(SGR.BOLD);
            1 * graphics.putString(new TerminalPosition(coin.getPosition().getX(), coin.getPosition().getY()), '$');

    }
}
