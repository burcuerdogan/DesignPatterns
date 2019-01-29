import businessLayer.CustomExceptions;
import businessLayer.Mediator;
import presentation.MainMenuIO;

import java.io.IOException;
import java.text.ParseException;


public class ProjectApp {
	public static void main(String[] args) throws
			IOException,
			ParseException,
			CustomExceptions.EmptyFieldNotAllowedException,
			CustomExceptions.NotAcceptedDateFormat,
			CustomExceptions.ProjectNotFoundException {

		Mediator mediator = new Mediator();
		MainMenuIO interaction = new MainMenuIO();
		mediator.initializer();
		interaction.startUserInterface(mediator);

	}
}
