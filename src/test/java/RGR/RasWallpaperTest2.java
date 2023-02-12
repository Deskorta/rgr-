package RGR;

import static org.junit.Assert.*;

import org.junit.Test;

public class RasWallpaperTest2 {

	@Test
	public void test() {
		RasWallpaper wallpaper = new RasWallpaper();
		wallpaper.setDateWallpaper(12,12,12,12,12,12);
		
		wallpaper.rasWallpaper();
		assertEquals(145.0, wallpaper.getRas(),1);
	}

}
