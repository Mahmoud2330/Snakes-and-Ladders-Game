
package snakesandladders;

import javafx.scene.image.Image;
// here is the Ladder class with the constructor and setters and getters for each initialize field for the Actions class

public class Ladder {
    int place;
    int upgrade;
    Image avatar;
    int x;
    int y;

    public Ladder(int place, int upgrade, Image avatar, int x, int y) {
        this.place = place;
        this.upgrade = upgrade;
        this.avatar = avatar;
        this.x = x;
        this.y = y;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public int getUpgrade() {
        return upgrade;
    }

    public void setUpgrade(int upgrade) {
        this.upgrade = upgrade;
    }

    public Image getAvatar() {
        return avatar;
    }

    public void setAvatar(Image avatar) {
        this.avatar = avatar;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    
}
