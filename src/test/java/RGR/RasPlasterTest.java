package RGR;

import static org.junit.Assert.*;

import org.junit.Test;

public class RasPlasterTest {

	@Test
	public void test() {
		RasPlaster plaster = new RasPlaster();
		plaster.setDatePlaster(12,12,12,12,12);
		
		plaster.rasPlaster();
	
		assertNotNull(plaster.getArea());
	}
		
}

