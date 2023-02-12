package RGR;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Error extends Stage {
    private static Label lineLable1;

    public Error() {
        setTitle("Ошибка");
        setWidth(500);


        lineLable1 = new Label("Пожалуйста, проверьте  корректность вводимых значений на отрицательность");
        VBox vBox = new VBox(lineLable1);
        vBox.setPadding(new Insets(10,0,10,0));
        vBox.setAlignment(Pos.CENTER);

        Scene sc = new Scene(vBox); // создание панели под интерфейс
        setResizable(false); //нельзя менять размер окна
        setScene(sc); // передача всего интерфейса на панель
        show();

    }
}

