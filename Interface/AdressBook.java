package sample.Interface;

import sample.Objects.Person;

public interface AdressBook {
    // кнопки добавления, изменения и удаления
    void add(Person person);

    void update(Person person);

    void delete(Person person);
}
