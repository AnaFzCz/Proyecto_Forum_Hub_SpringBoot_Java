package com.forumhub.ForumHub.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @GetMapping
    public String primeroProyecto() {
        return "vamos Ana!!!!";
    }

    @PostMapping
    public void cadastrar(@RequestBody String json) {
        System.out.printf(json);
    }

}
