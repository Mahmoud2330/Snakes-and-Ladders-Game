package snakesandladders;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import static snakesandladders.Players.CurrentTurn;
import static snakesandladders.Players.players;

public class GameEvent {

    public static Button restart;
    public static Button new_game;
//keeping the points and starting the game from the beginning
    public void restart() {
        for (player p : players) {
            p.place = 1;
            p.has_move = false;
            player.All_points.get(p.id - 1).setText("User ID:" + p.id + " ,Points:" + p.point);
            Players.gameStopped = false;
            Dice.roll.setVisible(true);
            Moving.winner.setVisible(false);
            Players m = new Players();
            m.Animation_player(p);
            Dice.diceValue = 0;
            CurrentTurn = 1;
        }
    }
//removing the points and starting the game from the beginning
    public void new_game() {
        for (player p : players) {
            p.point = 0;
            p.place = 1;
            player.All_points.get(p.id - 1).setText("User ID:" + p.id + " ,Points:" + p.point);
            p.has_move = false;
            Players.gameStopped = false;
            Dice.roll.setVisible(true);
            Moving.winner.setVisible(false);
            Players m = new Players();
            m.Animation_player(p);
            Dice.diceValue = 0;
            CurrentTurn = 1;
        }
    }
// this is so when the winner is found in the player class in the player_win method the new game and restart button are visible at the end of the game when the winner has been identified
    public void set_winner() {
        GameEvent.restart.setVisible(true);
        GameEvent.new_game.setVisible(true);
    }
}
