package sample.Controllers;

import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import sample.Interface.implem.CollectionAdressBook;
import sample.Objects.Person;

import java.io.IOException;


public class Controller {


    CollectionAdressBook adressBookImpl = new CollectionAdressBook();


    private Stage mainStage;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnChange;

    @FXML
    private TextField fieldSearch;

    @FXML
    private TableView tableAdress;

    @FXML
    private TableColumn<Person, String> columnName;

    @FXML
    private TableColumn<Person, String> columnPhoneNumber;

    @FXML
    private Label labelCount;

    private Parent fxmlEdit;

    private FXMLLoader fxmlLoader = new FXMLLoader();

    private ControllerModal editDialogController;

    private Stage editDialogStage;


    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;
    }

    private void updateCountLabel() {
        labelCount.setText("Количество записей: " + adressBookImpl.getPersonList().size());
    }


    public void initialize() {
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        initListeners();
        adressBookImpl.dataPeople();
        tableAdress.setItems(adressBookImpl.getPersonList());
        initLoader();
    }


    private void initListeners() {
        adressBookImpl.getPersonList().addListener(new ListChangeListener<Person>() {
            @Override
            public void onChanged(Change<? extends Person> c) {
                updateCountLabel();
            }
        });
        tableAdress.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle (MouseEvent event){
                if (event.getClickCount() == 2) {
                    editDialogController.setPerson((Person) tableAdress.getSelectionModel().getSelectedItem());
                    showDialog();
                }
            }
        });
    }


    private void initLoader() {
        try {
            fxmlLoader.setLocation(getClass().getResource("../sources/ControllerModal.fxml"));
            fxmlEdit = fxmlLoader.load();
            editDialogController = fxmlLoader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void actionButtonPressed(ActionEvent actionEvent) {

        Object source = actionEvent.getSource();

        Button click = (Button) source;

        Person selectPerson = (Person) tableAdress.getSelectionModel().getSelectedItem();

        Window parentWindow = ((Node) actionEvent.getSource()).getScene().getWindow();
        editDialogController.setPerson(selectPerson);

        switch (click.getId()) {
            case "btnAdd":
                editDialogController.setPerson(new Person());
                showDialog();
                adressBookImpl.add(editDialogController.getPerson());
                break;
            case "btnChange":
                editDialogController.setPerson((Person) tableAdress.getSelectionModel().getSelectedItem());
                showDialog();
                break;
            case "btnDelete":
                adressBookImpl.delete((Person) tableAdress.getSelectionModel().getSelectedItem());
                break;
        }
    }

    private void showDialog() {
        if (editDialogStage == null) {
            editDialogStage = new Stage();
            editDialogStage.setTitle("Изменение записи");
            editDialogStage.setMinWidth(300);
            editDialogStage.setMinHeight(100);
            editDialogStage.setResizable(false);
            editDialogStage.setScene(new Scene(fxmlEdit));
            editDialogStage.initModality(Modality.WINDOW_MODAL);
            editDialogStage.initOwner(mainStage);

        }
        editDialogStage.showAndWait();
        //editDialogStage.show();
    }



}






