package snakesandladders;

import java.util.ArrayList;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
// here is the player class with the constructor and setters and getters for each initialize field

public class player {

    String name;
    int id;
    int place;
    int point;
    boolean has_move;
    Image avatar;
    ImageView IV;
    public static ArrayList<Label> All_points = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ImageView getIV() {
        return IV;
    }

    public void setIV(ImageView IV) {
        this.IV = IV;
    }

    public player(String name, int id, int place, int point, boolean has_move, Image avatar, Pane _pane) {
        this.name = name;
        this.id = id;
        this.place = place;
        this.point = point;
        this.has_move = has_move;
        this.avatar = avatar;
        /*the _pane is to add the image of the player on the top right to have the points labeled underneath*/ 
        add_point_system(id, avatar, point, _pane);
    }
    /*here is the method to display and add the points*/
    public void add_point_system(int id, Image _image, int point, Pane _pane) {
        ImageView _player = new ImageView();
        _player.setImage(_image);
        int y, x;
        x = 560;
        y = 20 + ((id - 1) * 150);
        _player.setFitHeight(60);
        _player.setFitWidth(60);
        _player.setX(x);
        _player.setY(y);

        _pane.getChildren().add(_player);
        _pane.getChildren().add(set_player_point(id, point, x, y));
    }
    /*here is the label that is displayed underneath the characters image on the top right
    to show the points were given to which player*/
    public Label set_player_point(int id, int point, int x, int y) {
        Label l = new Label();
        l.setText("Player:" + id + " ,Points:" + point);
        l.setLayoutX(x);
        l.setLayoutY(y + 100);
        All_points.add(l);
        return l;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public boolean isHas_move() {
        return has_move;
    }

    public void setHas_move(boolean has_move) {
        this.has_move = has_move;
    }

    public Image getAvatar() {
        return avatar;
    }

    public void setAvatar(Image avatar) {
        this.avatar = avatar;
    }
}
