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

public class WinPlaster extends Stage {
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
	private int ras;
	private double leng;
	private double wid;
	private double pr;
	private double con;
	private double lay;
	
    public WinPlaster() {
        setTitle("Штукатурка");
        setWidth(400);

        lineLabel1 = new Label("Ширина поверхности(м):");
        textField1 = new TextField();
        lineLabel1.setTextAlignment(TextAlignment.RIGHT);
        textField1.setPrefColumnCount(10);
        HBox Box1 = new HBox(lineLabel1, textField1);
        Box1.setSpacing(10);

        lineLabel2 = new Label("Длина(м):");
        textField2 = new TextField();
        lineLabel2.setTextAlignment(TextAlignment.RIGHT);
        textField2.setPrefColumnCount(10);
        HBox Box2 = new HBox(lineLabel2, textField2);


        lineLabel3 = new Label("Расход(кг/м):");
        textField3 = new TextField();
        lineLabel3.setTextAlignment(TextAlignment.RIGHT);
        textField3.setPrefColumnCount(10);
        HBox Box3 = new HBox(lineLabel3, textField3);

        lineLabel4 = new Label("Количество слоев:");
        textField4 = new TextField();
        lineLabel4.setTextAlignment(TextAlignment.RIGHT);
        textField4.setPrefColumnCount(10);
        HBox Box4 = new HBox(lineLabel4, textField4);

        lineLabel5 = new Label("Цена (без типа валюты):");
        textField5 = new TextField();
        lineLabel5.setTextAlignment(TextAlignment.RIGHT);
        textField5.setPrefColumnCount(10);
        HBox Box5 = new HBox(lineLabel5, textField5);

        exitButton = new Button("Назад");
        calculateButton = new Button("Расчитать");
        HBox ButtonsBox = new HBox(calculateButton, exitButton);
        ButtonsBox.setPadding(new Insets(10, 0, 0, 0));
        ButtonsBox.setSpacing(10);
        ButtonsBox.setAlignment(Pos.CENTER);


        VBox vBox2 = new VBox(Box1,Box2, Box3, Box4, Box5, ButtonsBox);
        vBox2.setSpacing(10);
        vBox2.setPadding(new Insets(10, 20, 10, 20));

        Scene sc = new Scene(vBox2);
        setResizable(false);
        setScene(sc);
        show();

        exitButton.setOnAction( e -> {
            close();
            Stage MainWindow = new Stage();
            Main mainWindow = new Main();
            mainWindow.start(MainWindow);
        });

        calculateButton.setOnAction( e -> { //лямбда, считывающая введеные данные и реализующая их для расчета
            double width = Double.parseDouble(textField1.getText());
            double light = Double.parseDouble(textField2.getText());
            double consumption = Double.parseDouble(textField3.getText());
            int layer = Integer.parseInt(textField4.getText());
            double price = Double.parseDouble(textField5.getText());

            RasPlaster rasPlast = new RasPlaster();
            rasPlast.setDatePlaster(width, light,consumption,layer,price);
            rasPlast.rasPlaster();
            this.ras = rasPlast.getRas();
            double area = rasPlast.getArea();
            double leng = rasPlast.getLeng1();
            double wid = rasPlast.getWid1();
            double pr = rasPlast.getPr1();
            double con = rasPlast.getCon1();
            double lay = rasPlast.getLay1();
            double con1 = rasPlast.getCon1();
            double lay1 = rasPlast.getLay1();
            
            close();
            Stage vivod = new Vivod(ras, area, leng, wid, pr, con, lay, con1, lay1);//
            vivod.show();
        });
    }
}
