package no.joachim.duong.runnable;

import java.security.Key;
import java.util.Iterator;
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
import no.joachim.duong.entity.components.VelocityComp;
import no.joachim.duong.entity.systems.CollitionDetector;
import no.joachim.duong.entity.systems.MovementSys;
import no.joachim.duong.entity.units.Entity;
import no.joachim.duong.entity.units.PlayerCharacter;
import no.joachim.duong.utility.InputHandler;
import no.joachim.duong.utility.StaticConstants;

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
    private PlayerCharacter playerCharacter;
    private Node root;
    public GameLoop(Scene scene, PlayerCharacter playerCharacter) {
        this.scene = scene;
        currrentCanvas = getCanvasFromRoot(scene.getRoot());
        executorService = Executors.newSingleThreadExecutor();
        imageRender = new Renderer(currrentCanvas);
        this.playerCharacter = playerCharacter;

    }

    public void setLevel(int levelId) {
        LevelGenerator levelGenerator = new LevelGenerator();
        entityList = levelGenerator.getLevelFromId(levelId, playerCharacter);
        imageRender.setBackground(levelGenerator.getBackgroundName());
    }

    public void start() {
            isRunning = true;
            executorService.submit(this::gamePlay);
    }

    public void stop() {
        isRunning = false;
        executorService.shutdown();
    }

    public void gamePlay() {
        MovementSys movementSys = new MovementSys(entityList);
        collitionDetector = new CollitionDetector(entityList);
        while (isRunning) {
            System.out.println(entityList.size());
            long startTime = System.currentTimeMillis();

            // Update game state
            movementSys.update(1);
            inputUpdate();

            // Render the frame
            imageRender.render(entityList);

            removeOutOfBoundsBullets(entityList);

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

    private void inputUpdate() {
        Set<KeyCode> activeKeys = InputHandler.getActiveKeys();
        VelocityComp velocityComp = playerCharacter.getComponent(VelocityComp.class);
        /*
        if(isDiagonal(activeKeys)) {
            playerCharacter.setMovementSpeed(3);
        }
        else {
            playerCharacter.setMovementSpeed(4);
        }
        */
        velocityComp.setVy(0);
        velocityComp.setVx(0);
        if ((activeKeys.contains(KeyCode.W) && activeKeys.contains(KeyCode.S))
            || (!activeKeys.contains(KeyCode.W) && !activeKeys.contains(KeyCode.S)))
        {
            velocityComp.setVy(0);
        }
        else if (activeKeys.contains(KeyCode.W) && !collitionDetector.isCollidedWithWallTop(playerCharacter)) {
            velocityComp.setVy(-playerCharacter.getMovementSpeed());
        }
        else if (activeKeys.contains(KeyCode.S) && !collitionDetector.isCollidedWithWallBottom(playerCharacter)) {
            velocityComp.setVy(playerCharacter.getMovementSpeed());
        }
        if ((activeKeys.contains(KeyCode.D) && activeKeys.contains(KeyCode.A))
            || (!activeKeys.contains(KeyCode.D) && !activeKeys.contains(KeyCode.A)))
        {
            velocityComp.setVx(0);
        }
        else if (activeKeys.contains(KeyCode.D) && !collitionDetector.isCollidedWithWallRight(playerCharacter)) {
            velocityComp.setVx(playerCharacter.getMovementSpeed());
        }
        else if (activeKeys.contains(KeyCode.A) && !collitionDetector.isCollidedWithWallLeft(playerCharacter)) {
            velocityComp.setVx(-playerCharacter.getMovementSpeed());
        }

        if(activeKeys.contains(KeyCode.RIGHT) && playerCharacter.getCooldown() == 0) {
            entityList.add(playerCharacter.createBullet(1));
            playerCharacter.setCooldown(playerCharacter.getMaxCooldown());
        }
        else if(activeKeys.contains(KeyCode.DOWN) && playerCharacter.getCooldown() == 0) {
            entityList.add(playerCharacter.createBullet(2));
            playerCharacter.setCooldown(playerCharacter.getMaxCooldown());
        }
        else if(activeKeys.contains(KeyCode.LEFT) && playerCharacter.getCooldown() == 0) {
            entityList.add(playerCharacter.createBullet(3));
            playerCharacter.setCooldown(playerCharacter.getMaxCooldown());
        }
        else if(activeKeys.contains(KeyCode.UP) && playerCharacter.getCooldown() == 0) {
            entityList.add(playerCharacter.createBullet(4));
            playerCharacter.setCooldown(playerCharacter.getMaxCooldown());
        }
        else {
            playerCharacter.decreaseCooldown();
        }
    }

    private boolean isDiagonal(Set<KeyCode> activeKeys) {
        if(activeKeys.contains(KeyCode.A) && activeKeys.contains(KeyCode.S)) {
            return true;
        }
        else if(activeKeys.contains(KeyCode.A) && activeKeys.contains(KeyCode.W)) {
            return true;
        }
        else if(activeKeys.contains(KeyCode.D) && activeKeys.contains(KeyCode.W)) {
            return true;
        }
        else
            return activeKeys.contains(KeyCode.D) && activeKeys.contains(KeyCode.S);
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

    private void removeOutOfBoundsBullets(List<Entity> entityList) {
        entityList.removeIf(currentEntity -> currentEntity.getType() == StaticConstants.BULLET
            && collitionDetector.isCollidedWithWall(currentEntity));

    }

}
