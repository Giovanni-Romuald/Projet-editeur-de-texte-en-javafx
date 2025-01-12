package fonctionnalites.vue;

import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.scene.transform.Scale;

public class ZoomDezoom {

    // Attributs pour la mise à l'échelle
    private static double scaleFactor = 1.0; // Facteur de mise à l'échelle initial
    private static double zoomStep = 0.1;   // Pas de zoom/dézoom (ajustez selon les besoins)
    private static VBox root;

    // Méthode pour configurer le zoom et le dézoom
    public static void configurerZoom(Scene scene, VBox rootLayout) {
        root = rootLayout;

        // Ajouter des MenuItem pour zoomer et dézoomer
        MenuItem zoomIn = new MenuItem("Zoom +");
        MenuItem zoomOut = new MenuItem("Zoom -");

        // Fonctionnalité de zoom + (incrémentation du facteur de zoom)
        zoomIn.setOnAction(e -> {
            zoom(zoomStep);
        });

        // Fonctionnalité de zoom - (décroissance du facteur de zoom)
        zoomOut.setOnAction(e -> {
            zoom(-zoomStep);
        });

        // Ajouter ces éléments dans le menu de votre fenêtre ou scène
        // Cela pourrait être ajouté à un MenuBar ou à un autre conteneur selon votre conception
    }

    // Méthode pour appliquer le zoom/dézoom
    public static void zoom(double step) {
        // Calculer le nouveau facteur de mise à l'échelle
        scaleFactor += step;

        if (scaleFactor < 0.1) { // Empêcher un zoom trop important (optionnel)
            scaleFactor = 0.1;
        }

        // Appliquer la mise à l'échelle à la scène ou à un conteneur
        Scale scale = new Scale(scaleFactor, scaleFactor);
        root.getTransforms().clear();  // Supprimer les transformations précédentes
        root.getTransforms().add(scale);  // Ajouter la nouvelle transformation
    }
}
