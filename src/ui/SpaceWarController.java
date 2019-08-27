package ui;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import model.SpaceWar;

public class SpaceWarController {

	private static final String SHIP = "file:imgs"+File.separator+"rocket.png";
	
	private static final String BLANK = "file:imgs"+File.separator+"noBackground.png";
	
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
    	
    	gridP1FW.setHgap(3);
    	gridP1FW.setVgap(3);
    	
    	gridP2FW.setHgap(3);
    	gridP2FW.setVgap(3);
    	
    	gridP3FW.setHgap(3);
    	gridP3FW.setVgap(3);
    	
    	scrollP1FW.setContent(gridP1FW);
    	scrollP2FW.setContent(gridP2FW);
    	scrollP3FW.setContent(gridP3FW);

    	try {
    		
    		int rows = Integer.parseInt(rowFW.getText());
        	int columns = Integer.parseInt(columnFW.getText());	
        	
        	int[][] a = spaceWar.randomMatrix(rows, columns, true);
        	int[][] b = spaceWar.randomMatrix(rows, columns, true);
        	int[][] c = spaceWar.multiplyTwoMatrices(a, b);
        	
        	boolean[][] posA = spaceWar.findShips(a);
        	boolean[][] posB = spaceWar.findShips(b);
        	boolean[][] posC = spaceWar.findShips(c);
        	
        	for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[0].length; j++) {
					if(posA[i][j]) {
						gridP1FW.add(new ImageView(SHIP), i, j);
					} else {
						gridP1FW.add(new ImageView(BLANK), i, j);
					}
					
					if(posB[i][j]) {
						gridP2FW.add(new ImageView(SHIP), i, j);
					} else {
						gridP2FW.add(new ImageView(BLANK), i, j);
					}
					
				}
			}
        	
        	for (int i = 0; i < c.length; i++) {
				for (int j = 0; j < c[0].length; j++) {
					if(posC[i][j]) {
						gridP3FW.add(new ImageView(SHIP), i, j);
					} else {
						gridP3FW.add(new ImageView(BLANK), i, j);
					}
					
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
    	
    	gridP1SW.setHgap(3);
    	gridP1SW.setVgap(3);
    	
    	gridP2SW.setHgap(3);
    	gridP2SW.setVgap(3);
    	
    	gridP3SW.setHgap(3);
    	gridP3SW.setVgap(3);
    	
    	scrollP1SW.setContent(gridP1SW);
    	scrollP2SW.setContent(gridP2SW);
    	scrollP3SW.setContent(gridP3SW);
    	try {
    		int rows = Integer.parseInt(rowSW.getText());
        	int columns = Integer.parseInt(columnSW.getText());
        	
        	int[][] a = spaceWar.randomMatrix(rows, columns, false);
        	int[][] b = spaceWar.randomMatrix(rows, columns, false);
        	int[][] c = spaceWar.multiplyTwoMatrices(a, b);

        	boolean[][] posA = spaceWar.findShips(a);
        	boolean[][] posB = spaceWar.findShips(b);
        	boolean[][] posC = spaceWar.findShips(c);

        	for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[0].length; j++) {
					if(posA[i][j]) {
						gridP1SW.add(new ImageView(SHIP), i, j);
					} else {
						gridP1SW.add(new ImageView(BLANK), i, j);
					}
					if(posB[i][j]) {
						gridP2SW.add(new ImageView(SHIP), i, j);
					} else {
						gridP2SW.add(new ImageView(BLANK), i, j);
					}
					
				}
			}
        	
        	for (int i = 0; i < c.length; i++) {
				for (int j = 0; j < c[0].length; j++) {
					if(posC[i][j]) {
						gridP3SW.add(new ImageView(SHIP), i, j);
					} else {
						gridP3SW.add(new ImageView(BLANK), i, j);
					}
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
    	
    	gridP1SW.setHgap(3);
    	gridP1SW.setVgap(3);
    	
    	gridP2SW.setHgap(3);
    	gridP2SW.setVgap(3);
    	
    	gridP3SW.setHgap(3);
    	gridP3SW.setVgap(3);
    	
    	scrollP1SW.setContent(gridP1SW);
    	scrollP2SW.setContent(gridP2SW);
    	scrollP3SW.setContent(gridP3SW);
    	try {
    		int rows = Integer.parseInt(rowSW.getText());
        	int columns = Integer.parseInt(columnSW.getText());	
        	
        	int[][] a = spaceWar.randomMatrix(rows, columns, true);
        	int[][] b = spaceWar.randomMatrix(rows, columns, true);
        	int[][] c = spaceWar.multiplyTwoMatrices(a, b);
        	
        	boolean[][] posA = spaceWar.findShips(a);
        	boolean[][] posB = spaceWar.findShips(b);
        	boolean[][] posC = spaceWar.findShips(c);

        	for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[0].length; j++) {
					if(posA[i][j]) {
						gridP1SW.add(new ImageView(SHIP), i, j);
					} else {
						gridP1SW.add(new ImageView(BLANK), i, j);
					}
					
					if(posB[i][j]) {
						gridP2SW.add(new ImageView(SHIP), i, j);
					} else {
						gridP2SW.add(new ImageView(BLANK), i, j);
					}
				}
			}
        	
        	for (int i = 0; i < c.length; i++) {
				for (int j = 0; j < c[0].length; j++) {
					if(posC[i][j]) {
						gridP3SW.add(new ImageView(SHIP), i, j);
					} else {
						gridP3SW.add(new ImageView(BLANK), i, j);
					}
					
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
    	gridP1TW.setGridLinesVisible(true);
    	
    	gridP1TW.setHgap(4);
    	gridP1TW.setVgap(4);
    	
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
    		boolean[][] resultPos = spaceWar.findShips(result);
    		for (int i = 0; i < result.length; i++) {
				for (int j = 0; j < result[0].length; j++) {
					if(resultPos[i][j]) {
						gridP1TW.add(new ImageView(SHIP), i,j);
					} else {
						gridP1TW.add(new ImageView(BLANK), i,j);
					}
					
				}
    		}
    		
    	} catch(NegativeArraySizeException | IllegalArgumentException e) {
    		Alert a = new Alert(AlertType.ERROR);
    		a.setContentText(e.getMessage());
    		a.show();
    	}
    }
    

}
