package Toys4U.View;

import Toys4U.GameOfLifeWorld.RandomHabitatGenerator;
import Toys4U.GameOfLifeWorld.World;
import Toys4U.Particles.ParticleColor;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Charles Korthout
 */
public class GameOfLife extends Application {

    // World size for testing
    private static int WORLD_ROW = 100;
    private static int WORLD_COL = 100;

    // Speed of simulation
    private long SPEED_IN_MIL = 1;
    // Play/pause boolean (true = play, false = pause)
    private boolean PLAY_MODE = false;
    private List<World> worlds = new ArrayList();
    private World lastworld;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // initMap
        setupDebug();

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

        // Init information pane
        TitledPane titledPane = new TitledPane();
        titledPane.setText("test pane");

        // Init tickname box
        TextField tickBox = new TextField();
        tickBox.setDisable(true);
        tickBox.setPrefWidth(50);
        tickBox.setText("1");

        // Init map canvas
        Canvas mapCanvas = new Canvas(506, 506);
        GraphicsContext mapCanvasContent = mapCanvas.getGraphicsContext2D();

        // Init information canvas
        Canvas informationMap = new Canvas(200, 200);
        GraphicsContext informationMapContent = informationMap.getGraphicsContext2D();

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
        generateMap(mapCanvasContent);
        mapCanvas.setLayoutX(0);
        mapCanvas.setLayoutY(0);

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

        // Draw and position information map
        drawInformationMap(informationMapContent);
        informationMap.setLayoutX(520);
        informationMap.setLayoutY(5);

        // Adding all widgets to window
        root.getChildren().add(playPauseButton);
        root.getChildren().add(mapCanvas);
        root.getChildren().add(informationMap);
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
        ParticleColor[] map = lastworld.getHabitatMap(0);

        for (int objectRowCount = 0; objectRowCount < WORLD_ROW; objectRowCount++) {
            for (int objectColCount = 0; objectColCount < WORLD_COL; objectColCount++) {
                int objectId = ((objectRowCount * WORLD_ROW) + objectColCount);
                switch (map[objectId]) {
                    case Blue : gc.setFill(Color.BLUE); break;
                    case Black : gc.setFill(Color.BLACK); break;
                    case Brown : gc.setFill(Color.BROWN); break;
                    case Yellow : gc.setFill(Color.YELLOW); break;
                    case Green : gc.setFill(Color.GREEN); break;
                    case Red : gc.setFill(Color.RED); break;
                    default: gc.setFill(Color.WHITE); break; // Land
                }
                gc.fillRoundRect((objectColCount * 5) + 3, (objectRowCount * 5) + 3, 5, 5, 0, 0);
            }
        }
    }

    public void drawInformationMap(GraphicsContext gc) {
        gc.setStroke(Color.BLACK);
        gc.strokeText("Carnivore", 15, 15);
        gc.strokeText("Omnivore", 15, 30);
        gc.strokeText("Herbivore", 15, 45);
        gc.strokeText("Plant", 15, 60);
        gc.strokeText("Water", 15, 75);
        gc.strokeText("Obstacle", 15, 90);
        gc.strokeText("Land", 15, 105);

        gc.setFill(Color.RED);
        gc.fillRoundRect(1, 6, 10, 10, 0, 0);

        gc.setFill(Color.YELLOW);
        gc.fillRoundRect(1, 20, 10, 10, 0, 0);

        gc.setFill(Color.BROWN);
        gc.fillRoundRect(1, 35, 10, 10, 0, 0);

        gc.setFill(Color.GREEN);
        gc.fillRoundRect(1, 50, 10, 10, 0, 0);

        gc.setFill(Color.BLUE);
        gc.fillRoundRect(1, 64, 10, 10, 0, 0);

        gc.setFill(Color.BLACK);
        gc.fillRoundRect(1, 78, 10, 10, 0, 0);

        gc.setFill(Color.WHITE);
        gc.fillRoundRect(1, 94, 10, 10, 0, 0);
    }

    public void setupDebug(){
        RandomHabitatGenerator generator = new RandomHabitatGenerator(0,0, this.WORLD_ROW, this.WORLD_COL);
        this.lastworld = new World(worlds.size(), this.WORLD_ROW, this.WORLD_COL,generator );
        lastworld.add(); // add a habitat to this world
        this.worlds.add(lastworld); // add this wolrd to the game
    }
}
