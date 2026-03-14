package com.klu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.klu.model.Book;

@RestController
public class LibraryController {

    List<Book> bookList = new ArrayList<>();

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Library System";
    }

    @GetMapping("/count")
    public int count() {
        return bookList.size();
    }

    @GetMapping("/price")
    public double price() {
        return 499.99;
    }

    @GetMapping("/books")
    public List<String> books() {

        List<String> list = new ArrayList<>();

        list.add("Java");
        list.add("Spring Boot");
        list.add("Python");

        return list;
    }

    @GetMapping("/books/{id}")
    public String getBook(@PathVariable int id) {
        return "Book details for ID: " + id;
    }

    @GetMapping("/search")
    public String search(@RequestParam String title) {
        return "Searching book: " + title;
    }

    @GetMapping("/author/{name}")
    public String author(@PathVariable String name) {
        return "Author name: " + name;
    }

    @PostMapping("/addbook")
    public String addBook(@RequestBody Book book) {

        bookList.add(book);

        return "Book added successfully";
    }

    @GetMapping("/viewbooks")
    public List<Book> viewBooks() {

        return bookList;
    }
}