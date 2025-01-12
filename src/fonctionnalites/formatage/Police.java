package fonctionnalites.formatage;

import javafx.scene.control.TextArea;
import javafx.scene.text.Font;
import javafx.scene.control.ChoiceDialog;
import java.util.List;
import java.util.Optional;

public class Police {

     
    public static void changerPolice(TextArea textArea) {
        if (textArea == null) {
            System.out.println("La TextArea est invalide.");
            return;
        }

        // Liste des polices disponibles
        List<String> policesDisponibles = Font.getFamilies();

        // Boîte de dialogue pour choisir une police
        ChoiceDialog<String> choixPoliceDialog = new ChoiceDialog<>(policesDisponibles.get(0), policesDisponibles);
        choixPoliceDialog.setTitle("Changer la Police");
        choixPoliceDialog.setHeaderText("Choisissez une police");
        choixPoliceDialog.setContentText("Police :");

        // Récupérer le choix de l'utilisateur
        Optional<String> resultat = choixPoliceDialog.showAndWait();
        resultat.ifPresent(policeChoisie -> {
            // Appliquer la nouvelle police
            textArea.setFont(Font.font(policeChoisie, textArea.getFont().getSize()));
            System.out.println("Police changée en : " + policeChoisie);
        });
    }
}
