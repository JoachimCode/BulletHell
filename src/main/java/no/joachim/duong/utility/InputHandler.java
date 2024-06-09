package no.joachim.duong.utility;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class InputHandler {
    private ExecutorService inputExecutor;
    private static final Set<KeyCode> activeKeys = new HashSet<>();

    public InputHandler(Scene scene, ExecutorService inputExecutor) {
        this.inputExecutor = inputExecutor;
        scene.setOnKeyPressed(this::handleKeyPress);
        scene.setOnKeyReleased(this::handleKeyRelease);
    }

    private void handleKeyPress(KeyEvent event) {
        inputExecutor.submit(() -> {
            KeyCode keyCode = event.getCode();
            synchronized (activeKeys) {
                activeKeys.add(keyCode);
            }
        });
    }

    private void handleKeyRelease(KeyEvent event) {
        inputExecutor.submit(() -> {
            KeyCode keyCode = event.getCode();
            synchronized (activeKeys) {
                activeKeys.remove(keyCode);
            }
        });
    }

    public static Set<KeyCode> getActiveKeys() {
        synchronized (activeKeys) {
            return new HashSet<KeyCode>(activeKeys);
        }
    }

}