package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import model.SpaceWar;

public class SpaceWarController {

	private SpaceWar spaceWar;
	
    @FXML
    private GridPane gridP1FW;

    @FXML
    private GridPane gridP2FW;

    @FXML
    private GridPane gridP3FW;

    @FXML
    private TextArea rowFW;

    @FXML
    private TextArea columnFW;

    @FXML
    private GridPane gridP1SW;

    @FXML
    private GridPane gridP2SW;

    @FXML
    private GridPane gridP3SW;

    @FXML
    private TextArea rowSW;

    @FXML
    private TextArea columnSW;

    @FXML
    private GridPane gridP1TW;

    @FXML
    private GridPane gridP2TW;

    @FXML
    private GridPane gridP3TW;

    @FXML
    private TextArea amountMatrixTW;

    @FXML
    private Button generateTW;
    
    @FXML
    public void initialize() {
    	spaceWar = new SpaceWar();
    }

    @FXML
    void generateFW(ActionEvent event) {
    	try {
    		int rows = Integer.parseInt(rowFW.getText());
        	int columns = Integer.parseInt(columnFW.getText());	
        	
        	int[][] a = spaceWar.randomMatrix(rows, columns, true);
        	int[][] b = spaceWar.randomMatrix(rows, columns, true);
        	int[][] c = spaceWar.multiplyTwoMatrices(a, b);
        	
        	gridP1FW = new GridPane();
        	gridP2FW = new GridPane();
        	for (int i = 0; i < c.length; i++) {
				gridP1FW.addRow(i);
				gridP2FW.addColumn(i);
			}
        	for (int i = 0; i < c[0].length; i++) {
        		gridP1FW.addColumn(i);
        		gridP2FW.addRow(i);
			}
        	for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[0].length; j++) {
					Label l = new Label(a[i][j] + "");
					l.resize(40, 40);
					l.setStyle("-fx-text-fill: yellow");
					gridP1FW.add(l, i, j);
				}
			}
        	
    	} catch(NegativeArraySizeException | IllegalArgumentException e) {
    		Alert a = new Alert(AlertType.ERROR);
    		a.setContentText(e.getMessage());
    		a.show();
    	}
    }

    @FXML
    void generateSW(ActionEvent event) {
    	
    }

    @FXML
    void noRepeSW(ActionEvent event) {
    	
    }

    @FXML
    void withRepeSW(ActionEvent event) {
    	
    }

}
