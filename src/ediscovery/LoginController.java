package ediscovery;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.sun.glass.events.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javax.swing.JOptionPane;

/**
 *
 * @author danml
 */
public class LoginController implements Initializable {
    
    @FXML
    private ImageView viewLoader;
    
    @FXML
    private JFXButton btnlogin;
    
    @FXML
    private Label titleLabel;


    @FXML
    private JFXTextField txtusername;
    @FXML
    private JFXPasswordField txtpassword;

     Connection conn=null;
ResultSet rs=null;
PreparedStatement pst=null;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
     // handlelogin();
         conn=db.ConnectDb();
      viewLoader.setVisible(false);
      
        // TODO
     
    }

   

            

    @FXML
    private void loginAction(ActionEvent event) throws IOException, SQLException {
        
        
        
        String sql = "select username,password from users where username=? and password=?";
        
            pst=conn.prepareStatement(sql);
            pst.setString(1,txtusername.getText());
            pst.setString(2,txtpassword.getText());
            rs=pst.executeQuery();
            if (rs.next()){
                
                
                 Parent root=FXMLLoader.load(getClass().getResource("main.fxml"));
         Stage stage=new Stage();
         Scene scene = new Scene(root);

       stage.setResizable(false);
   stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();
               
        
        
        
            }
            else{JOptionPane.showMessageDialog(null, "Please try again");}
      
        
        
        
        
        
        
//        if(txtusername.getText().equals("admin")&& txtpassword.getText().equals("admin")){
//         viewLoader.setVisible(true);
//        PauseTransition pauseTransition = new PauseTransition();
//        pauseTransition.setDuration(Duration.seconds(3));
//        pauseTransition.setOnFinished(ev -> {
//            completeLogin();
//                                                                                 
//        });
//        pauseTransition.play();
//         }
//      else{
//          
//          titleLabel.setText("Oops sorry Wrong Username and Password !!!");
//      }
//      
        
  }

    private void completeLogin() {
        btnlogin.getScene().getWindow().hide();
        try {
            viewLoader.setVisible(false);
            Parent root=FXMLLoader.load(getClass().getResource("main.fxml"));
         Stage stage=new Stage();
         Scene scene = new Scene(root);
        //top ko title bar ko mininmize ,amximize haru hatauna lai
       stage.setResizable(false);
   stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }}
}

      
  
    
