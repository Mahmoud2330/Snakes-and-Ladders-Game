/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakesandladders;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 *
 * @author mahmo
 */
public class Moving {

    public static ImageView winner;

    //the dice animation to move per sec for 5 sec
    public void dice(ImageView v) {
        new AnimationTimer() {
            long lastTick = 0;
            Dice d = new Dice();
            int sec;

            @Override
            public void handle(long now) {
                if (sec == 5) {
                    d.animation_roll(v);
                    Players p = new Players();
                    p.move();
                    d.st_bt();
                    this.stop();
                    return;
                }
                if (now - lastTick > 1000000000 / 5) {
                    d.animation_roll(v);
                    sec++;
                    lastTick = now;
                }
            }
        }.start();
    }

    boolean flag = false;

    //the dice animation to move per sec for 5 sec
    public void player(player p) {
        new AnimationTimer() {
            long lastTick = 0;
            Players d = new Players();
            int sec = 0;

            @Override
            public void handle(long now) {
                if (!Players.gameStopped) {
                    if (sec == 0) {
                        helper(p);
                        doMoving(p);
                    }
                    if ((p.place == Dice.diceValue)) {
                        this.stop();
                    }
                    if (now - lastTick > 1000000000 / 5) {
                        if (flag) {
                            p.place--;
                        } else {
                            p.place++;
                        }
                        if (p.place == 25) {
                            player_Win(winner);
                            this.stop();
                        }
                        sec++;
                        d.Animation_player(p);
                        lastTick = now;
                    }
                }

            }
        }.start();
    }

    public void helper(player p) {
        if (check_snake(p)) {
        } else if (check_ladder(p)) {
        } else if (check_availablity(p)) {
            /*here is so when the stretch feature which makes the player go backwards if he got 
            a dice roll higher than the needed roll to reach cell 25 if the player goes back and lands on a snake or ladder the function of the snake and ladder works*/
//            if (check_snake(p)) {
//            } else if (check_ladder(p)) {
//            }
        }
    }
    /* here is the method to see if the players place is greater than the dice number so that the movement could be adjusted in the player method making these values 
     into booleans is easier to refer to in the player method*/
    public void doMoving(player p) {
        if ((p.place != Dice.diceValue)) {
            if (p.place > Dice.diceValue) {
                flag = true;//negative
            } else {
                flag = false;//postive
            }
        }
    }
    /*here the game stops when the player reaches cell 25 when a 
    player wins the roll button is not visible so the movements could no longer occur
    and the point of the player in cell 25 is increased by 1 and next to the player number 
    and points it mentions who was the winner of the round and make the "you win" image visible other than that game still goes on the same*/
    public ImageView player_Win(ImageView w) {
        this.winner = w;
        for (player p : Players.players) {
            if (p.place == 25) {
                Players.gameStopped = true;
                Dice.roll.setVisible(false);
                p.point++;
                player.All_points.get(p.id - 1).setText("Player:" + p.id + " ,Points:" + p.point + "   winner");
                GameEvent GV = new GameEvent();
                GV.set_winner();
                w.setVisible(true);
                return w;
            }
        }
        w.setVisible(false);
        return w;
    }
// here it checks if the player is on the snake in order to move him to the bottom "downgrade"
    public boolean check_snake(player p) {
        for (Snake s : Actions.Snakes) {
            if ((p.place + Dice.diceValue) == s.place) {
                Dice.diceValue = s.downgrade;
                return true;
            }
        }
        return false;
    }
// here it checks if the player is on the ladder in order to move him to the top "upgrade"
    public boolean check_ladder(player p) {
        for (Ladder l : Actions.Ladders) {
            if ((p.place + Dice.diceValue) == l.upgrade) {
                Dice.diceValue = l.place;
                return true;
            }
        }
        return false;

    }
/*here is the stretch ablity it checks if the player is getting a value which will make him 
    land on anything furhter than cell 25 so it so it subtracts the cell the player will be in thats after 25
    by 25 and subtract that by the place the player is currently in to move back by those number of steps
    other than that the player move accordingly to the default movements*/
    public boolean check_availablity(player p) {
        if ((p.place + Dice.diceValue) > 25) {
            Dice.diceValue = (p.place - ((p.place + Dice.diceValue) - 25));
            return true;
        } else {
            Dice.diceValue = (p.place + Dice.diceValue);
        }
        return false;
    }

    void start(Stage stage) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
