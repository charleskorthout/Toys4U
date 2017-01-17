package Toys4U.View;

import Toys4U.GameOfLifeWorld.ProportionalHabitatGenerator;
import Toys4U.GameOfLifeWorld.RandomHabitatGenerator;
import Toys4U.GameOfLifeWorld.World;
import Toys4U.Particles.*;
import javafx.application.Application;
import javafx.application.Platform;
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

import java.util.*;

/**
 *
 * @author charl
 */
public class GameOfLife extends Application implements Observer {

    // World size for testing
    private static int WORLD_ROW = 100;
    private static int WORLD_COL = 100;
    // Test voor observer
    private static Canvas mapCanvas = new Canvas(506, 506);
    private static GraphicsContext mapCanvasContent = mapCanvas.getGraphicsContext2D();
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

        // Init play/pause button
        Button playPauseButton = new Button();
        playPauseButton.setText("Play");
        playPauseButton.setPrefWidth(60);

        // Init speedSlider
        Slider speedSlider = new Slider();
        speedSlider.setMin(1);
        speedSlider.setMax(10000);
        speedSlider.setValue(1000);
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


        // init sizeRow input
        Label inputRowsLabel = new Label();
        inputRowsLabel.setText("Grid:");
        TextField inputRows = new TextField();
        inputRows.setPrefWidth(45);
        inputRows.setDisable(true);
        inputRows.setText("100");

        // Init sizeCol input
        Label inputColmLabel = new Label();
        inputColmLabel.setText("by:");
        TextField inputColm = new TextField();
        inputColm.setDisable(true);
        inputColm.setPrefWidth(45);
        inputColm.setText("100");

        // Init mapGenerator values
        Label omnivoreLabel = new Label();
        Label herbivoreLabel = new Label();
        Label carnivoreLabel = new Label();
        Label elementsLabel = new Label();
        Label obstaclesLabel = new Label();
        Label plantsLabel = new Label();
        Label waterLabel = new Label();
        omnivoreLabel.setText("Omnivore:");
        herbivoreLabel.setText("Herbivore:");
        carnivoreLabel.setText("Carnivore:");
        elementsLabel.setText("Elements:");
        obstaclesLabel.setText("Obstacles:");
        plantsLabel.setText("Plants:");
        waterLabel.setText("Water:");
        TextField omnivoreInput = new TextField();
        TextField herbivoreInput = new TextField();
        TextField carnivoreInput = new TextField();
        TextField elementInput = new TextField();
        TextField obstacleInput = new TextField();
        TextField plantInput = new TextField();
        TextField waterInput = new TextField();
        omnivoreInput.setPrefWidth(45);
        herbivoreInput.setPrefWidth(45);
        carnivoreInput.setPrefWidth(45);
        elementInput.setPrefWidth(45);
        obstacleInput.setPrefWidth(45);
        plantInput.setPrefWidth(45);
        waterInput.setPrefWidth(45);


        // Init information canvas
        Canvas informationMap = new Canvas(200, 200);
        GraphicsContext informationMapContent = informationMap.getGraphicsContext2D();

        playPauseButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                // Toggle for play/pause simulation
                if (PLAY_MODE) {
                    PLAY_MODE = false;
                    playPauseButton.setText("Play");
                    lastworld.pauseHabitat(0);


                } else {
                    if (checkInputValidation(omnivoreInput.getText(),
                            herbivoreInput.getText(),
                            carnivoreInput.getText(),
                            obstacleInput.getText(),
                            plantInput.getText(),
                            waterInput.getText())) {
                        if (lastworld == null) {
                            startNewWorld(inputRows.getText(), inputColm.getText(), herbivoreInput.getText(), carnivoreInput.getText(), omnivoreInput.getText(), obstacleInput.getText(), plantInput.getText(), waterInput.getText());
                            omnivoreInput.setDisable(true);
                            herbivoreInput.setDisable(true);
                            carnivoreInput.setDisable(true);
                            obstacleInput.setDisable(true);
                            plantInput.setDisable(true);
                            waterInput.setDisable(true);
                        }
                        lastworld.startHabitat(0, (int) speedSlider.getValue());

                        PLAY_MODE = true;
                        playPauseButton.setText("Pause");

                    } else {
                        System.out.println("[!] ERROR input not correct.");
                    }
                }
            }
        });

        speedSlider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                                Number old_val, Number new_val) {
                // Setting speed from speedslider
                tickBox.setText(Long.toString(new_val.intValue()));
                if (PLAY_MODE == true)
                    lastworld.setThreadInterval(0, (int) speedSlider.getValue());

            }
        });


        // Position canvas for drawing map and fill it with test grid
        //generateMap(mapCanvasContent);
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

        // Position setup
        inputRowsLabel.setLayoutX(5);
        inputRowsLabel.setLayoutY(550);
        inputRows.setLayoutX(45);
        inputRows.setLayoutY(545);
        inputColmLabel.setLayoutX(95);
        inputColmLabel.setLayoutY(550);
        inputColm.setLayoutX(120);
        inputColm.setLayoutY(545);

        omnivoreLabel.setLayoutX(5);
        omnivoreLabel.setLayoutY(580);
        herbivoreLabel.setLayoutX(5);
        herbivoreLabel.setLayoutY(610);
        carnivoreLabel.setLayoutX(5);
        carnivoreLabel.setLayoutY(640);

        omnivoreInput.setLayoutX(80);
        omnivoreInput.setLayoutY(575);
        herbivoreInput.setLayoutX(80);
        herbivoreInput.setLayoutY(605);
        carnivoreInput.setLayoutX(80);
        carnivoreInput.setLayoutY(635);

        obstaclesLabel.setLayoutX(150);
        obstaclesLabel.setLayoutY(580);
        obstacleInput.setLayoutX(225);
        obstacleInput.setLayoutY(575);

        plantsLabel.setLayoutX(150);
        plantsLabel.setLayoutY(610);
        plantInput.setLayoutX(225);
        plantInput.setLayoutY(605);

        waterLabel.setLayoutX(150);
        waterLabel.setLayoutY(640);
        waterInput.setLayoutX(225);
        waterInput.setLayoutY(635);

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
        root.getChildren().add(inputRowsLabel);
        root.getChildren().add(inputRows);
        root.getChildren().add(inputColmLabel);
        root.getChildren().add(inputColm);
        root.getChildren().add(omnivoreLabel);
        root.getChildren().add(herbivoreLabel);
        root.getChildren().add(carnivoreLabel);
        root.getChildren().add(omnivoreInput);
        root.getChildren().add(herbivoreInput);
        root.getChildren().add(carnivoreInput);
        root.getChildren().add(obstaclesLabel);
        root.getChildren().add(plantsLabel);
        root.getChildren().add(obstacleInput);
        root.getChildren().add(plantInput);
        root.getChildren().add(waterLabel);
        root.getChildren().add(waterInput);

        // Building scene from pane
        Scene scene = new Scene(root, 800, 800);
        primaryStage.setTitle("Toys4U Life simulator");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void generateMap() {
        // Border draw
        this.mapCanvasContent.setLineWidth(3);
        this.mapCanvasContent.setFill(Color.BLACK);
        // border down
        this.mapCanvasContent.strokeLine(1, 505, 505, 505);
        // border up
        this.mapCanvasContent.strokeLine(1, 1, 505, 1);
        // border right
        this.mapCanvasContent.strokeLine(505, 1, 505, 505);
        // border right
        this.mapCanvasContent.strokeLine(1, 1, 1, 505);

        // Tijdelijke raster demo voor weergaven wereld.
        // TODO omzetten naar 2D array
        ParticleColor[] map = lastworld.getHabitatMap(0);

        for (int objectRowCount = 0; objectRowCount < WORLD_ROW; objectRowCount++) {
            for (int objectColCount = 0; objectColCount < WORLD_COL; objectColCount++) {
                int objectId = ((objectRowCount * WORLD_ROW) + objectColCount);
                switch (map[objectId]) {
                    case Blue:
                        this.mapCanvasContent.setFill(Color.BLUE);
                        break;
                    case Black:
                        this.mapCanvasContent.setFill(Color.BLACK);
                        break;
                    case Brown:
                        this.mapCanvasContent.setFill(Color.BROWN);
                        break;
                    case Yellow:
                        this.mapCanvasContent.setFill(Color.YELLOW);
                        break;
                    case Green:
                        this.mapCanvasContent.setFill(Color.GREEN);
                        break;
                    case Red:
                        this.mapCanvasContent.setFill(Color.RED);
                        break;
                    default:
                        this.mapCanvasContent.setFill(Color.WHITE);
                        break; // Land
                }
                this.mapCanvasContent.fillRoundRect((objectColCount * 5) + 3, (objectRowCount * 5) + 3, 5, 5, 0, 0);
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

    public void startNewWorld(String rows, String columns, String herbivore, String carnivore, String omnivore, String obstacles, String plants, String water) {
        HashMap<String, Double> ratio = new HashMap<>();
        ratio.put(new String("Plant"), (double) (Integer.parseInt(plants) / 100));
        ratio.put(new String("OmnivoreImpl"), (double) Integer.parseInt(omnivore) / 100);
        ratio.put(new String("CarnivoreImpl"), (double) Integer.parseInt(carnivore) / 100);
        ratio.put(new String("HerbivoreImpl"), (double) Integer.parseInt(herbivore) / 100);
        ratio.put(new String("Obstacle"), (double) Integer.parseInt(obstacles) / 100);
        ratio.put(new String("Water"), (double) Integer.parseInt(water) / 100);


        double totalFilled = 0;
        for (Map.Entry<String, Double> entry : ratio.entrySet()) {
            totalFilled += entry.getValue();
        }

        ratio.put(new String("Land"), (double) 1 - totalFilled);

        ProportionalHabitatGenerator generator = new ProportionalHabitatGenerator(ratio, 0, 0, Integer.parseInt(rows), Integer.parseInt(columns), new Random());
        //ProportionalHabitatGenerator generator = new ProportionalHabitatGenerator()
        this.lastworld = new World(worlds.size(), this.WORLD_ROW, this.WORLD_COL,generator );
        lastworld.add(this); // add a habitat to this world
        this.worlds.add(lastworld); // add world to the game
    }

    @Override
    public void update(Observable o, Object arg) {
        new Thread(() -> Platform.runLater(() -> this.generateMap())).start();
    }

    public boolean checkInputValidation(String omnivore, String herbivore, String carnivore, String obstacle, String plant, String water) {
        boolean noError = true;
        double totalPrc = 0;
        try {
            totalPrc += Integer.parseInt(omnivore);
            totalPrc += Integer.parseInt(herbivore);
            totalPrc += Integer.parseInt(carnivore);
            totalPrc += Integer.parseInt(obstacle);
            totalPrc += Integer.parseInt(plant);
            totalPrc += Integer.parseInt(water);
        } catch (NumberFormatException e) {
            noError = false;
        }

        if (totalPrc > 100) {
            noError = false;
        }

        return noError;
    }
}
