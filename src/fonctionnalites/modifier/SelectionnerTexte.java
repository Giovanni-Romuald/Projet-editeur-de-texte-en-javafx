package fonctionnalites.modifier;

import javafx.scene.control.TextArea;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

public class SelectionnerTexte {

    /**
     * Sélectionne tout le texte dans une TextArea.
     *
     * @param textArea La TextArea où le texte doit être sélectionné.
     */
    public static void selectionnerToutTexte(TextArea textArea) {
        if (textArea != null) {
            textArea.selectAll();
            System.out.println("Tout le texte a été sélectionné.");
        } else {
            System.out.println("La TextArea est vide ou nulle.");
        }
    }

    /**
     * Copie le texte sélectionné dans le presse-papier.
     *
     * @param textArea La TextArea contenant le texte à copier.
     */
    public static void copierTexteSelectionne(TextArea textArea) {
        if (textArea != null && textArea.getSelectedText() != null && !textArea.getSelectedText().isEmpty()) {
            Clipboard clipboard = Clipboard.getSystemClipboard();
            ClipboardContent content = new ClipboardContent();
            content.putString(textArea.getSelectedText());
            clipboard.setContent(content);
            System.out.println("Le texte sélectionné a été copié dans le presse-papier.");
        } else {
            System.out.println("Aucun texte sélectionné à copier.");
        }
    }
    public static void couperTexteSelectionne(TextArea textArea) {
        if (textArea != null && textArea.getSelectedText() != null && !textArea.getSelectedText().isEmpty()) {
            Clipboard clipboard = Clipboard.getSystemClipboard();
            ClipboardContent content = new ClipboardContent();
            content.putString(textArea.getSelectedText());
            clipboard.setContent(content);

            // Supprime le texte sélectionné de la TextArea
            textArea.replaceSelection("");
            System.out.println("Le texte sélectionné a été coupé.");
        } else {
            System.out.println("Aucun texte sélectionné à couper.");
        }
    }
    public static void collerTexte(TextArea textArea) {
        if (textArea != null) {
            Clipboard clipboard = Clipboard.getSystemClipboard();
            if (clipboard.hasString()) {
                String texte = clipboard.getString();
                textArea.insertText(textArea.getCaretPosition(), texte);
                System.out.println("Le texte du presse-papier a été collé.");
            } else {
                System.out.println("Aucun texte dans le presse-papier à coller.");
            }
        } else {
            System.out.println("La TextArea est nulle.");
        }
    }
    public static void deselectionnerTexte(TextArea textArea) {
        if (textArea != null) {
            textArea.deselect();
            System.out.println("Le texte a été désélectionné.");
        } else {
            System.out.println("La TextArea est nulle ou vide.");
        }
    }
}

