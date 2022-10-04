import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    private Screen screen;
    Hero hero = new Hero(10, 10);
    Boolean play = Boolean.TRUE;

    public Game() {
        try {
            TerminalSize terminalSize = new TerminalSize(40, 20);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();

            screen = new TerminalScreen(terminal);

            screen.setCursorPosition(null);
            screen.startScreen();
            screen.doResizeIfNecessary();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void draw() throws IOException {
        screen.clear();
        hero.draw(screen);
        screen.refresh();
    }

    public void run() throws IOException {
        while(play) {
            draw();
            KeyStroke key = screen.readInput();
            processKey(key);
        }
    }

    private void processKey(KeyStroke key) {
        KeyType keyType = key.getKeyType();
        if (keyType == KeyType.ArrowUp) {
            hero.HeroUp();
        } else if (keyType == KeyType.ArrowDown) {
            hero.HeroDown();
        } else if (keyType == KeyType.ArrowLeft) {
            hero.HeroLeft();
        } else if (keyType == KeyType.ArrowRight) {
            hero.HeroRight();
        } else if (keyType == KeyType.Character && key.getCharacter() == 'q') {
            try {
                screen.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if (keyType == KeyType.EOF) {
            play = Boolean.FALSE;
        }
    }
}
