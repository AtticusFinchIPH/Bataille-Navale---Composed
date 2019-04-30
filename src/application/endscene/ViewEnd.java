package application.endscene;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ViewEnd extends VBox implements IViewEnd{
	
	private PresentationEnd presEnd;

	private Stage parent;
	private Scene nextScene;
	
	private String info;
	private Label informWinnerLab;
	private Button playAgainBtn, menuBtn, quitBtn;
	private HBox btnBox;
	
	public ViewEnd(final PresentationEnd pres) {
		presEnd = pres;
		
		informWinnerLab = new Label(info);
		playAgainBtn = new Button("Play Again");
		menuBtn = new Button("Menu");
		quitBtn = new Button("Quit");
		btnBox = new HBox(playAgainBtn, menuBtn, quitBtn);
		btnBox.setSpacing(20);
		btnBox.setAlignment(Pos.CENTER);
		
		getChildren().addAll(informWinnerLab, btnBox);
		setSpacing(30);
		setAlignment(Pos.CENTER);
	}
	
	public void setStage(Stage parent) {
		this.parent = parent;
	}
	
	@Override
	public void informWinner(String info) {
		informWinnerLab.setText(info);
	}
}
