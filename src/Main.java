import Interface.PagePrincipal;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
    final String titre = "Giovanni-Editor";
    @Override
    public void start(Stage primaryStage){
        PagePrincipal pagePrincipal = new PagePrincipal();
        Image imagelogo = new Image("file:src/image/KG.png");
        primaryStage.setScene(pagePrincipal.getScene());
        primaryStage.getIcons().add(imagelogo);
        primaryStage.setTitle(titre);
        primaryStage.show();
    }
    public static void main(String[] args) throws Exception {
        launch(args);
        
    }
}
