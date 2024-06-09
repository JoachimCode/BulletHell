package no.joachim.duong.runnable;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.random.RandomGenerator.StreamableGenerator;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import no.joachim.duong.entity.systems.CollitionDetector;
import no.joachim.duong.entity.systems.MovementSys;
import no.joachim.duong.entity.units.Entity;
import no.joachim.duong.utility.InputHandler;

public class GameLoop {
    private Canvas currrentCanvas;
    private List<Entity> entityList;
    private MovementSys movementSys;
    private CollitionDetector collitionDetector;
    private InputHandler inputHandler;
    private Scene scene;
    private int levelId;
    private boolean isRunning;
    private Renderer imageRender;

    private ExecutorService executorService;
    public GameLoop(Scene scene, int levelId) {
        this.scene = scene;
        currrentCanvas = getCanvasFromRoot(scene.getRoot());
        this.levelId = levelId;
    }

    public GameLoop(Scene scene) {
        this.scene = scene;
        currrentCanvas = getCanvasFromRoot(scene.getRoot());
        executorService = Executors.newSingleThreadExecutor();
        imageRender = new Renderer(currrentCanvas);
    }

    public void start() {
            isRunning = true;
            executorService.submit(this::gamePlay);
    }

    public void gamePlay() {
        while (isRunning) {
            long startTime = System.currentTimeMillis();

            // Update game state
            update();

            // Render the frame
            imageRender.render();

            // Frame rate control
            long endTime = System.currentTimeMillis();
            long frameDuration = endTime - startTime;
            long sleepTime = Math.max(16 - frameDuration, 0); // Aim for ~60 FPS
            try {
                TimeUnit.MILLISECONDS.sleep(sleepTime);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

    }

    private void update() {
        Set<KeyCode> activeKeys = InputHandler.getActiveKeys();
        if (activeKeys.contains(KeyCode.W)) {

        }
        if (activeKeys.contains(KeyCode.S)) {
            // Move player down
        }
        if (activeKeys.contains(KeyCode.A)) {
            imageRender.moveLeft();
        }
        if (activeKeys.contains(KeyCode.D)) {
            imageRender.moveRight();
        }
    }

    private Canvas getCanvasFromRoot(Parent root) {
        for (Node node : root.getChildrenUnmodifiable()) {
            if (node instanceof Canvas) {
                return (Canvas) node;
            } else if (node instanceof Parent) {
                Canvas canvas = getCanvasFromRoot((Parent) node);
                if (canvas != null) {
                    return canvas;
                }
            }
        }
        return null;
    }

}
