package snakesandladders;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Cell;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class SnakesAndLadders extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // here is a Group import to put all the different classes inside the scene as the scene cannot have more than one
        Group boardgroup = new Group();
        Dice dice = new Dice();
        Players act = new Players();
        // this button is to roll the dice and it calls on the Dice class
        Button roll = new Button();
        roll.setText("Roll Dice");
        roll.setLayoutX(560);
        roll.setLayoutY(500);
        
        roll.setOnAction((ActionEvent event) -> {
            roll.setDisable(true);
            GameEvent.restart.setVisible(false);
            GameEvent.new_game.setVisible(false);
            dice.roll(roll);
        });
        /*Here the GameEvent class is called as it has the needed functions to 
        initialize the needed parts such as the position inorder to start a new game 
        however the points are saved */
        GameEvent Game_event = new GameEvent();//ref
        /*Here the restart button is made and inside the setonaction the restart mathod
        name in the gameevent class is called to get the default values and keep the points
        the button visibility is set to false until the game has ended*/
        Button restart = new Button();
        restart.setText("Restart");
        restart.setLayoutX(150);
        restart.setLayoutY(550);
        GameEvent.restart = restart;
        GameEvent.restart.setVisible(false);
        GameEvent.restart.setOnAction((ActionEvent event) -> {
            Game_event.restart();
        });
        /*Here the New game button is made and inside the setonaction the new game mathod
        name in the gameevent class is called to get the default values and start the points from 0
        the button visibility is set to false until the game has ended*/
        Button new_game = new Button();
        new_game.setText("New game");
        new_game.setVisible(false);
        new_game.setLayoutX(20);
        new_game.setLayoutY(550);
        GameEvent.new_game = new_game;
        GameEvent.new_game.setVisible(false);
        GameEvent.new_game.setOnAction((ActionEvent event) -> {
            Game_event.new_game();
        });

        // this is creating the board as in the Board class the cellsize should be given as it can be adjustable
        Board board = new Board(100);
        // here it is calling on the group called boardgroup and adding all the necessary classes that must be put in scene
        boardgroup.getChildren().addAll(roll, board, dice, restart, new_game);
        // here is the scene and it is given the needed classes to display as well as the width and height
        Scene scene = new Scene(boardgroup, 700, 600);

        primaryStage.setTitle("Snakes and Ladders");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
