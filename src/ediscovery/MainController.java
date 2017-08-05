/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ediscovery;

import com.jfoenix.controls.JFXButton;
import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author Jango
 */
public class MainController implements Initializable {
    @FXML
    private JFXButton b1;
    @FXML
    private JFXButton b3;
    @FXML
    private JFXButton exit;
    @FXML
    private JFXButton b2;
    @FXML
    private JFXButton b21;
    
    
    @FXML
    private JFXButton b22;
    
    
    @FXML
    ListView<String> mylistview;
    
    
    


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

 




    @FXML
    private void addfiles(ActionEvent event) {
        
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("ZIP files","*.zip"));
        File selectedFile=fc.showOpenDialog(null);
        if(selectedFile !=null){
        mylistview.getItems().add(selectedFile.getName());
        }
        else {
        System.out.println("File is not valid");
        }
    }

    @FXML
    private void onExit(ActionEvent event) {
        //close garna lai window
       Platform.exit();
           
    }

    @FXML
    private void unzipitems(ActionEvent event) {
        
    }
   
}
