package RGR;

import javafx.application.Application; //Javafx - класс создания графического интерфейса
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


public class Main extends Application {
    private static Label typeWorklLabel;
    private static final String[] monthActions = {"   ","расчет стоимости проклейки","расчет стоимости обоев","расчет стоимости штукатуривания"};//массив для списка
    private ChoiceBox<String> monthActionChoiceBox; // выпадение списка по нажатию
    private Button exitButton;
    private Button infoButton;
    

    public static void main(String[] args){
        Application.launch(args); //точка входа программы
    }

    public void start(Stage MainWindow){ //основной объект Stage создается средой и передается в метод реализации start()
        MainWindow.setTitle("Калькулятор отделочных работ");
        MainWindow.setWidth(310);

        typeWorklLabel = new Label("Выберите тип работ:");
        typeWorklLabel.setTextAlignment(TextAlignment.CENTER); //выравнивание текста по центру
        HBox typeBox = new HBox(typeWorklLabel); //HBox под выбор типа работ ведет выравнивание по горизонтали
   

        monthActionChoiceBox = new ChoiceBox<>(FXCollections.observableArrayList(monthActions)); //выпадающий список, аргументами которого является массив значений
        monthActionChoiceBox.setValue(monthActions[0]); // номер строчки по умолчанию, которая будет отображена в списке
        HBox spisokBox = new HBox(monthActionChoiceBox); // выравнивание списка

        infoButton = new Button("Разработчики");
        exitButton = new Button("Выход");
        HBox buttonsBox = new HBox(infoButton, exitButton);
        buttonsBox.setSpacing(30); //пробелы между кнопками в HBox`e
        buttonsBox.setPadding(new Insets(10,0,0,0)); // "поля", ограничивающие кнопки
        buttonsBox.setAlignment(Pos.CENTER); //оцентровка кнопок Выхода и разработчиков

       exitButton.setOnAction( e -> { // лямбда выражение для передачи метода по выходу из системы нажатию кнопки Выхода
           System.exit(0);
       });

       infoButton.setOnAction( e ->{
       MainWindow.close();
       Stage razrabWin = new RazrabWin(); // передача данных об рассчетах ценника и площади в Вывод
       });
       monthActionChoiceBox.setOnAction( e -> {//Лямбда выражение для реализации в классе конкретного метода в функциональном интерфейсе
           if (monthActionChoiceBox.getValue().equals(monthActions[1])) { //если значение строчки равно одному (выбор первого варианта, исключая пустой)
        	   Stage WinClay = new WinClay(); //откроется окно для задания переменных для клея
        	   PdfCreator pdf = new PdfCreator();
        	   pdf.setTypeRabot("расчет стоимости проклейки");
        	   MainWindow.close();
              
          } else if (monthActionChoiceBox.getValue().equals(monthActions[2])) { //двум
        	  Stage WinWallpaper = new WinWallpaper();
        	  PdfCreator pdf = new PdfCreator();
       	   		pdf.setTypeRabot("расчет стоимости обоев");
              MainWindow.close();
           
          } else if (monthActionChoiceBox.getValue().equals(monthActions[3])){ //трем
        	  Stage WinPlaster = new WinPlaster();
        	  PdfCreator pdf = new PdfCreator();
        	  pdf.setTypeRabot("расчет стоимости штукатуривания");
              MainWindow.close();
              
          }
      });

       VBox vBox = new VBox(typeBox, spisokBox,buttonsBox); //VBox ведет выравниваение по вертикали
       vBox.setSpacing(10); //пробелы между кнопками
       vBox.setPadding(new Insets(10, 20, 10, 20)); //поля для кнопочек

       Scene sc = new Scene(vBox);
       MainWindow.setResizable(false); //запрет на изменение размеров окна
       MainWindow.setScene(sc); //контейнер для всех графических элементов внутри объекта Stage
       MainWindow.show(); //показать окно

    }

}

