package RGR;

import static org.junit.Assert.*;

import org.junit.Test;

public class RasClayTest {

	@Test
	public void testRasClay() {
		RasClay test1 = new RasClay();
		test1.setDateClay( 5, 6, 4, 2, 100);
		test1.rasClay();
		assertEquals(1500,test1.getRas());
		
	}

}
