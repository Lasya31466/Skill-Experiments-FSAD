package com.klu.skill_6.controller;

import org.springframework.web.bind.annotation.*;

import com.klu.skill_6.model.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class LibraryController {

    
    private List<Book> bookList = new ArrayList<>();

    
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the Online Library System!";
    }

    @GetMapping("/count")
    public int getBookCount() {
        return 250;
    }

    
    @GetMapping("/price")
    public double getSamplePrice() {
        return 299.99;
    }

   
    @GetMapping("/books")
    public List<String> getAllBooks() {
        return Arrays.asList(
            "The Alchemist",
            "Clean Code",
            "Effective Java",
            "Spring in Action",
            "Design Patterns"
        );
    }

   
    @GetMapping("/books/{id}")
    public String getBookById(@PathVariable int id) {
        return "Book Details -> ID: " + id +
               " | Title: Spring Boot Mastery" +
               " | Author: John Doe" +
               " | Price: 399.99";
    }

   
    @GetMapping("/search")
    public String searchBook(@RequestParam String title) {
        return "Search result for book titled: " + title;
    }

   
    @GetMapping("/author/{name}")
    public String getByAuthor(@PathVariable String name) {
        return "Books written by author: " + name;
    }

   
    @PostMapping("/addbook")
    public String addBook(@RequestBody Book book) {
        bookList.add(book);
        return "Book added successfully: " + book.getTitle();
    }

    
    @GetMapping("/viewbooks")
    public List<Book> viewBooks() {
        return bookList;
    }
}