import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class HeroTest {
    Hero hero;

    @BeforeEach
    public void setupHero() {
        hero = new Hero(2, 3);
    }

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
    public void draw() {
        Mockito.verify(hero.draw(graphics));
    }
}
