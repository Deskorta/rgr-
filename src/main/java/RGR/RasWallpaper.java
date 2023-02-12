package RGR;

import javafx.stage.Stage;

public class RasWallpaper extends Ras { //наследование методов из Абстрактного Ras
	private double length;
	private double width;
	private double hight;
	private double lengthW;
	private double wightW;
	private double price;
	private double area;
	private double ras;
	private int ras2;
	
	private double leng;
	private double wid;
	private double pr;
	private double con1;
	private double lay1;
	
	public void setDateWallpaper(double length, double wight, double hight, double lengthW, double wightW, double price) {
		this.length = length; //указатель для ссылки объекта на себя, чтобы показать, что нужна именно ЭТА длина именно в ЭТОМ поле
		this.width = wight;
		this.hight = hight;
		this.lengthW = lengthW;
		this.wightW = wightW;
		this.price = price;
	}
	
	@Override //потому что метод из абстрактного класса
	public double getArea() {
		return area;} //возврат площади
	
	@Override
	public int getRas(){
		return ras2;
	} // возврат значения ras в виде ras2
	
	@Override
	public double getLeng1(){
		return leng;
	}
	
	@Override
	public double getWid1(){
		return wid;
	}
	@Override
	public double getPr1(){
		return pr;
	}
	@Override
	public double getCon11(){
		return con1;
	}
	
	@Override
	public double getLay11(){
		return lay1;
	}
	
	public void rasWallpaper() {
		ras = ((width * length * hight) / (lengthW * wightW)) * price;
		area = width * length;
		if (ras % 10 != 0) { //если ras div 10 не равен нулю
			ras++; // +1
			this.ras2 = (int) this.ras;
			this.leng = this.length;
			this.wid = this.width;
			this.pr = this.price;
			this.con1 = this.lengthW;
			this.lay1 = this.wightW;
		}
		if (ras < 0 ){
			Stage Error = new Error();
			Error.show();}
		else{
			this.ras2 =(int) this.ras; //отброс дробной части
			this.leng = this.length;
			this.wid = this.width;
			this.pr = this.price;
			this.con1 = this.lengthW;
			this.lay1 = this.wightW;
		}
	}
}