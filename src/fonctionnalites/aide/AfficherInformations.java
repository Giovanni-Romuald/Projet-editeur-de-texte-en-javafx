package fonctionnalites.aide;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


public class AfficherInformations {

    public static void afficherInfos() {
        // Création d'une alerte avec le type INFORMATION
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText("Nous tenons à vous remercier chaleureusement d’avoir installé l’application GE sur votre ordinateur.\n"
                        + "Votre confiance et votre soutien sont très précieux.\n\n"
                        + "Cette application, créée par KAMGAIN KAMDEM GIOVANNI, a été conçue avec soin pour vous offrir une expérience optimale et répondre à vos besoins.\n"
                        + "Nous espérons qu’elle vous sera d’une grande utilité.\n\n"
                        + "N’hésitez pas à nous faire part de vos retours ou suggestions, car votre satisfaction est notre priorité.\n\n"
                        + "Merci encore et bonne utilisation de l’application GE !");
        alert.setContentText("Numéro :(+237)658036648\nEmail : giovannikamdem7@gmail.com\n ");

        
        // Afficher l'alerte
        alert.showAndWait();
    }
}