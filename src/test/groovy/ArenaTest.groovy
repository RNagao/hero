import com.googlecode.lanterna.TerminalPosition
import com.googlecode.lanterna.TerminalSize
import com.googlecode.lanterna.TextColor
import com.googlecode.lanterna.graphics.TextGraphics
import org.junit.jupiter.api.Test

class ArenaTest {
    private int width = 20;
    private int height = 20;
    private Arena arena = new Arena(width,height);

    def "Should verify if draw functions were called"(){
        given:
            def graphics = Mock(TextGraphics)
        when:
            graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
            graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        then:
            1 * graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
            1 * graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
    }
}
