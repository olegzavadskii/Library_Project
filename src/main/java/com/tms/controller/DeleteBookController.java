package com.tms.controller;

import com.tms.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "/admin")
public class DeleteBookController extends AbstractAdminController {
    @Autowired
    private BookService bookService;

    @PostMapping(path = "/delete_book")
    public String delete(@RequestParam Integer bookId,
                         Model model) {
        bookService.deleteBookById(bookId);
        findOnlyActiveUsers(model);
        return "list-of-users-for-admin";
    }

}
