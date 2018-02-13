import org.newdawn.slick.*;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainGame extends BasicGame
{


    //Declares

    Character FirstPlayer;
    Image backgroundImage;
    PackedSpriteSheet MainSheet;

    //Constructor
    public MainGame(String gamename)
    {
        super(gamename);
    }



    @Override
    public void init(GameContainer gc) throws SlickException {
        //Inits
        MainSheet = new PackedSpriteSheet("./res/sprites/sprites_data.def");
        FirstPlayer = new Character(MainSheet.getSprite("Mario.gif"), 20, 340);
        backgroundImage = new Image("./res/sprites/background.png");

        gc.getInput().enableKeyRepeat();
    }


    @Override
    public void update(GameContainer gc, int delta) throws SlickException {

        //if(gc.getInput().isKeyDown(Input.KEY_A))
    }

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException {
        //Draw Background
        g.drawImage(backgroundImage, 0, 0);
        g.drawImage(FirstPlayer.getCharacterImage(), FirstPlayer.getCharacterX(), FirstPlayer.getCharacterY());

    }

    public static void main(String[] args) {
        try {
            AppGameContainer appgc;
            appgc = new AppGameContainer(new ScalableGame(new MainGame("Super Duper Mario Bros"), 1280, 720));

            appgc.setDisplayMode(appgc.getScreenWidth() / 2, appgc.getScreenHeight() / 2, false);


            appgc.start();
        } catch (SlickException ex) {
            Logger.getLogger(MainGame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
