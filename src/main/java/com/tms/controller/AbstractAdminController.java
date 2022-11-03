package com.tms.controller;

import com.tms.service.BookService;
import com.tms.service.GeneralService;
import com.tms.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public abstract class AbstractAdminController {
    protected static final Integer SIZE_OF_PAGE = 10;
    protected final UserService userService;
    protected final BookService bookService;
    protected final GeneralService generalService;

    public AbstractAdminController(UserService userService, BookService bookService, GeneralService generalService) {
        this.userService = userService;
        this.bookService = bookService;
        this.generalService = generalService;
    }

    protected void findOnlyActiveUsers(Model model) {
        model.addAttribute("allUsers", userService.findAllNotDeletedUsers());
    }

}
