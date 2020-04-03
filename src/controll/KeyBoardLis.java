package controll;

import mazeDataStructure.Direction;
import model.IPacMan;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoardLis implements KeyListener {
    private IPacMan pacMan;


    public KeyBoardLis(IPacMan pacMan) {
        this.pacMan = pacMan;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            pacMan.setDirectionQ(Direction.TOP);
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            pacMan.setDirectionQ(Direction.RIGHT);
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            pacMan.setDirectionQ(Direction.LEFT);
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            pacMan.setDirectionQ(Direction.BOTTOM);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
