package snakesandladders;

import java.util.Random;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Dice extends ImageView {

    public static int diceValue = 0;
    public static Button roll;
    /*here the dice nolonger moves or is affected as the game has stopped 
    other than that it works and gives the player the number of moves he has to do*/
    public int roll(Button roll) {
        if (!Players.gameStopped) {
            String path = "dice1.gif";
            Moving m = new Moving();
            m.dice(this);
            this.roll = roll;

        }
        return 0;
    }
    /*here the rolling the dice button is dice is given 2 methods one in st_bt and in st_bt_v
    in st_bt the button is not disabled and in st_bt_v the button is disabled and cannot be used
    this will be used in the moving class*/
    public void st_bt() {
        roll.setDisable(false);
    }

    public void st_bt_v() {
        roll.setDisable(true);
    }

    public void animation_roll(ImageView v) {
        // the number within the brackets  in line 26 is setting the range between 0 - 5
        // i didnt write 7 because the range would be between 0 - 6 but we will add 1 so that it doesnt give a value of 0 because the dice doesnt have the value 0
        // Here we add 1 in order to make the new range between 1 - 6 because that is the proper range of a dice

        Random Number = new Random();
        String path = "";
        diceValue = (Number.nextInt(6) + 1);
        /*here the diceValue is added to decrease the number of lines and if loops which would be ineffcient 
        so rather it just gives the number and the images are numbered in the same way so it views the image the same way */
        path = "dice" + diceValue + ".gif";
        Image dice1 = new Image(path);
        v.setImage(dice1);
        v.setFitHeight(50);
        v.setFitWidth(50);
        v.setX(570);
        v.setY(420);

    }
}
