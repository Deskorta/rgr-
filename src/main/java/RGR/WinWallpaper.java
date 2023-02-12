package RGR;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class WinWallpaper extends Stage {
	private static Button calculateButton;
	private static Button exitButton;
	private static Label lineLabel1;
	private static TextField textField1;
	private static Label lineLabel2;
	private static TextField textField2;
	private static Label lineLabel3;
	private static TextField textField3;
	private static Label lineLabel4;
	private static TextField textField4;
	private static Label lineLabel5;
	private static TextField textField5;
	private static Label lineLabel6;
	private static TextField textField6;
	private int ras;
	private double leng;
	private double wid;
	private double pr;

    public WinWallpaper() {
        setTitle("Обои");
        setWidth(400);

        lineLabel1 = new Label("Длина комнаты (м):");
        textField1 = new TextField();
        lineLabel1.setTextAlignment(TextAlignment.CENTER); //присоединяет свойства TextAlignment для указанного объекта для выравнивания объекта по центру
        textField1.setPrefColumnCount(10); //размер текстового поля в столбцах
        HBox Box1 = new HBox(lineLabel1, textField1);
        Box1.setSpacing(10);

        lineLabel2 = new Label("Ширина комнаты (м):");
        textField2 = new TextField();
        lineLabel2.setTextAlignment(TextAlignment.RIGHT);
        textField2.setPrefColumnCount(10);
        HBox Box2 = new HBox(lineLabel2, textField2);


        lineLabel3 = new Label("Высота комнаты (м):");
        textField3 = new TextField();
        lineLabel3.setTextAlignment(TextAlignment.RIGHT);
        textField3.setPrefColumnCount(10);
        HBox Box3 = new HBox(lineLabel3, textField3);

        lineLabel4 = new Label("Ширина рулона(м):");
        textField4 = new TextField();
        lineLabel4.setTextAlignment(TextAlignment.RIGHT);
        textField4.setPrefColumnCount(10);
        HBox Box4 = new HBox(lineLabel4, textField4);

        lineLabel5 = new Label("Длина рулона(м):");
        textField5 = new TextField();
        lineLabel5.setTextAlignment(TextAlignment.RIGHT);
        textField5.setPrefColumnCount(10);
        HBox Box5 = new HBox(lineLabel5, textField5);

        lineLabel6 = new Label("Цена рулона (без типа валюты):");
        textField6 = new TextField();
        lineLabel6.setTextAlignment(TextAlignment.RIGHT);
        textField6.setPrefColumnCount(10);
        HBox Box6 = new HBox(lineLabel6, textField6);

        exitButton = new Button("Назад");
        calculateButton = new Button("Расчитать");
        HBox ButtonsBox = new HBox(calculateButton, exitButton);
        ButtonsBox.setPadding(new Insets(10, 0, 0, 0));
        ButtonsBox.setSpacing(10);
        ButtonsBox.setAlignment(Pos.CENTER);

        VBox vBox2 = new VBox(Box1, Box2, Box3, Box4, Box5, Box6, ButtonsBox); //промежутки по горизонтали
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

        calculateButton.setOnAction( e -> {
            double length = Double.parseDouble(textField1.getText()); //передача занчений из поля для ввода в переменные
            double wight = Double.parseDouble(textField2.getText());
            double hight = Double.parseDouble(textField3.getText());
            double lengthW  = Double.parseDouble(textField4.getText());
            double wightW = Double.parseDouble(textField5.getText());
            double price = Double.parseDouble(textField6.getText());

            RasWallpaper rasWallpap = new RasWallpaper();
            rasWallpap.setDateWallpaper(length,wight, hight, lengthW, wightW, price); //передача данных в класс для рассчета этих самых данныхз
            rasWallpap.rasWallpaper(); //метод rasWallpap вызывает метод rasWallpaper
            this.ras = rasWallpap.getRas(); //приравнивание перемонной ras значения, полученного из расчетов
            double area = rasWallpap.getArea();
            double leng = rasWallpap.getLeng1();
            double wid = rasWallpap.getWid1();
            double pr = rasWallpap.getPr1();
            double con11 = rasWallpap.getCon11();
            double lay11 = rasWallpap.getLay11();
            double lay1 = rasWallpap.getLay1();
            double con1 = rasWallpap.getCon1();
            
            close();
            Stage vivod = new Vivod(ras, area, leng, wid, pr, con1, lay1, con11, lay11); // передача данных об рассчетах ценника и площади в Вывод
            vivod.show();
        });

        }
}
