package fonctionnalites.fichier;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class OuvertureFichier {
    public static File OuvertureFichierChoisi(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("fichier texte", "*txt"));
        File fichierChoisi = fileChooser.showOpenDialog(new Stage());
        return fichierChoisi;
    }
    public static String lireContenuFichier(File fichier) {
        StringBuilder contenu = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(fichier))) {
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                contenu.append(ligne).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return contenu.toString(); // Retourne le contenu du fichier
    }
}

