package no.joachim.duong.utility;

import java.net.URL;
import javafx.scene.image.Image;

public class ImageLoader {
    public Image loadImageFromResources(String imagePath) {
        URL imageURL = this.getClass().getResource("/images/" + imagePath);

        if (imageURL != null) {
            // Load the image from the URL
            return new Image(imageURL.toExternalForm());
        } else {
            // Handle the case where the image resource is not found
            System.out.println("Image resource not found: " + imagePath);
            return null;
        }
    }
}
