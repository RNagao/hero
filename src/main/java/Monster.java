import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.io.IOException;
import java.util.Random;

public class Monster extends Element{

    public Monster(int x, int y) {
        super(x, y);
    }

    public Position move() {
        Random random = new Random();
        int option = random.nextInt(8);

        switch (option) {
            case 0:
                return new Position(this.getPosition().getX(), this.getPosition().getY() + 1);
            case 1:
                return new Position(this.getPosition().getX(), this.getPosition().getY() - 1);
            case 2:
                return new Position(this.getPosition().getX() + 1, this.getPosition().getY() + 1);
            case 3:
                return new Position(this.getPosition().getX() + 1, this.getPosition().getY() - 1);
            case 4:
                return new Position(this.getPosition().getX() - 1, this.getPosition().getY() + 1);
            case 5:
                return new Position(this.getPosition().getX() - 1, this.getPosition().getY() - 1);
            case 6:
                return new Position(this.getPosition().getX() + 1, this.getPosition().getY());
            case 7:
                return new Position(this.getPosition().getX() - 1, this.getPosition().getY());
            default:
                return null;
        }
    }

    @Override
    public void draw(TextGraphics graphics) throws IOException {
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(this.getPosition().getX(), this.getPosition().getY()), "M");
    }
}
