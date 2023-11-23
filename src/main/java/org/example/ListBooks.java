package org.example;

import lombok.Data;


import java.util.List;

@Data
public class ListBooks {
    private List<BookEntity> data;

    @Override
    public String toString() {
        return "Лист" +
                "Книги: " + data;
    }

}
