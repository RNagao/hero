import com.googlecode.lanterna.SGR
import com.googlecode.lanterna.TerminalPosition
import com.googlecode.lanterna.TextColor
import com.googlecode.lanterna.graphics.TextGraphics

class HeroTest {
    def "Should move right"(){
        given:
            Hero hero = new Hero (2,3)
        when:
            hero.moveRight()
        then:
            hero.getPosition().getX() == 3
            hero.getPosition().getY() == 3
    }

    def "Should move left"(){
        given:
            Hero hero = new Hero (2,3)
        when:
            hero.moveLeft()
        then:
            hero.getPosition().getX() == 1
            hero.getPosition().getY() == 3
    }

    def "Should move up"(){
        given:
            Hero hero = new Hero (2,3)
        when:
            hero.moveUp()
        then:
            hero.getPosition().getX() == 2
            hero.getPosition().getY() == 2
    }

    def "Should move down"(){
        given:
            Hero hero = new Hero (2,3)
        when:
            hero.moveDown()
        then:
            hero.getPosition().getX() == 2
            hero.getPosition().getY() == 4
    }

    def "Should verify if draw functions were called"(){
        given:
            Hero hero = new Hero (2,3)
            def graphics = Mock(TextGraphics)
        when:
            graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
            graphics.enableModifiers(SGR.BOLD);
            graphics.putString(new TerminalPosition(hero.getPosition().getX(), hero.getPosition().getY()), 'X');
        then:
            1 * graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
            1 * graphics.enableModifiers(SGR.BOLD);
            1 * graphics.putString(new TerminalPosition(hero.getPosition().getX(), hero.getPosition().getY()), 'X');
    }
}
