import java.io.IOException;

/* Use the PokeAPI to find the largest Berry you can grow in the shortest time.

Points will be allocated as follows:

    [300] Correct result
    [100] Unit tests
    [100] Code readability

If you don't want to start your project from scratch, you may use this template that includes JUnit, Commons IO, and JSON.org.
Good luck! */
 
public class SetupHello {
	
	public static void main(String[] args) throws IOException {
		BerryUtil berryUtil = new BerryUtil();
		berryUtil.loadAllBerries();
		
//		berryUtil.printAllBerries();
		
		Berry berry =  berryUtil.getFastestGrowing();
		System.out.println("\nFastest growing berry:");
		System.out.println(berry);
	}
	

}
