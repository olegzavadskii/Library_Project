package com.tms.controller;

import com.tms.model.BookAudit;
import com.tms.service.BookAuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "/admin")
public class AdminBookAuditController {
    @Value(value = "${page-size}")
    private int pageSize;
    @Autowired
    private BookAuditService bookAuditService;

    @GetMapping(path = "/show_issue_history")
    public String showAllBooksAudit(@RequestParam(defaultValue = "0") Integer page,
                                    Model model) {
        Page<BookAudit> pages = bookAuditService.findAllBookAudit(PageRequest.of(page, pageSize));
        model.addAttribute("totalPages", pages.getTotalPages());
        model.addAttribute("booksAudit", pages.getContent());
        return "issue-history-for-admin";
    }

    @GetMapping(path = "/show_issue_history/{id}")
    public String showBooksAuditByUserId(@PathVariable(name = "id") Integer userId,
                                         @RequestParam(defaultValue = "0") Integer page,
                                         Model model) {
        Page<BookAudit> pages = bookAuditService.findBookAuditByUserId(userId, PageRequest.of(page, pageSize));
        model.addAttribute("totalPages", pages.getTotalPages());
        model.addAttribute("booksAudit", pages.getContent());
        return "issue-history-by-user-id";
    }

}
