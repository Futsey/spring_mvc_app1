package ru.futsey.springcourse.config.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value="name", required = false) String name, Model model) {
        model.addAttribute("message", "Hello, " + name);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodBye";
    }

    @GetMapping("/calculator")
    public String helloPage(@RequestParam(value="a", required = false) int a,
                            @RequestParam(value="b", required = false) int b,
                            @RequestParam(value="action", required = false) String action, Model model) {
        double rsl = 0D;
        switch (action) {
            case "multiplication":
                rsl = a * b;
                break;
            case "addition":
                rsl = a + b;
                break;
            case "substruction":
                rsl = a - b;
                break;
            case "division":
                rsl = a / (double) b;
                break;
        }
        model.addAttribute("result", rsl);
        return "first/calculator";
    }
}
