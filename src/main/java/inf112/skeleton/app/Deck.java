package inf112.skeleton.app;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    public ArrayList<Programcard> cards;


    public Deck() {


        // RotateRight( 1,1,NORD) - 18 stk. legg til i deck.
        // RotateRight( 1,1,NORD) - 18 stk. legg til i deck.
        // RotateRight( 1,1,NORD) - 18 stk. legg til i deck.
        // RotateRight( 1,1,NORD) - 18 stk. legg til i deck.
        // RotateRight( 1,1,NORD) - 18 stk. legg til i deck.


    }


    public void shuffleDeck() {
        Collections.shuffle(cards);
    }

    public void createDeck() {


        for (int i = 80; i <= 420 ; i += 20) {
           Programcard card = new Programcard();
           



        }

    }

}



    /*
har en bevegelse (Flytt frem 1, Flytt frem 2, Flytt frem 3, Flytt bakover 1, Roter 90 grader H, Roter 90 grader V, Roter 180 grader)

har en prioritet (alle bevegelseskort må ha unik prioritet innenfor sin klasse, og mellom klassene (bevegelsestypene) skal intervallet ikke være overlappende)

backup: 6 kort (430 - 480)

u-turn: 6 kort (10 - 60)

rotate right: 18 kort (80-420, intervall 20)

rotate left: 18 kort (70-410, intervall 20)

move 1: 18 kort (490 - 650, intervall 10)

move 2: 12 kort (670 - 780, intervall 10)

move 3: 6 kort (790 - 840, intervall 10)
 */

