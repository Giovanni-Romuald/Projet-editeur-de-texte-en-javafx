package fonctionnalites.modifier;

import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;

public class Taille {
    
    public static void changerTaillePolice(TextArea textArea) {
        // Créer un dialog pour entrer la taille de la police
        TextInputDialog dialog = new TextInputDialog("13");  // Taille par défaut
        dialog.setTitle("Changer Taille Police");
        dialog.setHeaderText("Entrez la taille de la police :");
        dialog.setContentText("Taille de la police:");

        // Attendre la réponse de l'utilisateur
        dialog.showAndWait().ifPresent(taille -> {
            try {
                // Convertir la taille en entier
                int taillePolice = Integer.parseInt(taille);
                
                // Vérifier que la taille est valide (par exemple, entre 5 et 100)
                if (taillePolice >= 5 && taillePolice <= 100) {
                    // Appliquer la taille de la police à la TextArea
                    textArea.setStyle("-fx-font-size: " + taillePolice + "px;");
                } else {
                    // Afficher une alerte si la taille est invalide
                    Alert alert = new Alert(AlertType.WARNING);
                    alert.setTitle("Erreur");
                    alert.setHeaderText("Taille de police invalide");
                    alert.setContentText("La taille doit être entre 5 et 100.");
                    alert.showAndWait();
                }
            } catch (NumberFormatException e) {
                // Afficher une alerte si la taille n'est pas un nombre valide
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText("Entrée invalide");
                alert.setContentText("Veuillez entrer un nombre valide pour la taille de la police.");
                alert.showAndWait();
            }
        });
    }
}
