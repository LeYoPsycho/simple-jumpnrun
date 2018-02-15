import org.newdawn.slick.*;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.tiled.TiledMap;

import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainGame extends BasicGame
{

    //Variables
    static int _width, _height;


    //Declares

    Character firstPlayer;
    PackedSpriteSheet mainSheet;
    Color backgroundColor;
    TiledMap mainMap;

    //Constructor
    public MainGame(String gamename)
    {
        super(gamename);
    }



    @Override
    public void init(GameContainer gc) throws SlickException {
        //Inits
        mainMap = new TiledMap("./res/sprites/FirstMap.tmx");
        mainSheet = new PackedSpriteSheet("./res/sprites/sprites_data.def");
        firstPlayer = new Character(mainSheet.getSprite("mario.png"), 0, _height - mainSheet.getSprite("mario.png").getHeight() -16);
        backgroundColor = new Color(92, 148, 252);

        gc.getInput().enableKeyRepeat();
    }



    @Override
    public void update(GameContainer gc, int delta) throws SlickException {

        if(gc.getInput().isKeyDown(Input.KEY_D)) {
            firstPlayer.moveRight(delta);
        }

        if(gc.getInput().isKeyDown(Input.KEY_A)) {
            firstPlayer.setCharacterX(firstPlayer.getCharacterX() + -5);
        }

        if(gc.getInput().isKeyDown(Input.KEY_SPACE)) {
            firstPlayer.setCharacterY(firstPlayer.getCharacterY() - 5);

        }


    }

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException {
        //Draw Background
        //g.setColor(backgroundColor);
        //g.fillRect(0, 0, gc.getScreenWidth(), gc.getScreenHeight());

        //Draw Map
        mainMap.render(0, 0);

        //Draw Player Sprite
        //firstPlayer.draw();

        //Draw Ground Sprites
        /*int i=0;
        while (i<650) {
            g.drawImage(mainSheet.getSprite("ground_1.png"), i, _height - mainSheet.getSprite("ground_1.png").getHeight());
            i = i+16;
        }*/
    }

    public static void main(String[] args) {
        try {
            AppGameContainer appgc;
            _width = 640; //Ganz unsauberer Code an der Stelle, ich weiß
            _height = 480;
            appgc = new AppGameContainer(new ScalableGame(new MainGame("Super Duper Mario Bros"), _width, _height));

            //appgc.setDisplayMode(appgc.getScreenWidth() / 2, appgc.getScreenHeight() / 2, false);


            appgc.start();
        } catch (SlickException ex) {
            Logger.getLogger(MainGame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
