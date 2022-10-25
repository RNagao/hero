import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PositionTest {
    private Position position;

    @BeforeEach
    public void setupPosition() { position = new Position(2,3);}

    @Test
    public void getX() {
        Assertions.assertEquals(2, position.getX());
    }

    @Test
    public void getY() {
        Assertions.assertEquals(3, position.getY());
    }

    @Test
    public void setX() {
        position.setX(5);
        Assertions.assertEquals(5, position.getX());
    }

    @Test
    public void setY() {
        position.setY(5);
        Assertions.assertEquals(5, position.getY());
    }

    @Test
    public void equals() {
        Position position2 = new Position(2,3);
        Assertions.assertTrue(position.equals(position2));
    }
}
