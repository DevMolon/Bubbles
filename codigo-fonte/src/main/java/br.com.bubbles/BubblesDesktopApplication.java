
package br.com.bubbles;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

public class BubblesDesktopApplication {

    public static void main(String[] args) {
        Application.launch(BubblesWindow.class, args);
    }

    public static class BubblesWindow extends Application {

        private ConfigurableApplicationContext springContext;

        @Override
        public void init() {
            springContext = new SpringApplicationBuilder(BubblesApplication.class)
                    .run();
        }

        @Override
        public void start(Stage stage) {

            WebView navegador = new WebView();

            navegador.getEngine().load("http://localhost:8080/login");

            Scene scene = new Scene(navegador, 1100, 750);

            stage.setTitle("Bubbles");
            stage.setScene(scene);
            stage.setMinWidth(800);
            stage.setMinHeight(600);
            stage.centerOnScreen();
            stage.show();
        }

        @Override
        public void stop() {
            if (springContext != null) {
                springContext.close();
            }
        }
    }
}
 
