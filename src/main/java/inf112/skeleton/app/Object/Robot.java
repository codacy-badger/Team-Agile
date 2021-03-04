package inf112.skeleton.app.Object;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import inf112.skeleton.app.Cards.PlayingCard;

import java.util.ArrayList;

public class Robot extends Sprite {

    private final int WIDTH = 1;
    private final int HEIGHT = 1;
    public int healthpoint;
    private ArrayList<PlayingCard> cards;
    private ArrayList<PlayingCard> lockedHand;
    int totalFlags = 3;
    int flagToTake;
    BitmapFont priorityfont = new BitmapFont(Gdx.files.internal("fonts/17green.fnt"));



    public ArrayList<PlayingCard> getLockedHand() {
        return lockedHand;
    }

    public Robot(TextureRegion texture, int xstart, int ystart) {
        setSize(WIDTH, HEIGHT);
        setRegion(texture);
        setOriginCenter();
        setPosition(xstart, ystart);
        this.healthpoint = 9;
        this.cards = new ArrayList<>(healthpoint);
        this.lockedHand = new ArrayList<>();
        this.flagToTake = 1;

    }

    public int getHealthpoint() {
        return healthpoint;
    }


    public ArrayList<PlayingCard> getCards() {
        return cards;
    }


    public void playerCardstoHand(ArrayList<PlayingCard> spillerkort) {
        int x = 14;
        int y = 10;
        for (int i = 0; i < spillerkort.size() ; i++ ) {
            PlayingCard nvKort = spillerkort.get(i);
            nvKort.setPosition( x,  y);
            x += 2;
            if(x == 24 ) {
                x = 15;
                y = 7;
            }
        }
    }

    public void playerLocked(ArrayList<PlayingCard> lockedkort) {
        int x = 14;
        int y = 3;
        for (int i = 0; i < lockedkort.size() ; i++ ) {
            PlayingCard kort = lockedkort.get(i);
            kort.setPosition( x, y);
            x += 2;
        }
    }

    public void renderCards(Batch batch) {
        for (PlayingCard kort : cards) {
            kort.draw(batch);
        }
        for (PlayingCard locked : lockedHand) {
            locked.draw(batch);
        }
    }

    public void renderPriority(Batch batch) {
        float xStart = 842f;
        float yStart = 682f;

        for (PlayingCard kort : cards) {
            int priority = kort.getPriority();
            priorityfont.draw(batch, Integer.toString(priority), xStart , yStart);
            xStart += 112;

            if(xStart == 1402) {
                xStart = 898;
                yStart = 520;
            }
        }
        xStart = 842;
        yStart = 307;
        for (PlayingCard locked : lockedHand) {
            int priority = locked.getPriority();
            priorityfont.draw(batch, Integer.toString(priority), xStart , yStart);
            xStart += 112;
        }

    }


    public void visitFlag(int flagID) {
        if (flagID > flagToTake) {
            return;
        }
        if (flagID == flagToTake) {
            flagToTake += 1;
            System.out.println("flag: " + flagID + " was taken");
            System.out.println(flagToTake);
        }
    }

    public Integer getFlag() {
        return flagToTake;
    }
}

