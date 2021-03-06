package inf112.skeleton.app.Cards;

import com.badlogic.gdx.graphics.Texture;

public enum MoveType {
    BACKUP(-1, new Texture("cards/backUp.png")),
    UTURN(180, new Texture("cards/rotate.png")),
    ROTATE_RIGHT(-90, new Texture("cards/rotateRight.png")),
    ROTATE_LEFT(90, new Texture("cards/rotateLeft.png")),
    MOVEONE(1, new Texture("cards/move1.png")),
    MOVETWO(2, new Texture("cards/move2.png")),
    MOVETHREE(3, new Texture("cards/move3.png"));

    private int move;


    private Texture texture;


    int getMove() {
        return move;
    }

    public Texture getTexture() {
        return texture;
    }

    MoveType(int move, Texture texture) {
        this.move = move;
        this.texture = texture;

    }

}