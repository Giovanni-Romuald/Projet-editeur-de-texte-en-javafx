package Interface;

import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import fonctionnalites.aide.AfficherInformations;
import fonctionnalites.aide.EnvoyerFeedback;
import fonctionnalites.fichier.CreerFichier;
import fonctionnalites.fichier.Impression;
import fonctionnalites.fichier.NouvelleFenetre;
import fonctionnalites.fichier.OuvertureFichier;
import fonctionnalites.formatage.ChangerCouleur;
import fonctionnalites.formatage.Police;
import fonctionnalites.modifier.Positionnement;
import fonctionnalites.modifier.RechercherTexte;
import fonctionnalites.modifier.SelectionnerTexte;
import fonctionnalites.modifier.Taille;
import fonctionnalites.vue.ZoomDezoom;
import fonctionnalites.style.StyleTexte;
import java.io.File;


public class PagePrincipal {
    private Scene scene;
    private TextArea textArea;

    public PagePrincipal() {
        // Création du menu fichier et ses différents composants
        Menu fichier = new Menu("Fichier");
        MenuItem nouveauDocument = new MenuItem("Nouveau fichier");
        MenuItem nouvelleFenetre = new MenuItem("Nouvelle fenetre");
        MenuItem ouvrirFichier = new MenuItem("Ouvrir fichier");
        SeparatorMenuItem separateurItem = new SeparatorMenuItem();
        MenuItem sauvegarder = new MenuItem("Sauvegarder");
        MenuItem imprimer = new MenuItem("Imprimer");
        fichier.getItems().addAll(nouveauDocument, nouvelleFenetre, ouvrirFichier, separateurItem, sauvegarder, imprimer);

        // Menu "Modifier"
        Menu modifier = new Menu("Modifier");
        MenuItem selectionnerTout = new MenuItem("Sélectionner tout");
        MenuItem deselectionner = new MenuItem("Désélectionner");
        MenuItem copier = new MenuItem("Copier");
        MenuItem coller = new MenuItem("Coller");
        MenuItem couper = new MenuItem("Couper");
        MenuItem rechercher = new MenuItem("Rechercher");
        SeparatorMenuItem separateurModifier = new SeparatorMenuItem();
        MenuItem alignerGauche = new MenuItem("Aligner à gauche");
        MenuItem alignerCentre = new MenuItem("Centrer");
        MenuItem alignerDroite = new MenuItem("Aligner à droite");
        modifier.getItems().addAll(selectionnerTout,deselectionner, rechercher, separateurItem, copier, coller, couper,separateurModifier,alignerCentre,alignerGauche,alignerDroite);

        // Menu "Formatage"
        Menu formatage = new Menu("Formatage");
        MenuItem police = new MenuItem("Choisir police");
        MenuItem taille = new MenuItem("taille police");
        MenuItem couleur = new MenuItem("Choisir couleur");
        formatage.getItems().addAll(police,taille, couleur);

        Menu style = new Menu("Style");
        MenuItem gras = new MenuItem("gras");
        MenuItem italique = new MenuItem("italique");
        MenuItem souligne = new MenuItem("souligné");
        style.getItems().addAll(gras,italique,souligne);
        

        // Menu "Vue"
        Menu vue = new Menu("Vue");
        MenuItem zoom = new MenuItem("Zoom +");
        MenuItem dezoom = new MenuItem("Zoom -");
        vue.getItems().addAll(zoom, dezoom);

        // Menu "Aide"
        Menu aide = new Menu("Aide");
        MenuItem feedback = new MenuItem("Envoyer feedback");
        MenuItem informations = new MenuItem("Plus sur GE");
        aide.getItems().addAll( feedback, informations);

        // Création de la barre de menus
        MenuBar menuBar = new MenuBar(fichier, modifier, formatage,style, vue, aide);

        // Création de la TextArea pour afficher le contenu du fichier
        textArea = new TextArea();
        textArea.setWrapText(true);
        textArea.setPromptText("Écrivez ici...");

        // Fonctionnalité d'ouverture de fichier
        ouvrirFichier.setOnAction(e -> OuvrirFenetreChoixFichier());

        // Fonctionnalité de création d'un nouveau fichier
        nouveauDocument.setOnAction(e -> creerNouveauFichier());

        // Fonctionnalité de sauvegarde du fichier
        sauvegarder.setOnAction(e -> sauvegarderFichier());

        //nouvelle fenetre
        nouvelleFenetre.setOnAction(e -> nouvelleFenetreAffichage());

        //impression
        imprimer.setOnAction(e -> Impression.imprimerTextArea(textArea));

        //selectionner
        selectionnerTout.setOnAction(e -> SelectionnerTexte.selectionnerToutTexte(textArea));

        //copier
        copier.setOnAction(e -> SelectionnerTexte.copierTexteSelectionne(textArea));
        
        //coller
        coller.setOnAction(e -> SelectionnerTexte.collerTexte(textArea));

        //couper
        couper.setOnAction(e -> SelectionnerTexte.couperTexteSelectionne(textArea));

        //deselectionner
        deselectionner.setOnAction(e -> SelectionnerTexte.deselectionnerTexte(textArea));

        //Changer la taille
        taille.setOnAction(e -> Taille.changerTaillePolice(textArea));  


        //police
        police.setOnAction(e -> {
            Police.changerPolice(textArea);
        });

        //couleur
        
        couleur.setOnAction(e -> {
            ChangerCouleur.changerCouleurTexte(textArea);
        });

        //rechercher
        rechercher.setOnAction(e -> {
        // Exemple d'ouverture d'une fenêtre pour saisir le texte à rechercher
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Rechercher");
            dialog.setHeaderText("Entrez le texte à rechercher :");
            dialog.setContentText("Texte :");
            dialog.showAndWait().ifPresent(texteRecherche -> {
                RechercherTexte.rechercherEtMettreEnSurbrillance(textArea, texteRecherche);
            });
        });
        
        //zoom
        zoom.setOnAction(e -> {
            ZoomDezoom.zoom(0.1); // Zoomer
        });

        //feedback
        feedback.setOnAction(e -> EnvoyerFeedback.afficherFeedbackForm());


        dezoom.setOnAction(e -> {
            ZoomDezoom.zoom(-0.1); // Dézoomer
        });

        //informations
        informations.setOnAction(e -> AfficherInformations.afficherInfos());

        //position
        alignerGauche.setOnAction(e -> Positionnement.alignerGauche(textArea));
        alignerCentre.setOnAction(e -> Positionnement.alignerCentre(textArea));
        alignerDroite.setOnAction(e -> Positionnement.alignerDroite(textArea));

        gras.setOnAction(event -> {
            StyleTexte.styleT(textArea, "-fx-text-decoration: underline;");
        });
        italique.setOnAction(e-> StyleTexte.styleT(textArea,"-fx-font-style:italic;"));
        souligne.setOnAction(e-> StyleTexte.styleT(textArea,"-fx-underline:true"));





        // Création de la VBox (layout) et ajout du menu et de la TextArea
        VBox root = new VBox();
        root.getChildren().addAll(menuBar, textArea);
        VBox.setVgrow(textArea, Priority.ALWAYS);
        ZoomDezoom.configurerZoom(scene, root);


        // Création de la scène
        scene = new Scene(root, 499, 700);
    }

