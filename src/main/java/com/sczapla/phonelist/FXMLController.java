package com.sczapla.phonelist;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class FXMLController implements Initializable {
    
    @FXML
    private TextField txName;
    @FXML
    private TextField txPhone;
    @FXML
    private TableView<User> tabList;
    @FXML
    private Button btAdd;
    @FXML
    private Button btUpdate;
    @FXML
    private Button btDelete;
    @FXML
    private Label label;
    
    private final FileReader reader = new FileReader();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            ObservableList<User> list = tabList.getItems();
            list.addAll(reader.readPhoneList());
        } catch (Exception ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void addAction(ActionEvent event) {
    }

    @FXML
    private void addUpdate(ActionEvent event) {
    }

    @FXML
    private void addDelete(ActionEvent event) {
    }
}
