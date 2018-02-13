import org.newdawn.slick.*;

//Classes

public class Character {

    //Property
    private Image characterImage;
    private float characterX, characterY, jumpHeight;
    private int characterSpeed, maxJumpHeight;
    private boolean isMaxHeightReached;


    //Init
    Character(Image characterImage, float startPosX, float startPosY) {
        this.characterImage = characterImage;
        characterX = startPosX;
        characterY = startPosY;

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
}
