package snakesandladders;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Board extends Pane {

    // intitializing the boardlayout feild
    public static Cells[][] boardlayout;

    public Board(double CellSize) {
        boardlayout = new Cells[5][5];
        /*here is a nested for loop inorder to create the 5 by 5 layout of the board with the 
        right positioning of X and Y by making the difference in distance between them which is CellSize*/
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                boardlayout[i][j] = new Cells();
                boardlayout[i][j].setLayoutX(j * CellSize);
                boardlayout[i][j].setLayoutY(i * CellSize);
                getChildren().add(boardlayout[i][j]);
                getChildren().add(create_lable(i, j, CellSize));
            }
        }
        /*here the actions and players class is called inorder to display the images needed for it*/
        Actions a = new Actions();
        set_snake(a);
        set_ladder(a);
        Players p = new Players();
        set_player(p);
        set_winner();
    }

    //set the snakes on the cell 
    //given the (int place, int downgrade, Image avatar, int x, int y) the downgrade being the end of the snake as it goes from up to down
    public void set_snake(Actions a) {
        getChildren().add(a.build_snake(new Snake(17, 7, new Image("snake.jpg"), 200, 45)));
        getChildren().add(a.build_snake(new Snake(20, 1, new Image("snake1.jpg"), 300, 45)));
        getChildren().add(a.build_snake(new Snake(8, 3, new Image("snake2.jpg"), 100, 45)));
    }

    //set the ladders on the cell
    //(int upgrade, int place, Image avatar, int x, int y) the upgrade being the top postion of the ladder where the player goes from down to up
    public void set_ladder(Actions a) {
        getChildren().add(a.build_ladder(new Ladder(15, 5, new Image("ladder.jpg"), 190, 45)));
        getChildren().add(a.build_ladder(new Ladder(12, 9, new Image("ladder.jpg"), 95, 45)));
        getChildren().add(a.build_ladder(new Ladder(23, 18, new Image("ladder.jpg"), 95, 45)));
    }

    /* set the player given (String name, int id, int place, int point, boolean has_move, Image avatar) the ID is to decide the players position on the cell
    and the players turn and the place is the intial location and the point is the initial score of each player has move is to identify the players turn 
    and the avatar is the character image*/
    public void set_player(Players p) {
        getChildren().add(p.build_player(new player("a", 1, 1, 0, false, new Image("cow.gif"), this)));
        getChildren().add(p.build_player(new player("b", 2, 1, 0, false, new Image("bull.gif"), this)));

    }
    /*here the image of "you won" is called to be displayed as soon as one of the players has reached the end
    however it isnt real gone it just isnt visible until the game has ended*/
    public void set_winner() {
        Image m = new Image("win.png");
        ImageView w = new ImageView();
        w.setImage(m);
        w.setVisible(false);
        w.setFitHeight(500);
        w.setFitWidth(500);
        w.setX(0);
        w.setY(0);
        Moving moving = new Moving();
        getChildren().add(moving.player_Win(w));
    }

    //set the cell labeling system which makes sure the labeling is appropriate to the array numbers inorder to adjust the proper player movments
    public Label create_lable(int i, int j, double CellSize) {
        Label label = new Label();
        label.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 15));
        label.setTextFill(Color.RED);
        label.setText("" + ((Math.abs(i - 4) + 1) + ((Math.abs(i - 4) + 1) % 2 == 0 ? Math.abs(j - 4) : j) + (Math.abs(i - 4) * 4)));
        label.setLayoutX(j * CellSize + 6);
        label.setLayoutY(i * CellSize);
        return label;
    }
}
