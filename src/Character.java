import org.newdawn.slick.*;

//Classes

public class Character {

    //Property
    private Image characterImage;
    private float characterX, characterY, jumpHeight;
    private float characterSpeed, maxJumpHeight;
    private boolean isMaxHeightReached, isMoving;


    //Init
    Character(Image characterImage, float startPosX, float startPosY) {
        this.characterImage = characterImage;
        characterX = startPosX;
        characterY = startPosY;
        characterSpeed = 0.3f;

    }

    //Set Propertys
    void setCharacterX(float x) {
        characterX = x;
    }

    void setCharacterY(float y) {
        characterY = y;
    }

    void setMovingState(boolean characterIsMoving) {
        isMoving = characterIsMoving;
    }

    //Get Propertys
    Image getCharacterImage() {
        return characterImage;
    }

    float getCharacterX() {
        return characterX;
    }

    float getCharacterY() {
        return characterY;
    }

    boolean getMovingState() {
        return isMoving;
    }

    //Functions
    void moveRight(int delta){
        characterX = characterX + characterSpeed*delta ;
    }

    void draw(){
        characterImage.draw(characterX,characterY);
    }
}
