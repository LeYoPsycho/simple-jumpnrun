import org.newdawn.slick.*;

//Classes

public class Character {

    //Property
    private Image marioNormal, marioMove;
    private float characterX, characterY;
    private float characterSpeed;
    private float characterSpeedY;
    static float groundZero;
    private float gravitation, jumpSpeed;
    private boolean jumpActivated = false, jumpIsActivated = false;


    //Init
    Character(PackedSpriteSheet characterSheet, GameContainer gc) {
        characterX = 0;
        characterY = gc.getHeight() - 64;
        groundZero = gc.getHeight() - 64;
        characterSpeed = 0.3f;
        gravitation = 0.2f;
        marioNormal = characterSheet.getSprite("mario.png");
        marioMove = characterSheet.getSprite("mario_walk.png");
    }

    //Set Propertys
    void setCharacterX(float x) {
        characterX = x;
    }

    void setCharacterY(float y) {
        characterY = y;
    }

    float getCharacterX() {
        return characterX;
    }

    float getCharacterY() {
        return characterY;
    }

    //Functions
    void moveRight(int delta) {
        characterX = characterX + characterSpeed * delta;
    }

    void moveLeft(int delta){
        characterX = characterX - characterSpeed * delta;
    }

    void jump(){
        if (!jumpIsActivated){
            jumpActivated = true;
            jumpSpeed = 0.6f;
        }
    }

    void update(int delta, GameContainer gc) {
        characterY += gravitation*delta;
        if (jumpActivated){
            jumpIsActivated = true;
            characterY -= jumpSpeed * delta;
            jumpSpeed -= 0.01f;//
            if (jumpSpeed <= 0){
                jumpActivated = false;
            }
        }

        if (characterY > gc.getHeight() - 64) {
            characterY = gc.getHeight() - 64;
            jumpIsActivated = false;
        }
    }

    void draw(){
        marioNormal.draw(characterX, characterY);
    }
}
