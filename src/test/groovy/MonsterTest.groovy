import com.googlecode.lanterna.SGR
import com.googlecode.lanterna.TerminalPosition
import com.googlecode.lanterna.TextColor
import com.googlecode.lanterna.graphics.TextGraphics

class MonsterTest {
    def "Should move"(){
        given:
            Monster monster = new Monster (2,3)
        when:
            monster.move()
        then:
            1 * monster.move()
    }

    def "Should verify if draw functions were called"(){
        given:
            Monster monster = new Monster (2,3)
            def graphics = Mock(TextGraphics)
        when:
            graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
            graphics.enableModifiers(SGR.BOLD);
            graphics.putString(new TerminalPosition(monster.getPosition().getX(), monster.getPosition().getY()), 'M');
        then:
            1 * graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
            1 * graphics.enableModifiers(SGR.BOLD);
            1 * graphics.putString(new TerminalPosition(monster.getPosition().getX(), monster.getPosition().getY()), 'M');
    }
}
