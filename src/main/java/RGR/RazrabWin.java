package RGR;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class RazrabWin extends Stage{ //наследуется от класса Stage
    private static Button exitButton;
    private static Label lineLable1;
    private static Label lineLabel2;

    public RazrabWin() {
        setTitle("О разработчиках");
        setWidth(400);

        lineLable1 = new Label("Модератор и Разработчик 1 - Реутова Юлия ");
        lineLabel2 = new Label("Разработчик 2 и Разработчик 3 - Ахмадуллина Алсу");
        VBox buttonsBox = new VBox(lineLable1, lineLabel2);
        buttonsBox.setSpacing(30);
        buttonsBox.setPadding(new Insets(10, 0, 0, 0));
        buttonsBox.setAlignment(Pos.CENTER);

        exitButton = new Button("назад");

        VBox vBox2 = new VBox(buttonsBox, exitButton);
        vBox2.setSpacing(10);
        vBox2.setPadding(new Insets(10, 20, 10, 20));

        Scene sc = new Scene(vBox2);
        setResizable(false);
        setScene(sc);
        show();

        exitButton.setOnAction(e -> {
            close();
            Stage MainWindow = new Stage();
            Main mainWindow = new Main();
            mainWindow.start(MainWindow);
        });
    }
}
