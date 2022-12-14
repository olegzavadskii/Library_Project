package com.tms.controller;

import com.tms.model.Book;
import com.tms.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "/admin")
public class ShowOverdueBooksController {
    @Value(value = "${page-size}")
    private int pageSize;

    @Autowired
    private BookService bookService;

    @GetMapping(path = "/show_overdue_books")
    public String overdueBooks(@RequestParam(defaultValue = "0") Integer page,
                               Model model) {
        Page<Book> pages = bookService.findOverdueBooks(PageRequest.of(page, pageSize));
        model.addAttribute("totalPages", pages.getTotalPages());
        model.addAttribute("books", pages.getContent());
        return "overdue-books";
    }

}
