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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

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

    private final FileReader reader = new FileReader();

    @FXML
    private TextField txInfo;

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
        txInfo.setText("");
        User user = new User(txName.getText(), txPhone.getText());
        tabList.getItems().add(user);
        tabList.refresh();

    }

    @FXML
    private void addUpdate(ActionEvent event) {
        txInfo.setText("");
        ObservableList<User> lista = tabList.getItems();
        try {
            int index = tabList.getSelectionModel().getSelectedIndex();
            User user = lista.get(index);
            user.setName(txName.getText());
            user.setPhone(txPhone.getText());
            tabList.refresh();
        } catch (ArrayIndexOutOfBoundsException e) {
            txInfo.setText("Nie wybrano użytkownika do aktualizacji.");
        }
    }

    @FXML
    private void addDelete(ActionEvent event) {
        txInfo.setText("");
        ObservableList<User> lista = tabList.getItems();
        try {
            int index = tabList.getSelectionModel().getSelectedIndex();
            lista.remove(index);
        } catch (ArrayIndexOutOfBoundsException e) {
            txInfo.setText("Nie wybrano użytkownika do usunięcia");
        }
    }

    @FXML
    private void rowSelected(MouseEvent event) {
        txInfo.setText("");
        User user = (User) tabList.getSelectionModel().getSelectedItem();
        txName.setText(user.getName());
        txPhone.setText(user.getPhone());
    }

    @FXML
    public void exitApplication(ActionEvent event) {
        System.out.println("Stage is closing2");
    }
}
