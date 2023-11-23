package org.example;

import lombok.*;

@Data
public class AuthorEntity {
    private String name;
    private String lastName;
    private String surname;


    @Override
    public String toString() {
        return "Автор{" +
                " Имя - '" + name + '\'' +
                ", Фамилия - '" + lastName + '\'' +
                ", Отвество - '" + surname + "}";
    }
}

