import org.newdawn.slick.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MainGame extends BasicGame
{


    //Declares

    Character FirstPlayer;
    Image backgroundImage;
    PackedSpriteSheet MainSheet;

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
            appgc = new AppGameContainer(new ScalableGame(new MainGame("doknow"), 7680, 4320));
            //Das Spiel ist 640 Pixel auf 480 Pixel gross.


            //Naechste Zeile einkommentieren:
            //Führe das Spiel in halber Vollbildschirmgroesse aus. Gut bei hohen Aufloesungen!
            //appgc.setDisplayMode(appgc.getScreenWidth() / 2, appgc.getScreenHeight() / 2, false);

            appgc.start();
        } catch (SlickException ex) {
            Logger.getLogger(MainGame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
