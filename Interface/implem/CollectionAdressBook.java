package sample.Interface.implem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.Interface.AdressBook;
import sample.Objects.Person;

import java.util.ArrayList;
import java.util.Observable;

//реализация кнопок с помощью коллекции
public class CollectionAdressBook implements AdressBook {

    private final ObservableList<Person> personList = FXCollections.observableArrayList();


    public ObservableList<Person> getPersonList() {
        return personList;
    }

    @Override
    public void add(Person person){
        personList.add(person);
    }

    @Override
    public void update(Person person) {
    }

    @Override
    public void delete(Person person) {
        personList.remove(person);
    }

    public void dataPeople(){
        personList.add(new Person("Lenin","9867"));
        personList.add(new Person("Chegevara","89734"));
        personList.add(new Person("KimCheNir","465467"));

    }


}
