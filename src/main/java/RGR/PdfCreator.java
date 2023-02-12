package RGR;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;


public class PdfCreator {
    
    private static String typeWork2;
    
    public static final com.itextpdf.text.Font FONT = FontFactory.getFont("/resourses/TIMES.TTF","CP1251",true);//шрифт
    
    
    public static void setTypeRabot(String typeWork) {
    	typeWork2 = typeWork; //значение типа работ
    }
    
    public static void create(int ras, double area, double leng, double wid, double pr, double con, double lay, double con1, double lay1) {//статический метод
        Document doc = new Document();//иницализируем документ
        
        Image image3;
        try {
        BufferedImage image = ImageIO.read(Objects.requireNonNull(PdfCreator.class.getResource("/resourses/imag.png"))); // путь до картинки 
        ByteArrayOutputStream baos = new ByteArrayOutputStream(); //создаёт буффер в памяти и все данные, отправленные в поток хранятся в нём
        ImageIO.write(image, "png", baos);
        Image iTextImage = Image.getInstance(baos.toByteArray()); //Возвращает объект baos с заданным ByteArray
        image3 = Image.getInstance(iTextImage);
        } catch (BadElementException | IOException e) { //catch - перехват данных в блоке 
        throw new RuntimeException(e); //обработка нового необрабатываемого исключения RuntimeException
        }
        image3.scaleAbsolute(100f, 100f); //длина и ширина картинки

        try {
            PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream("Результат.pdf"));
            doc.open(); 

            Paragraph firstLine = new Paragraph("ОТЧЕТ О ПРОДЕЛАННОЙ РАБОТЕ:\n\n", FONT);
            firstLine.setAlignment(Element.ALIGN_CENTER); //оцентровка перовй строки
            doc.add(firstLine); // doc.add - добавление объекта в коллекцию объекта doc
            
            doc.add(new Paragraph("Тип работы: "+ typeWork2, FONT));
            
            doc.add(new Paragraph("Длина =  " + leng + " метра(ов)", FONT));
            doc.add(new Paragraph("Ширина =  " + wid + " метра(ов)", FONT));
            doc.add(new Paragraph("Цена =  " + pr + " рублей", FONT));
            doc.add(new Paragraph("Расход =  "+ con+ " кг/м", FONT));
            doc.add(new Paragraph("Количество слоев  =  "+ lay, FONT));
            doc.add(new Paragraph("Длина рулона =  "+ con1 + " метра(ов)", FONT));
            doc.add(new Paragraph("Ширина рулона  =  "+ lay1 + " метра(ов)", FONT));
            
            doc.add(new Paragraph("Вам придется потратить  " + ras + " рублей.", FONT));
            doc.add(new Paragraph("На " + area +" квадратных метрах", FONT));
            
            
            image3.setAbsolutePosition(475, 725); //позиция картинки в координатах
            writer.getDirectContent().addImage(image3);
            doc.add(image3);
     
            Paragraph footer = new Paragraph("Разработано командой №7!", FONT);
            footer.setAlignment(Element.ALIGN_CENTER); // оцентровка последней строки 
            doc.add(footer);
           
            
            doc.close();
            writer.close();

        } catch (DocumentException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        
    }


}

