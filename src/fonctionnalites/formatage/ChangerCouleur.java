package fonctionnalites.formatage;

import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class ChangerCouleur {

    /**
     * Permet à l'utilisateur de choisir une couleur et de l'appliquer au texte de la TextArea.
     * @param textArea La TextArea dont la couleur du texte doit être changée.
     */
    public static void changerCouleurTexte(TextArea textArea) {
        // Création d'un ColorPicker pour permettre à l'utilisateur de choisir une couleur
        ColorPicker colorPicker = new ColorPicker();
        
        // Création d'une nouvelle fenêtre pour le ColorPicker
        Stage colorPickerStage = new Stage();
        colorPickerStage.setTitle("Choisir la couleur du texte");

        // Action lorsque l'utilisateur choisit une couleur
        colorPicker.setOnAction(event -> {
            // Appliquer la couleur sélectionnée au texte de la TextArea
            textArea.setStyle("-fx-text-fill: " + toRgbString(colorPicker.getValue()) + ";");
            colorPickerStage.close();  // Ferme la fenêtre après sélection
        });

        // Ajouter le ColorPicker à la scène de la fenêtre
        colorPickerStage.setScene(new javafx.scene.Scene(colorPicker));
        colorPickerStage.show();  // Affiche la fenêtre du ColorPicker
    }

    /**
     * Convertit la couleur en une chaîne de caractères RGB.
     * @param color La couleur choisie.
     * @return Une chaîne au format RGB pour l'appliquer à la TextArea.
     */
    private static String toRgbString(javafx.scene.paint.Color color) {
        return String.format("rgb(%d,%d,%d)",
            (int) (color.getRed() * 255),
            (int) (color.getGreen() * 255),
            (int) (color.getBlue() * 255));
    }
}
