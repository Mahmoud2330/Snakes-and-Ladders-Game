package snakesandladders;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Actions {
    /* a resizable array is created for the snakes and ladders inorder to add new elements of 
    them whenever it is needed to make the code not structured on a standard number of 
    snakes and ladders but it could be adjusted to make it easier to add and remove them 
    whenever which makes it more effecient and get the elements from the index of the array */
    public static ArrayList<Snake> Snakes = new ArrayList<>();
    public static ArrayList<Ladder> Ladders = new ArrayList<>();
    /*here the x and y and the height and width of the snake is given in the form of an equation so that simply when 
    given the cell number it starts and ends in*/
    public ImageView build_snake(Snake s) {

        Image pic = s.getAvatar();
        ImageView snakeImage = new ImageView();
        snakeImage.setImage(pic);
        int y, x;
        x = (25 - s.place) / 5;
        y = x % 2 == 0 ? 4 - ((((5 - ((25 - s.place) / 5))) * 5) - s.place) : ((((5 - ((25 - s.place) / 5))) * 5) - s.place);
        snakeImage.setFitHeight(s.x);
        snakeImage.setFitWidth(s.y);
        snakeImage.setX(Board.boardlayout[x][y].getLayoutX() + 30);
        snakeImage.setY(Board.boardlayout[x][y].getLayoutY() + 60);
        setSnakes(s);
        return snakeImage;
    }
/*here the x and y and the height and width of the ladder is given in the form of an equation so that simply when 
    given the cell number it starts and ends in*/
    public ImageView build_ladder(Ladder l) {
        Image pic = l.getAvatar();
        ImageView LadderImage = new ImageView();
        LadderImage.setImage(pic);
        int y, x;
        x = (25 - l.place) / 5;
        y = x % 2 == 0 ? 4 - ((((5 - ((25 - l.place) / 5))) * 5) - l.place) : ((((5 - ((25 - l.place) / 5))) * 5) - l.place);
        LadderImage.setFitHeight(l.x);
        LadderImage.setFitWidth(l.y);
        LadderImage.setX(Board.boardlayout[x][y].getLayoutX() + 30);
        LadderImage.setY(Board.boardlayout[x][y].getLayoutY() + 60);
        setLadders(l);
        return LadderImage;
    }
 /* here is the setter for both the snake and ladder so that it can be set in the board class*/ 
    public void setSnakes(Snake s) {
        Snakes.add(s);
    }

    public void setLadders(Ladder l) {
        Ladders.add(l);
    }
}
