package sample.Objects;


import javafx.beans.property.SimpleStringProperty;

public class Person {

    private SimpleStringProperty name = new SimpleStringProperty("");
    private SimpleStringProperty phoneNumber = new SimpleStringProperty("");

    public Person(String name, String phoneNumber) {
        this.name = new SimpleStringProperty(name);
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
    }
    public Person(){
    }

    public String getName() {
        return name.getName();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getPhoneNumber() {
        return phoneNumber.getName();
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }


    @Override
    public String toString(){
        return "Person("+"name = "+name + "phone = " + phoneNumber + ')';
    }
}
