package no.joachim.duong.runnable;

import java.util.ArrayList;
import javafx.scene.image.Image;
import no.joachim.duong.entity.units.Entity;
import no.joachim.duong.entity.units.PlayerCharacter;

public class LevelGenerator {
    private String backgroundName;
    public ArrayList<Entity> getLevelFromId(int id, PlayerCharacter playerCharacter) {
        switch (id) {
            case (1):
                backgroundName = "background.png";
                return populateFirstLevel(playerCharacter);
            default:
                return null;
        }
    }
    private ArrayList<Entity> populateFirstLevel(PlayerCharacter playerCharacter) {
        ArrayList<Entity> entityList = new ArrayList<>();
        entityList.add(playerCharacter);
        return entityList;
    }
    public String getBackgroundName() {
        return backgroundName;
    }
}
