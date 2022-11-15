package ru.futsey.springcourse.config.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {

    /**
     * В методе GET ожидаем имя пользователя (синтаксис .../hello?name=Somename) посредством использования
     * тяжелого класса, способного получить всю информацию о запросе
     * @see HttpServletRequest
     * @param request
     * @return view
    @GetMapping("/hello")
    public String helloPage(HttpServletRequest request) {
    String name = request.getParameter("name");
        System.out.println("Hello " + name);
        return "first/hello";
    }
     */

    /**
     * В методе GET ожидаем только имя пользователя посредством аннотации @RequestParam
     * Дополнительно явно определяем параметр required
     * во избежание ошибки 400 (в данном случае по умолчанию поле name == null)
     * @param name
     * @return view
     */
    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name) {
        System.out.println("Hello " + name);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodBye";

    }
}
