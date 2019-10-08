import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class SetupTest {

	
	@Test
	public void testCountAllBerries() {
		BerryUtil berryUtil = new BerryUtil();
		try {
			berryUtil.loadAllBerries();
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertEquals(64, berryUtil.getBerries().size());
	}
	
	@Test
	public void testFindFastestGrowingBerry() {
		BerryUtil berryUtil = new BerryUtil();
		try {
			berryUtil.loadAllBerries();
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertEquals("razz", berryUtil.getFastestGrowing().getName());
	}
	
	@Test
	public void testFindBerryById() {
		BerryUtil berryUtil = new BerryUtil();
		try {
			berryUtil.loadAllBerries();
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertEquals("iapapa", berryUtil.getBerryById(15).getName());
	}

}



