package no.joachim.duong.runnable;

import javafx.application.Platform;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Renderer {
    private Canvas canvas;
    private GraphicsContext gc;
    int currentX = 75;
    public Renderer(Canvas canvas) {
        this.canvas = canvas;
        gc = canvas.getGraphicsContext2D();

        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gc.setFill(Color.BLUE);
        gc.fillRect(75, 75, 250, 250);
    }

    public void render() {
        Platform.runLater(() -> {

        });
    }

    public void moveLeft() {
        Platform.runLater(() -> {
            gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            gc.setFill(Color.BLUE);
            gc.fillRect(currentX - 5, 75, 250, 250);
            currentX = currentX - 5;
        });
    }

    public void moveRight() {
        Platform.runLater(() -> {
            gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            gc.setFill(Color.BLUE);
            gc.fillRect(currentX + 5, 75, 250, 250);
            currentX = currentX + 5;
        });
    }
}
