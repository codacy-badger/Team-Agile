package inf112.skeleton.app.Cards.CardTypes;

public class CardForwardOne implements IMoveCard {

    private int priority = 0;

    public CardForwardOne (int priority) {
        this.priority = priority;
    }

    public String getCardType() {
        return "movecard";
    }


    public int getTimesMoveForward() {
        return 1;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return this.priority;
    }
}
