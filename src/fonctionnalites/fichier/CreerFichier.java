package fonctionnalites.fichier;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreerFichier {

    // Méthode pour créer un fichier dans un dossier spécifique
    public static void creerFichier(String contenu) {
        // Crée un dossier "files" si il n'existe pas
        File dossier = new File("files");
        if (!dossier.exists()) {
            dossier.mkdir(); // Crée le dossier "files"
        }

        // Crée le fichier dans le dossier "files"
        File fichierChoisi = new File(dossier, "monFichier.txt");  // Nom du fichier
        try (FileWriter writer = new FileWriter(fichierChoisi)) {
            // On écrit le contenu dans le fichier, ligne par ligne
            writer.write(contenu);  // Si `contenu` contient des caractères spéciaux, on les gère ici.
            System.out.println("Fichier sauvegardé à l'emplacement: " + fichierChoisi.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Erreur lors de l'écriture du fichier.");
            e.printStackTrace();
        }
    }
}