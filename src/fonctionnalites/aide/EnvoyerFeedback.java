package fonctionnalites.aide;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EnvoyerFeedback {

    public static void afficherFeedbackForm() {
        Stage feedbackStage = new Stage();
        VBox root = new VBox(10);

        // Titre
        javafx.scene.control.Label label = new javafx.scene.control.Label("Envoyer un Feedback");

        // Zone de texte pour entrer le feedback
        TextArea feedbackArea = new TextArea();
        feedbackArea.setPromptText("Entrez votre feedback ici...");

        // Bouton pour envoyer le feedback
        Button envoyerButton = new Button("Envoyer");

        envoyerButton.setOnAction(e -> {
            String feedback = feedbackArea.getText();
            if (!feedback.trim().isEmpty()) {
                // Sauvegarder le feedback dans un fichier
                sauvegarderFeedback(feedback);
                feedbackArea.clear();  // Vider le champ après l'envoi
                afficherMessageConfirmation();
            } else {
                afficherMessageErreur();
            }
        });

        root.getChildren().addAll(label, feedbackArea, envoyerButton);

        Scene scene = new Scene(root, 400, 300);
        feedbackStage.setScene(scene);
        feedbackStage.setTitle("Formulaire de Feedback");
        feedbackStage.show();
    }

    // Méthode pour sauvegarder le feedback dans un fichier
    private static void sauvegarderFeedback(String feedback) {
        File file = new File("feedback.txt");  // Fichier de stockage du feedback
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(feedback);
            writer.newLine();
            writer.write("-----");
            writer.newLine();  // Séparer chaque feedback
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Afficher un message de confirmation après l'envoi du feedback
    private static void afficherMessageConfirmation() {
        Stage confirmationStage = new Stage();
        VBox vbox = new VBox(10);
        javafx.scene.control.Label confirmationLabel = new javafx.scene.control.Label("Votre feedback a été envoyé avec succès !");
        Button okButton = new Button("OK");

        okButton.setOnAction(e -> confirmationStage.close());

        vbox.getChildren().addAll(confirmationLabel, okButton);
        Scene confirmationScene = new Scene(vbox, 250, 150);
        confirmationStage.setScene(confirmationScene);
        confirmationStage.setTitle("Confirmation");
        confirmationStage.show();
    }

    // Afficher un message d'erreur si le champ de feedback est vide
    private static void afficherMessageErreur() {
        Stage errorStage = new Stage();
        VBox vbox = new VBox(10);
        javafx.scene.control.Label errorLabel = new javafx.scene.control.Label("Veuillez entrer un feedback avant d'envoyer.");
        Button okButton = new Button("OK");

        okButton.setOnAction(e -> errorStage.close());

        vbox.getChildren().addAll(errorLabel, okButton);
        Scene errorScene = new Scene(vbox, 300, 150);
        errorStage.setScene(errorScene);
        errorStage.setTitle("Erreur");
        errorStage.show();
    }
}
