package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import model.SpaceWar;

public class SpaceWarController {

	private SpaceWar spaceWar;
    @FXML
    private ScrollPane scrollP1FW;

    @FXML
    private ScrollPane scrollP2FW;

    @FXML
    private ScrollPane scrollP3FW;
      
    private GridPane gridP1FW;

    private GridPane gridP2FW;

    private GridPane gridP3FW;

    @FXML
    private TextArea rowFW;

    @FXML
    private TextArea columnFW;

    @FXML
    private ScrollPane scrollP1SW;

    @FXML
    private ScrollPane scrollP2SW;

    @FXML
    private ScrollPane scrollP3SW;

    private GridPane gridP1SW;

    private GridPane gridP2SW;

    private GridPane gridP3SW;

    @FXML
    private TextArea rowSW;

    @FXML
    private TextArea columnSW;

    @FXML
    private ScrollPane scrollP1TW;

    private GridPane gridP1TW;

    @FXML
    private TextArea amountMatrixTW;
    
    @FXML
    public void initialize() {
    	spaceWar = new SpaceWar();
    }

    @FXML
    void generateFW(ActionEvent event) {
    	
    	gridP1FW = new GridPane();
    	gridP2FW = new GridPane();
    	gridP3FW = new GridPane();
    	
    	scrollP1FW.setContent(gridP1FW);
    	scrollP2FW.setContent(gridP2FW);
    	scrollP3FW.setContent(gridP3FW);

    	try {
    		
    		int rows = Integer.parseInt(rowFW.getText());
        	int columns = Integer.parseInt(columnFW.getText());	
        	
        	int[][] a = spaceWar.randomMatrix(rows, columns, true);
        	int[][] b = spaceWar.randomMatrix(rows, columns, true);
        	int[][] c = spaceWar.multiplyTwoMatrices(a, b);
        	

        	for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[0].length; j++) {
					Button l = new Button(a[i][j] + "");
					gridP1FW.add(l, i, j);
					
					Button l2 = new Button(b[i][j] + "");
					gridP2FW.add(l2, i, j);
				}
			}
        	
        	for (int i = 0; i < c.length; i++) {
				for (int j = 0; j < c[0].length; j++) {
					Button l = new Button(c[i][j] + "");
					
					gridP3FW.add(l, i, j);
				}
        	}
        	
    	} catch(NegativeArraySizeException | IllegalArgumentException e) {
    		Alert a = new Alert(AlertType.ERROR);
    		a.setContentText(e.getMessage());
    		a.show();
    	}
    }

    @FXML
    void noRepeSW(ActionEvent event) {
    	gridP1SW = new GridPane();
    	gridP2SW = new GridPane();
    	gridP3SW = new GridPane();
    	scrollP1SW.setContent(gridP1SW);
    	scrollP2SW.setContent(gridP2SW);
    	scrollP3SW.setContent(gridP3SW);
    	try {
    		int rows = Integer.parseInt(rowSW.getText());
        	int columns = Integer.parseInt(columnSW.getText());
        	
        	int[][] a = spaceWar.randomMatrix(rows, columns, false);
        	int[][] b = spaceWar.randomMatrix(rows, columns, false);
        	int[][] c = spaceWar.multiplyTwoMatrices(a, b);


        	for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[0].length; j++) {
					Button l = new Button(a[i][j] + "");
					gridP1SW.add(l, i, j);
					
					Button l2 = new Button(b[i][j] + "");
					gridP2SW.add(l2, i, j);
				}
			}
        	
        	for (int i = 0; i < c.length; i++) {
				for (int j = 0; j < c[0].length; j++) {
					Button l = new Button(c[i][j] + "");
					gridP3SW.add(l, i, j);
				}
        	}
        	
    	} catch(NegativeArraySizeException | IllegalArgumentException e) {
    		Alert a = new Alert(AlertType.ERROR);
    		a.setContentText(e.getMessage());
    		a.show();
    	}
    }

    @FXML
    void withRepeSW(ActionEvent event) {
    	gridP1SW = new GridPane();
    	gridP2SW = new GridPane();
    	gridP3SW = new GridPane();
    	scrollP1SW.setContent(gridP1SW);
    	scrollP2SW.setContent(gridP2SW);
    	scrollP3SW.setContent(gridP3SW);
    	try {
    		int rows = Integer.parseInt(rowSW.getText());
        	int columns = Integer.parseInt(columnSW.getText());	
        	
        	int[][] a = spaceWar.randomMatrix(rows, columns, true);
        	int[][] b = spaceWar.randomMatrix(rows, columns, true);
        	int[][] c = spaceWar.multiplyTwoMatrices(a, b);

        	for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[0].length; j++) {
					Button l = new Button(a[i][j] + "");
					gridP1SW.add(l, i, j);
					
					Button l2 = new Button(b[i][j] + "");
					gridP2SW.add(l2, i, j);
				}
			}
        	
        	for (int i = 0; i < c.length; i++) {
				for (int j = 0; j < c[0].length; j++) {
					Button l = new Button(c[i][j] + "");
					gridP3SW.add(l, i, j);
				}
        	}
        	
    	} catch(NegativeArraySizeException | IllegalArgumentException e) {
    		Alert a = new Alert(AlertType.ERROR);
    		a.setContentText(e.getMessage());
    		a.show();
    	}
    }
    
    @FXML
    void generateTW(ActionEvent event) {
    	gridP1TW = new GridPane();
    	scrollP1TW.setContent(gridP1TW);
    	try {
    		int n = Integer.parseInt(amountMatrixTW.getText());
    		java.util.Random r = new java.util.Random();
			int rows = r.nextInt(SpaceWar.LIMIT_THIRD_BATTLE-1) + 1;
			int columns = r.nextInt(SpaceWar.LIMIT_THIRD_BATTLE-1) + 1;
			int[][] result = spaceWar.randomMatrix(rows, columns, true);
    		for (int i = 0; i < n; i++) {
				int[][] a = spaceWar.randomMatrix(columns, rows, true);
				result = spaceWar.multiplyTwoMatrices(a, result);
				rows = result.length;
				columns = result[0].length;
			}
    		for (int i = 0; i < result.length; i++) {
				for (int j = 0; j < result[0].length; j++) {
					Button l = new Button(result[i][j] + "");
					gridP1TW.add(l, i,j);
				}
    		}
    		
    	} catch(NegativeArraySizeException | IllegalArgumentException e) {
    		Alert a = new Alert(AlertType.ERROR);
    		a.setContentText(e.getMessage());
    		a.show();
    	}
    }
    

}
