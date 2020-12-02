import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.scene.media.Media;


public class MediaTest extends Application {
    MediaPlayer player;
    Media media;
    WebView webView;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
//        Media media = new Media(getClass().getResource("bachSuiteNo1.mp3").toString());
//        player = new MediaPlayer(media);
//        player.play();

//        media = new Media(getClass().getResource("file_example_MP4_480_1_5MG.mp4").toString());
//        player = new MediaPlayer(media);
//        MediaView mediaView = new MediaView(player);
//
//        Group root = new Group();
//        root.getChildren().add(mediaView);
//        Scene scene = new Scene(root, 1280, 720);
//        primaryStage.setScene(scene);
//        player.play();
//
//        primaryStage.setTitle("Media-Test");
//        primaryStage.show();

        webView = new WebView();
        webView.getEngine().load("https://abbts.ch");
        Scene scene = new Scene(webView, 600, 440);
        primaryStage.setScene(scene);
        primaryStage.setTitle("ABBTS");
        primaryStage.show();
    }
}
