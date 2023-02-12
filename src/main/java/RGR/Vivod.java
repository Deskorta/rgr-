package RGR;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class Vivod extends Stage{
    private static Button exitButton;
    private static Label lineLable1;
    private static Label lineLabel2;
    private int ras;
    private double area;
    private double leng;
    private double wid;


    public Vivod(int ras, double area, double leng, double wid, double pr, double con, double lay, double con1, double lay1) {


        setTitle("Вывод");
        setWidth(400);

        lineLable1 = new Label("Вам придется потратить " + ras + " рублей");
        lineLabel2 = new Label("На " + area +" кадратных метров площади");
        VBox buttonsBox = new VBox(lineLable1, lineLabel2);
        buttonsBox.setSpacing(30);
        buttonsBox.setPadding(new Insets(10,0,0,0));
        buttonsBox.setAlignment(Pos.CENTER);

        exitButton = new Button("назад");
        Button generPDFButton = new Button("Генерация PDF");
        VBox vBox2 = new VBox(buttonsBox, generPDFButton,  exitButton);
        vBox2.setSpacing(10);
        vBox2.setPadding(new Insets(10, 20, 10, 20));

        Scene sc = new Scene(vBox2); // создание панели под интерфейс
        setResizable(false); //нельзя менять размер окна
        setScene(sc); // передача всего интерфейса на панель
        show();

        exitButton.setOnAction( e -> {
            close();
            Stage MainWindow = new Stage();
            Main mainWindow = new Main();
            mainWindow.start(MainWindow);
        });
        
        generPDFButton.setOnAction( e -> {
        	PdfCreator pdf = new PdfCreator();
        	close();
        	pdf.create(ras, area, leng, wid, pr, con, lay, con1, lay1);
            Stage MainWindow = new Stage();
            Main mainWindow = new Main();
            mainWindow.start(MainWindow);
        });
    }
}
