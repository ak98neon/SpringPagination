package com.learn.Pagination.domain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Artem Kudria
 */
@Controller
@RequestMapping(value = "/")
public class MainPage {

    @GetMapping
    public String mainPage() {
        return "index";
    }
}
