package snakesandladders;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class Cells extends Rectangle {

    public Label label;

    public void setLable(Label lable) {
        this.label = label;
    }

    // here is the cell specifications that will allow the rectangles to print out and rather than creating new Rectangle this file extends Rectangle
    public Cells() {
        setWidth(100);
        setHeight(100);
        setFill(Color.BEIGE);
        setStroke(Color.BLUE);
        setStrokeWidth(3.0);

    }

}
