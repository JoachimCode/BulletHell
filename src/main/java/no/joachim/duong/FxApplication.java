package no.joachim.duong;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.application.Application;
import no.joachim.duong.entity.components.PositionComp;
import no.joachim.duong.entity.components.VelocityComp;
import no.joachim.duong.entity.units.PlayerCharacter;
import no.joachim.duong.runnable.GameLoop;
import no.joachim.duong.scenes.SceneHandler;
import no.joachim.duong.utility.InputHandler;
import no.joachim.duong.utility.StaticConstants;

public class FxApplication extends Application{
    PlayerCharacter playerCharacter;
    private ExecutorService inputExecutor;
    private boolean isRunning = true;
    public static final AtomicInteger nextId = new AtomicInteger(0);
    @Override
    public void start(Stage stage) throws IOException {
        startGameplay(stage);
    }

    @Override
    public void stop() {
        isRunning = false;
        inputExecutor.shutdownNow();
    }
    /**
     * Starts the fx application, this should always be run first.
     * @param args the start arguments passed in when launching the java application
     */
    public void startFX(String[] args) {
        launch(args);
    }
    private void startGameplay(Stage stage) {
        SceneHandler sceneHandler = new SceneHandler();
        Scene mainScene = sceneHandler.getGameplayScene();
        inputExecutor = Executors.newSingleThreadExecutor();
        InputHandler inputHandler = new InputHandler(mainScene, inputExecutor);
        createPlayerCharacter();
        GameLoop gameLoop = new GameLoop(mainScene, playerCharacter);
        gameLoop.setLevel(1);
        gameLoop.start();


        stage.setTitle("BulletHell");
        stage.setScene(mainScene);
        stage.show();
    }

    private void createPlayerCharacter() {
        playerCharacter = new PlayerCharacter(nextId.getAndIncrement(), 40, 80);
        playerCharacter.addComponent(new PositionComp(0, 0));
        playerCharacter.addComponent(new VelocityComp(0, 0));
        playerCharacter.setSprite("PlayerSprite.png");
    }
}
