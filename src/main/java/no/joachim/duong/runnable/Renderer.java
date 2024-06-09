package no.joachim.duong.runnable;

import java.util.List;
import javafx.application.Platform;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import no.joachim.duong.entity.components.PositionComp;
import no.joachim.duong.entity.units.Entity;
import no.joachim.duong.utility.ImageLoader;

public class Renderer {
    private Canvas canvas;
    private GraphicsContext gc;
    private Image background;
    int currentX = 75;
    public Renderer(Canvas canvas) {
        this.canvas = canvas;
        gc = canvas.getGraphicsContext2D();

    }

    public void setBackground(String imageName) {
        ImageLoader imageLoader = new ImageLoader();
        background = imageLoader.loadImageFromResources(imageName);

    }

    public void render(List<Entity> entityList) {
        Platform.runLater(() -> {
            gc.clearRect(0,0,canvas.getWidth(), canvas.getHeight());
            gc.drawImage(background, 0, 0, canvas.getWidth(), canvas.getHeight());
            for(Entity entity:entityList){
                PositionComp positionComp = entity.getComponent(PositionComp.class);
                gc.drawImage(entity.getSprite(), positionComp.getX(), positionComp.getY(), entity.getWidth(), entity.getHeight());
            }
        });
    }

}
