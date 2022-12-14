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
public class AdminController extends AbstractAdminController {
    @Value(value = "${page-size}")
    private int pageSize;
    @Autowired
    private BookService bookService;

    @GetMapping()
    public String showAllUsers(Model model) {
        findOnlyActiveUsers(model);
        return "list-of-users-for-admin";
    }

    @GetMapping(path = "/show_all_books")
    public String showAllBooks(@RequestParam(defaultValue = "0") Integer page,
                               Model model) {
        Page<Book> pages = bookService.findAllNotDeletedBooks(PageRequest.of(page, pageSize));
        model.addAttribute("totalPages", pages.getTotalPages());
        model.addAttribute("books", pages.getContent());
        return "list-of-books-for-admin";
    }

}
