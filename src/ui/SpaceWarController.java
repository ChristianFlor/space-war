package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
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
    private TextArea amountMatrixTW;
    
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
        	
        	gridP1FW.getChildren().clear();
        	gridP2FW.getChildren().clear();
        	gridP3FW.getChildren().clear();

        	for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[0].length; j++) {
					Button l = new Button(a[i][j] + "");
					
					l.setAlignment(Pos.CENTER);
					
					
					gridP1FW.add(l, i, j);
					gridP1FW.setAlignment(Pos.CENTER);
					gridP1FW.setGridLinesVisible(true);
				
					Button l2 = new Button(b[i][j] + "");
					
					l2.setAlignment(Pos.CENTER);
					
					gridP2FW.add(l2, i, j);
					gridP2FW.setAlignment(Pos.CENTER);
				}
			}
        	
        	for (int i = 0; i < c.length; i++) {
				for (int j = 0; j < c[0].length; j++) {
					Button l = new Button(c[i][j] + "");
					l.autosize();
					
					
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
    	try {
    		int rows = Integer.parseInt(rowSW.getText());
        	int columns = Integer.parseInt(columnSW.getText());
        	
        	int[][] a = spaceWar.randomMatrix(rows, columns, false);
        	int[][] b = spaceWar.randomMatrix(rows, columns, false);
        	int[][] c = spaceWar.multiplyTwoMatrices(a, b);
        	
        	gridP1SW.getChildren().clear();
        	gridP2SW.getChildren().clear();
        	gridP3SW.getChildren().clear();

        	for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[0].length; j++) {
					Label l = new Label(a[i][j] + "");
					l.setStyle("-fx-font-size: 80px;");
					l.setAlignment(Pos.CENTER);
					l.setStyle("-fx-text-fill: white");
					
					gridP1SW.add(l, i, j);
					
					Label l2 = new Label(b[i][j] + "");
					l2.setStyle("-fx-font-size: 80px;");
					l2.setAlignment(Pos.CENTER);
					l2.setStyle("-fx-text-fill: white");
					
					gridP2SW.add(l2, i, j);
				}
			}
        	
        	for (int i = 0; i < c.length; i++) {
				for (int j = 0; j < c[0].length; j++) {
					Label l = new Label(c[i][j] + "");
					l.setStyle("-fx-font-size: 80px;");
					l.setAlignment(Pos.CENTER);
					l.setStyle("-fx-text-fill: white");
					
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
    	try {
    		int rows = Integer.parseInt(rowSW.getText());
        	int columns = Integer.parseInt(columnSW.getText());	
        	
        	int[][] a = spaceWar.randomMatrix(rows, columns, true);
        	int[][] b = spaceWar.randomMatrix(rows, columns, true);
        	int[][] c = spaceWar.multiplyTwoMatrices(a, b);
        	
        	gridP1SW.getChildren().clear();
        	gridP2SW.getChildren().clear();
        	gridP3SW.getChildren().clear();

        	for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[0].length; j++) {
					Label l = new Label(a[i][j] + "");
					l.setStyle("-fx-font-size: 80px;");
					l.setAlignment(Pos.CENTER);
					l.setStyle("-fx-text-fill: white");
					
					gridP1SW.add(l, i, j);
					
					Label l2 = new Label(b[i][j] + "");
					l2.setStyle("-fx-font-size: 80px;");
					l2.setAlignment(Pos.CENTER);
					l2.setStyle("-fx-text-fill: white");
					
					gridP2SW.add(l2, i, j);
				}
			}
        	
        	for (int i = 0; i < c.length; i++) {
				for (int j = 0; j < c[0].length; j++) {
					Label l = new Label(c[i][j] + "");
					l.setStyle("-fx-font-size: 80px;");
					l.setAlignment(Pos.CENTER);
					l.setStyle("-fx-text-fill: white");
					
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
    		gridP1TW.getChildren().clear();
    		for (int i = 0; i < result.length; i++) {
				for (int j = 0; j < result[0].length; j++) {
					Label l = new Label(result[i][j] + "");
					l.setStyle("-fx-font-size: 80px;");
					l.setAlignment(Pos.CENTER);
					l.setStyle("-fx-text-fill: white");
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
