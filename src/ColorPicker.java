import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class ColorPicker extends Application {
    private static final String face = "\u263B";
    private int rColor = 0;
    private int gColor = 0;
    private int bColor = 0;

    @Override
    public void start(Stage stage) throws Exception {

        VBox vBox = new VBox();
        HBox hBox = new HBox();
        HBox hrBox = new HBox();
        HBox hgBox = new HBox();
        HBox hbBox = new HBox();
        VBox vrBox = new VBox();
        VBox vgBox = new VBox();
        VBox vbBox = new VBox();
        vBox.alignmentProperty().setValue(Pos.CENTER);
        hBox.alignmentProperty().setValue(Pos.CENTER);
        vrBox.alignmentProperty().setValue(Pos.CENTER);
        vgBox.alignmentProperty().setValue(Pos.CENTER);
        vbBox.alignmentProperty().setValue(Pos.CENTER);
        Label counter = new Label(face);
        counter.setFont(new Font("WingDings", 150));
        counter.setTextFill(Color.rgb(0, 0, 0));

        Label rLabel = new Label("Red: 0");
        Button rButtonUp = new Button("  +  ");
        rButtonUp.setOnAction(e -> {
            colorUp("red", rColor);
            rLabel.setText("Red: " + rColor);
            counter.setTextFill(Color.rgb(rColor, gColor, bColor));
        });
        Button rButtonDown = new Button("  -  ");
        rButtonDown.setOnAction(e -> {
            colorDown("red", rColor);
            rLabel.setText("Red: " + rColor);
            counter.setTextFill(Color.rgb(rColor, gColor, bColor));
        });
        hrBox.getChildren().addAll(rButtonDown, rButtonUp);
        vrBox.getChildren().addAll(rLabel, hrBox);

        Label gLabel = new Label("Green: 0");
        Button gButtonUp = new Button("  +  ");
        gButtonUp.setOnAction(e -> {
            colorUp("green", gColor);
            gLabel.setText("Green: " + gColor);
            counter.setTextFill(Color.rgb(rColor, gColor, bColor));
        });
        Button gButtonDown = new Button("  -  ");
        gButtonDown.setOnAction(e -> {
            colorDown("green", gColor);
            gLabel.setText("Green: " + gColor);
            counter.setTextFill(Color.rgb(rColor, gColor, bColor));
        });
        hgBox.getChildren().addAll(gButtonDown, gButtonUp);
        vgBox.getChildren().addAll(gLabel, hgBox);

        Label bLabel = new Label("Blue: 0");
        Button bButtonUp = new Button("  +  ");
        bButtonUp.setOnAction(e -> {
            colorUp("blue", bColor);
            bLabel.setText("Blue: " + bColor);
            counter.setTextFill(Color.rgb(rColor, gColor, bColor));
        });
        Button bButtonDown = new Button("  -  ");
        bButtonDown.setOnAction(e -> {
            colorDown("blue", bColor);
            bLabel.setText("Blue: " + bColor);
            counter.setTextFill(Color.rgb(rColor, gColor, bColor));
        });
        hbBox.getChildren().addAll(bButtonDown, bButtonUp);
        vbBox.getChildren().addAll(bLabel, hbBox);

        hBox.getChildren().addAll(vrBox, vgBox, vbBox);
        vBox.getChildren().addAll(counter, hBox);

        stage.setTitle("Color Picker");
        stage.setScene(new Scene(vBox));
        stage.show();

    }

    public void colorUp(String colorName, int NumColor){
        NumColor +=5;
        if(NumColor > 255){
            NumColor = 255;
        }
        if(colorName.equals("red")){
            rColor = NumColor;
        }
        if(colorName.equals("green")){
            gColor = NumColor;
        }
        if(colorName.equals("blue")){
            bColor = NumColor;
        }
    }

    public void colorDown(String colorName, int NumColor){
        NumColor -=5;
        if(NumColor < 0){
            NumColor = 0;
        }
        if(colorName.equals("red")){
            rColor = NumColor;
        }
        if(colorName.equals("green")){
            gColor = NumColor;
        }
        if(colorName.equals("blue")){
            bColor = NumColor;
        }
    }
}
