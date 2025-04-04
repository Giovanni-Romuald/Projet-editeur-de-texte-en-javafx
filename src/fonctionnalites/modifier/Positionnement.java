package fonctionnalites.modifier;

import javafx.scene.control.TextArea;

public class Positionnement {

    // Méthode pour aligner le texte à gauche
    public static void alignerGauche(TextArea textArea) {
        textArea.setStyle("-fx-text-alignment: left; -fx-alignment: top-left;");
    }

    // Méthode pour centrer le texte
    public static void alignerCentre(TextArea textArea) {
        textArea.setStyle("-fx-text-alignment: center; -fx-alignment: top-center;");
    }

    // Méthode pour aligner le texte à droite
    public static void alignerDroite(TextArea textArea) {
        textArea.setStyle("-fx-text-alignment: right; -fx-alignment: top-right; -fx-position:relative;");
    }
}
