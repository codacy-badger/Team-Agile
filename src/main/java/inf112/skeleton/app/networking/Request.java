package inf112.skeleton.app.networking;

public class Request {
    public String text;
    public int keycode;

    public void setMove(int keycode) {
        keycode = this.keycode;
    }
    public int getMove() {
        return this.keycode;
    }
}