package inf112.skeleton.app;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import inf112.skeleton.app.Cards.Deck;
import inf112.skeleton.app.Object.InputHandler;
import inf112.skeleton.app.Object.Robot;

import java.util.ArrayList;

public class RoboRally extends InputAdapter implements ApplicationListener {
    private SpriteBatch batch;
    private BitmapFont font;

    private TiledMap map;
    private TiledMapTileLayer boardLayer, playerLayer, holeLayer, flagLayer;

    private OrthogonalTiledMapRenderer render;

    private TiledMapTileLayer.Cell playerCell, playerWonCell, playerDiedCell;

    private Integer flagsToTake = 2;


    TextureRegion dead;

    TextureRegion win;

    private OrthographicCamera camera;

    private ExtendViewport viewport;

    Robot test;

    TextureRegion state1;

    TextureRegion[][] tr;


    Vector2 playerPosition;

    Robot test2;


    Deck deck;

    ArrayList<Robot> players;




    @Override
    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont();
        font.setColor(Color.RED);


        camera = new OrthographicCamera();
        viewport = new ExtendViewport(23,14);


        TmxMapLoader loader = new TmxMapLoader();
        map = loader.load("tutorial.tmx");

        //Layers initialize
        boardLayer = (TiledMapTileLayer) map.getLayers().get("Board");
        playerLayer = (TiledMapTileLayer) map.getLayers().get("Player");
        holeLayer = (TiledMapTileLayer) map.getLayers().get("Hole");
        flagLayer = (TiledMapTileLayer) map.getLayers().get("Flag");

        render = new OrthogonalTiledMapRenderer(map , 1/300f);

        //camera.position.set(gameport.getWorldWidth() / 2, gameport.getWorldHeight() / 2, 0);

        Texture texture = new Texture("player.png");

        Texture backup = new Texture("backUp.png");

        TextureRegion hand1 = new TextureRegion(backup, 342 , 522);

        deck = new Deck();


        // splitter opp player.png bildet og definerer størrelsen
        tr = TextureRegion.split(texture, 300, 300);


        state1 = tr[0][0];
        dead = tr[0][1];
        win = tr[0][2];


        playerPosition = new Vector2(0, 0);

        test = new Robot(state1,2,2);


        InputHandler myhandler = new InputHandler(test);

        test2 = new Robot(state1, 6, 2);

        players = new ArrayList<>();

        players.add(test);

        deck.dealOutCards(players);

        test.playerCardstoHand(test.getCards());

        Gdx.input.setInputProcessor(myhandler);
    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);

        viewport.apply();
        render.setView((OrthographicCamera) viewport.getCamera());
        render.render();

        System.out.println(test.getLockedHand().size());

        batch.setProjectionMatrix(viewport.getCamera().combined);
        batch.begin();
        test.draw(batch);
        test.render(batch);
        batch.end();



        if (holeLayer.getCell((int) test.getX(), (int) test.getY()) != null) {
            test.setRegion(dead);
        } else if (flagLayer.getCell((int) test.getX(), (int) test.getY()) != null) {
            test.setRegion(win);
            test.visitFlag(1);
        } else {
            test.setRegion(state1);
        }

        //allFlagsTaken(test);


    }


    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);

        viewport.getCamera().update();
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

/**
    public void allFlagsTaken(Robot player) {
        if (player.getFlag() == flagsToTake) {
            Gdx.app.exit();
        }
    }
*/



}