    // Fonctionnalité de création d'un nouveau fichier
    private void creerNouveauFichier() {
        // Réinitialise le contenu de la TextArea pour créer un nouveau fichier
        textArea.clear();
        CreerFichier.creerFichier("");
    }

    // Fonctionnalité d'ouverture de fichier et affichage du contenu dans la TextArea
    private void OuvrirFenetreChoixFichier() {
        File fichierChoisi = OuvertureFichier.OuvertureFichierChoisi();
        if (fichierChoisi != null) {
            afficherContenuFichier(fichierChoisi);
        } else {
            System.out.println("Aucun fichier choisi.");
        }
    }

    // Méthode pour afficher le contenu du fichier dans la TextArea
    private void afficherContenuFichier(File fichier) {
        String contenu = OuvertureFichier.lireContenuFichier(fichier);
        textArea.setText(contenu); // Affichage du contenu dans la TextArea
    }

    // Fonctionnalité de sauvegarde du contenu dans le fichier
    private void sauvegarderFichier() {
        // Utilisation de la classe CreerFichier pour sauvegarder le contenu
        String contenu = textArea.getText();  // Récupère le contenu de la TextArea
        CreerFichier.creerFichier(contenu);   // Appelle la méthode pour créer et sauvegarder le fichier
    }

    private void nouvelleFenetreAffichage(){
        NouvelleFenetre fenetreNew = new NouvelleFenetre();
    }

    public Scene getScene() {
        return this.scene;
    }
}
