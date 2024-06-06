package no.joachim.duong;

import java.io.IOException;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.application.Application;

public class FxApplication extends Application{
    @Override
    public void start(Stage stage) throws IOException {
        Text helloText = new Text("Hello world");
        FlowPane rootpane = new FlowPane();
        rootpane.getChildren().addAll(helloText);

        Scene mainScene = new Scene(rootpane, 800, 800);
        stage.setTitle("BulletHell");
        stage.setScene(mainScene);
        stage.setFullScreen(true);
        stage.show();



    }
    /**
     * Starts the fx application, this should always be run first.
     * @param args the start arguments passed in when launching the java application
     */
    public void startFX(String[] args) {
        launch(args);
    }
}
