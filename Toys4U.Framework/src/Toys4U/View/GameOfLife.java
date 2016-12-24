package Toys4U.View;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author charl
 */
public class GameOfLife extends Application {

    // World size for testing
    private static int WORLD_ROW = 100;
    private static int WORLD_COL = 100;

    // Speed of simulation
    private long SPEED_IN_MIL = 1;
    // Play/pause boolean (true = play, false = pause)
    private boolean PLAY_MODE = false;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Init play/pause button
        Button playPauseButton = new Button();
        playPauseButton.setText("Pause");
        playPauseButton.setPrefWidth(60);

        // Init speedSlider
        Slider speedSlider = new Slider();
        speedSlider.setMin(1);
        speedSlider.setMax(1000);
        speedSlider.setValue(SPEED_IN_MIL);
        speedSlider.setPrefWidth(330);

        // Init tick label
        Label tickBoxLabel = new Label();
        tickBoxLabel.setText("Ticks:");

        // Init root pane for putting widgets on it
        Pane root = new Pane();

        // Init tickname box
        TextField tickBox = new TextField();
        tickBox.setDisable(true);
        tickBox.setPrefWidth(50);
        tickBox.setText("1");

        playPauseButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                // Toggle for play/pause simulation
                if (PLAY_MODE) {
                    PLAY_MODE = false;
                    playPauseButton.setText("Pause");
                } else {
                    PLAY_MODE = true;
                    playPauseButton.setText("Play");
                }
            }
        });

        speedSlider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                                Number old_val, Number new_val) {
                // Setting speed from speedslider
                SPEED_IN_MIL = new_val.intValue();
                tickBox.setText(Long.toString(SPEED_IN_MIL));
            }
        });


        // Position canvas for drawing map and fill it with test grid
        Canvas canvas = new Canvas(506, 506);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        generateMap(gc);
        canvas.setLayoutX(0);
        canvas.setLayoutY(0);

        // Position play/pause button for play/pause simulation
        playPauseButton.setLayoutX(5);
        playPauseButton.setLayoutY(515);

        // Position slider for changing speed ticks in simulation
        speedSlider.setLayoutX(70);
        speedSlider.setLayoutY(520);

        // Position all labels
        tickBoxLabel.setLayoutX(410);
        tickBoxLabel.setLayoutY(520);

        // Position tickbox
        tickBox.setLayoutX(450);
        tickBox.setLayoutY(515);

        // Adding all widgets to window
        root.getChildren().add(playPauseButton);
        root.getChildren().add(canvas);
        root.getChildren().add(speedSlider);
        root.getChildren().add(tickBoxLabel);
        root.getChildren().add(tickBox);

        // Building scene from pane
        Scene scene = new Scene(root, 800, 800);
        primaryStage.setTitle("Toys4U Life simulator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param gc
     * Drawing line by line for building up canvas for showing simulation.
     */
    public void generateMap(GraphicsContext gc) {
        // Border draw
        gc.setLineWidth(3);
        gc.setFill(Color.BLACK);
        // border down
        gc.strokeLine(1, 505, 505, 505);
        // border up
        gc.strokeLine(1, 1, 505, 1);
        // border right
        gc.strokeLine(505, 1, 505, 505);
        // border right
        gc.strokeLine(1, 1, 1, 505);

        // Tijdelijke raster demo voor weergaven wereld.
        // TODO omzetten naar 2D array
        for (int objectRowCount = 0; objectRowCount < WORLD_ROW; objectRowCount++) {
            for (int objectColCount = 0; objectColCount < WORLD_COL; objectColCount++) {
                if (objectColCount % 2 == 0) {
                    gc.setFill((objectRowCount % 2 == 1) ? Color.RED : Color.WHITE);
                } else {
                    gc.setFill((objectRowCount % 2 == 1) ? Color.WHITE : Color.RED);
                }
                gc.fillRoundRect((objectColCount * 5) + 3, (objectRowCount * 5) + 3, 5, 5, 0, 0);
            }
        }
    }
}
