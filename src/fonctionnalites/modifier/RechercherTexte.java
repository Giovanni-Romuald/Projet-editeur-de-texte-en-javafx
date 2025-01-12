package fonctionnalites.modifier;

import javafx.scene.control.TextArea;

public class RechercherTexte {

    /**
     * Recherche un texte dans une TextArea et sélectionne la première occurrence.
     *
     * @param textArea La TextArea où effectuer la recherche.
     * @param texteRecherche Le texte à rechercher.
     */
    public static void rechercherEtMettreEnSurbrillance(TextArea textArea, String texteRecherche) {
        if (textArea == null || texteRecherche == null || texteRecherche.isEmpty()) {
            System.out.println("TextArea ou texte recherché invalide.");
            return;
        }

        String contenu = textArea.getText();
        int index = contenu.indexOf(texteRecherche);

        if (index != -1) {
            // Sélectionne le texte trouvé
            textArea.selectRange(index, index + texteRecherche.length());
            System.out.println("Texte trouvé et sélectionné.");
        } else {
            System.out.println("Texte non trouvé.");
        }
    }
}
