package fonctionnalites.style;

import javafx.scene.control.TextArea;

public class StyleTexte {

    /**
     * Applique un style au texte sélectionné dans un TextArea.
     *
     * @param textArea Le TextArea dans lequel appliquer le style.
     * @param style Le style CSS à appliquer au texte sélectionné.
     */
    public static void styleT(TextArea textArea, String style) {
        // Vérifier si une sélection de texte existe
        int start = textArea.getSelection().getStart();
        int end = textArea.getSelection().getEnd();

        if (start != end) {
            // Récupérer le texte sélectionné
            String selectionTexte = textArea.getSelectedText();
            
            // Appliquer le style en format HTML
            String styledTexte = String.format("<span style='%s'>%s</span>",style, selectionTexte);
            
            // Remplacer le texte sélectionné par le texte stylé
            textArea.replaceSelection(styledTexte);
            
            // Afficher un message de confirmation dans la console
            System.out.println("Le style \"" + style + "\" a été appliqué.");
        } else {
            System.out.println("Aucune sélection de texte.");
        }
    }
}
