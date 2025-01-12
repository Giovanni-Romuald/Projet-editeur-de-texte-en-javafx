package fonctionnalites.fichier;

import javafx.print.PrinterJob;
import javafx.scene.control.TextArea;

public class Impression {

    /**
     * Méthode pour imprimer le contenu d'une TextArea.
     *
     * @param textArea La TextArea contenant le texte à imprimer.
     */
    public static void imprimerTextArea(TextArea textArea) {
        // Créer un travail d'impression
        PrinterJob job = PrinterJob.createPrinterJob();

        if (job != null) {
            // Afficher la boîte de dialogue d'impression pour que l'utilisateur choisisse une imprimante
            boolean proceed = job.showPrintDialog(null);
            if (proceed) {
                // Imprimer la TextArea
                boolean success = job.printPage(textArea);
                if (success) {
                    job.endJob();
                    System.out.println("Impression réussie.");
                } else {
                    System.out.println("Échec de l'impression.");
                }
            } else {
                System.out.println("Impression annulée par l'utilisateur.");
            }
        } else {
            System.out.println("Impossible de créer un travail d'impression.");
        }
    }
}
