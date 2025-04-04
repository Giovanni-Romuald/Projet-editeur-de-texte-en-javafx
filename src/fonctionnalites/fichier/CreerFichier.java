package fonctionnalites.fichier;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextInputDialog;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;

public class CreerFichier {

    // Méthode pour créer un fichier dans un emplacement choisi par l'utilisateur
    public static void creerFichier(String contenu) {
        // Créer un FileChooser pour permettre à l'utilisateur de choisir l'emplacement du fichier
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Fichier texte", "*.txt"));

        // Boîte de dialogue pour choisir le fichier
        Stage stage = new Stage();
        File fichierChoisi = fileChooser.showSaveDialog(stage);

        if (fichierChoisi != null) {
            // Boîte de dialogue pour demander le nom du fichier si l'utilisateur n'a pas spécifié le nom
            if (fichierChoisi.getName().equals("Untitled.txt")) {
                TextInputDialog dialog = new TextInputDialog("monFichier");
                dialog.setTitle("Nom du fichier");
                dialog.setHeaderText("Entrez le nom du fichier texte (sans extension)");
                dialog.setContentText("Nom du fichier:");

                Optional<String> result = dialog.showAndWait();
                String nomFichier = result.orElse("monFichier"); // Valeur par défaut si l'utilisateur annule

                fichierChoisi = new File(fichierChoisi.getParent(), nomFichier + ".txt");
            }

            try (FileWriter writer = new FileWriter(fichierChoisi)) {
                // On écrit le contenu dans le fichier
                writer.write(contenu);
                System.out.println("Fichier sauvegardé à l'emplacement: " + fichierChoisi.getAbsolutePath());

                // Alerte pour informer que le fichier a été sauvegardé
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setHeaderText("Fichier sauvegardé à l'emplacement: " + fichierChoisi.getAbsolutePath());
                alert.showAndWait();

                // Ouvrir le fichier après sa création
                OuvertureFichier.OuvertureFichierChoisi();

            } catch (IOException e) {
                System.out.println("Erreur lors de l'écriture du fichier.");
                e.printStackTrace();
            }
        } else {
            // L'utilisateur a annulé l'enregistrement, donc aucun fichier n'a été créé
            System.out.println("L'utilisateur a annulé la création du fichier.");
        }
    }
}
