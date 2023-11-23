package org.example;

import com.google.gson.Gson;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        ListBooks books = new ListBooks();
        File file = new File("./file.txt");
        try(FileReader fileReader= new FileReader(file)) {
            Scanner fileScanner = new Scanner(fileReader);
            if (fileScanner.hasNextLine()) {
                String str2 = fileScanner.nextLine();
                Gson gson = new Gson();
                books = gson.fromJson(str2,ListBooks.class);
            }
        }catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }catch (IOException e) {
            throw new RuntimeException(e);
        }

        int menu = 0;
        do{
            System.out.println("1 - Добавить книгу");
            System.out.println("2 - Вывести");
            System.out.println("3 - Поиск книги");
            System.out.println("4 - Удалить книгу");
            System.out.println("5 - Записать в файл");
            System.out.println("6 - Закрыть программу");
            menu = scanner.nextInt();
            switch(menu) {
                case 1:
                    scanner.nextLine();
                    AuthorEntity author = new AuthorEntity();
                    System.out.println("Введите фамилию автора");
                    author.setLastName(scanner.nextLine());
                    System.out.println("Введите имя автора");
                    author.setName(scanner.nextLine());
                    System.out.println("Введите отчество автора");
                    author.setSurname(scanner.nextLine());
                    PublisherEntity publisher = new PublisherEntity();
                    System.out.println("Введите издательство");
                    publisher.setPublisher(scanner.nextLine());
                    System.out.println("Введите город");
                    publisher.setCity(scanner.nextLine());
                    BookEntity book = new BookEntity();
                    book.setPublishing(publisher);
                    book.setAuthor(author);
                    System.out.println("Введите название книги");
                    book.setTitle(scanner.nextLine());
                    if (books.getData()==null) {
                        List temp = new ArrayList<>();
                        temp.add(book);
                        books.setData(temp);
                    }else {
                        books.getData().add(book);
                    }break;
                case 2:
        try {
            books.getData().forEach(System.out::println);
        }catch (NullPointerException e){} break;
                case 3:
                    System.out.println("Введите данные книги которую хотите найти: ");
                    scanner.nextLine();
                    String textSearch = scanner.nextLine();
                    List searchResult = new ArrayList<>();
                    for(BookEntity b: books.getData()) {
                        if(b.getTitle().equals(textSearch)){
                            searchResult.add(b);
                        }
                        if (searchResult.isEmpty()) {
                            System.out.println("Книга не найдена");
                        if(b.getAuthor().equals(textSearch)){
                            searchResult.add(b);
                        }
                        }else {
                            searchResult.forEach(System.out::println);
                        }
                    }break;
                case 4:
                    System.out.println("Удаление ");break;
                case 5:
                    Gson gson = new Gson();
                    String str = gson.toJson(books);
                    try (FileWriter fileWriter = new FileWriter(file)) {
                        fileWriter.write(str);
                        System.out.println("Книга записана в файл");
                    }catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }catch (IOException e) {
                        throw new RuntimeException(e);
                    }break;
                case 6:
                    System.out.println("\n До свидания! ");
                    break;

            }

        }while( menu !=6);
    }
}