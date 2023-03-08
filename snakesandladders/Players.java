package snakesandladders;

import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Players {

    public static ArrayList<player> players = new ArrayList<>();
    public static int CurrentTurn = 1;
    public static boolean gameStopped = false;

    //set the player on the board
    public ImageView build_player(player p) {
        Image pic = p.getAvatar();
        ImageView _player = new ImageView();
        _player.setImage(pic);
        int y, x;
        x = (25 - p.place) / 5;
        y = x % 2 == 0 ? 4 - ((((5 - ((25 - p.place) / 5))) * 5) - p.place) : ((((5 - ((25 - p.place) / 5))) * 5) - p.place); //The Y represents the j(row) in the Cells[i][j] because the j is flipped in every even number of row in array so here it gives and equation to move on the even rows and a differrent move on the odd rows 
        _player.setFitHeight(35);
        _player.setFitWidth(35);
        _player.setX(Board.boardlayout[x][y].getLayoutX() + 40);
        /*here the players x and y is given and its added with numbers to shift inorder to not cover 
        the cell labeling and the Y number is multiplied by the player ID inorder to have each player placed in the same cell but apart from eachother*/
        _player.setY(Board.boardlayout[x][y].getLayoutY() + (20 * p.id));
        players.add(p);
        players.get(p.id - 1).setIV(_player);
        return _player;
    }

    //move the player on board from x1 -> x2
    public void move() {
        for (player p : players) {
            if (p.id == CurrentTurn) {
                p.has_move = true;
                if (p.has_move) {
                    p.has_move = false;
                    Moving m = new Moving();
                    m.player(p);
                    CurrentTurn = (CurrentTurn % 2) + 1;
                    return;
                }
            }
        }

    }
    /*this is the method to get the player to move to proper cell based on the dice rolled
    if the game hasnt stopped and goes cell by cell in order to give it a smoother look for the animation*/
    public void Animation_player(player p) {
        if (!Players.gameStopped) {
            int y, x;
            x = (25 - p.place) / 5;
            y = x % 2 == 0 ? 4 - ((((5 - ((25 - p.place) / 5))) * 5) - p.place) : ((((5 - ((25 - p.place) / 5))) * 5) - p.place);
            if (x <= 4 && y <= 4) {
                p.IV.setFitHeight(30);
                p.IV.setFitWidth(30);
                p.IV.setX(Board.boardlayout[x][y].getLayoutX() + 40);
                p.IV.setY(Board.boardlayout[x][y].getLayoutY() + (30 * p.id));
                players.get(p.id - 1).setIV(p.IV);
            }

        }
    }

}
