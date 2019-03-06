
import businessLayer.Shopping;
import businessLayer.Store;
import presentationLayer.ConsoleIO;
import java.io.IOException;

public class OnlineShoppingApp {

	public static void main(String[] args) throws IOException {
		Store store = new Store();
		ConsoleIO cio = new ConsoleIO();
		Shopping shopping = new Shopping();
		cio.startUserInterface(store, shopping);
	}

}
