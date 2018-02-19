import org.newdawn.slick.*;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.tiled.TiledMap;

import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainGame extends BasicGame
{

    //Declares

    Character firstPlayer;
    PackedSpriteSheet mainSheet;
    TiledMap mainMap;

    //Constructor
    public MainGame(String gamename)
    {
        super(gamename);
    }



    @Override
    public void init(GameContainer gc) throws SlickException {
        //Inits
        mainMap = new TiledMap("./res/sprites/main_map.tmx", "res/sprites");
        mainSheet = new PackedSpriteSheet("./res/sprites/sprites_data.def");
        firstPlayer = new Character(mainSheet, gc);

        gc.getInput().enableKeyRepeat();
    }



    @Override
    public void update(GameContainer gc, int delta) throws SlickException {
        //Update
        firstPlayer.update(delta, gc);

        //Key Inputs
        if(gc.getInput().isKeyDown(Input.KEY_D)) {
            firstPlayer.moveRight(delta);
        }

        if(gc.getInput().isKeyDown(Input.KEY_A)) {
            firstPlayer.moveLeft(delta);
        }

        if(gc.getInput().isKeyPressed(Input.KEY_SPACE)) {
            firstPlayer.jump();

        }


    }

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException {
        //Draw Map
        mainMap.render(0, 0);



        //Draw Player Sprite
        firstPlayer.draw();
    }

    public static void main(String[] args) {
        try {
            AppGameContainer appgc;
            appgc = new AppGameContainer(new MainGame("Super Duper Mario Bros"));

            appgc.setDisplayMode(1280, 720, false);

            appgc.setVSync(true);
            appgc.setShowFPS(false);
            appgc.start();
        } catch (SlickException ex) {
            Logger.getLogger(MainGame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
