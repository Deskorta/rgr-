package RGR;

import javafx.stage.Stage;

public class RasClay extends Ras{
	private double length;
	private double width;
	private double area;
	private double price;
	private double consumption;
	private int layer;
	private double ras;
	private int ras2;
	
	private double leng;
	private double wid;
	private double pr;
	private double con;
	private int lay;
	private double con1;
	private int lay1;

	public void setDateClay(double width, double length, double consumption, int layer,double price) {
		this.width = width;
		this.length = length;
		this.price = price;
		this.consumption = consumption;
		this.layer = layer;
		}
	
	@Override
	public double getArea(){return area;
	}
		
	@Override
	public int getRas(){
		return ras2;
	}
	
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
	public double getCon1(){
		return con;
	}
	
	@Override
	public double getLay1(){
		return lay;
	}
	@Override
	public double getCon11(){
		return con1;
	}
	
	@Override
	public double getLay11(){
		return lay1;
	}
	

	public void rasClay(){
		ras = ((width * length * layer)/consumption)*price;
		area = width*length;
		if (ras % 10 != 0){
			ras++;
			this.ras2 = (int) this.ras ;
			this.leng = this.length;
			this.wid = this.width;
			this.pr = this.price;
			this.con = this.consumption;
			this.lay = this.layer;
			
		}
		if (ras < 0 ){
			Stage Error = new Error();
			Error.show();}
		else{
			this.ras2 =(int) this.ras;
			this.leng = this.length;
			this.wid = this.width;
			this.pr = this.price;
			this.con = this.consumption;
			this.lay = this.layer;
		
		}
		
		}
}
