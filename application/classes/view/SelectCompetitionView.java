package classes.view;

import java.io.IOException;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SelectCompetitionView {

	@FXML private VBox root;
	
	private MainView mainView;
	
	// Click-Events
	public void timePaneClick(Event event) throws IOException {
		// TODO: IOException in dieser Methode behandeln
		
		// Den Tab erstellen und hinzuf�gen
		TimeCompetitionView tcvc = new TimeCompetitionView();
		if(tcvc.checkRequirements()) {
			// wenn die Voraussetzungen gekl�rt sind, den View einbinden, sonst nicht
			mainView.addTab(this.createTab("Wettkampf (Zeit)", "/templates/competition/competitionView.fxml", tcvc));
		}
			
		// zuletzt das Modal (dieses Fenster) schlie�en
		this.close();
	}
	
	public void distancePaneClick(Event event) throws IOException {
		// TODO: IOException in dieser Methode behandeln
		
		// Den Tab erstellen und hinzuf�gen
		mainView.addTab(this.createTab("Wettkampf (Distanz)", "/templates/competition/competitionView.fxml", null));
		
		// TODO: CompetitionView Controller (Distanz) hinzuf�gen, um einen Wettkampf
		// zu kontrollieren. Diesem einen Wettkampf mitgeben. So wird entschieden,
		// welcher Wettkampf ausgef�hrt wird
		
		// zuletzt das Modal (dieses Fenster) schlie�en
		this.close();
	}
	
	private Tab createTab(String title, String resource, CompetitionView controller) throws IOException {
		Tab tab = new Tab(title);
		FXMLLoader loader = new FXMLLoader(getClass().getResource(resource));
		loader.setController(controller);
		tab.setContent(loader.load());
		return tab;
	}
	
	private void close() {
		Stage stage = (Stage)root.getScene().getWindow();
		stage.close();
	}
	
	// Setzt den MainView, damit diese Klasse
	// bei einem Klick, einen Tab setzen kann.
	void setMainViewController(MainView mvc) {
		mainView = mvc;
	}
}