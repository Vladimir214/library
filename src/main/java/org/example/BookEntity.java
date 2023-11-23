package org.example;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookEntity {
    private String Title;
    private AuthorEntity author;
    private PublisherEntity publishing;
    private String book;

    @Override
    public String toString() {
        return "Книга: [" +
                "Название - " + '\''+Title + '\'' +
                "," + author + "" +
                ", " + publishing + "]";
    }
}
