package RGR;

import static org.junit.Assert.*;

import org.junit.Test;

public class RasWallpaperTest {

	@Test
	public void testRasWallpaper() {
		RasWallpaper test2 = new RasWallpaper();
		test2.setDateWallpaper( 4, 44, 42, 74, 56, 410);
		test2.rasWallpaper();
		assertEquals(732,test2.getRas());
		
		
	}

}
