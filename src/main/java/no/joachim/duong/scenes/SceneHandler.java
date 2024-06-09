package no.joachim.duong.scenes;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;

public class SceneHandler {
    private Canvas currentCanvas;
    public Scene getGameplayScene() {
        Canvas canvas = new Canvas(600, 600);
        StackPane root = new StackPane();
        root.getChildren().add(canvas);
        return new Scene(root, 600, 600);
    }

    public Scene getDialogueScene() {
        GridPane rootPane = new GridPane();
        for (int i = 0; i < 3; i++) {
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setPercentWidth(33.33);
            rootPane.getColumnConstraints().add(colConst);

            RowConstraints rowConst = new RowConstraints();
            rowConst.setPercentHeight(33.33);
            rootPane.getRowConstraints().add(rowConst);
        }
        Canvas canvas = new Canvas(600, 600);
        currentCanvas = canvas;
        rootPane.add(canvas, 1, 1);
        return new Scene(rootPane, 800, 800);
    }
}
