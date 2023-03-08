
package snakesandladders;
 
import javafx.scene.image.Image;
// here is the Snake class with the constructor and setters and getters for each initialize field for the Actions class

public class Snake {
    int place;
    int downgrade;
    Image avatar;
    int x;
    int y;

    public Snake(int place, int downgrade, Image avatar, int x, int y) {
        this.place = place;
        this.downgrade = downgrade;
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

    public int getDowngrade() {
        return downgrade;
    }

    public void setDowngrade(int downgrade) {
        this.downgrade = downgrade;
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
