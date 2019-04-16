package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Objects.Person;

import java.util.ResourceBundle;

public class ControllerModal {

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPhoneNumber;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnOk;

    private Person person;


    public void setPerson(Person person) {
        if(person==null){
            return;
        }
        this.person = person;
        txtName.setText(person.getName());
        txtPhoneNumber.setText(person.getPhoneNumber());
    }

    public Person getPerson() {
        return person;
    }




    public void agree(ActionEvent actionEvent) {
        person.setName(txtName.getText());
        person.setPhoneNumber(txtPhoneNumber.getText());
        cancelButton(actionEvent);
    }

    public void cancelButton(ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.hide();
    }



}
