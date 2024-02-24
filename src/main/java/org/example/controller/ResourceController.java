package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Контроллер ресурсов
 */
@Controller
public class ResourceController {

    /**
     * Метод, возвращающий приватные данные
     * @return
     */
    @GetMapping("/private-data")
    //@ResponseBody
    public String getPrivateData() {
        // Возвращаем приватные данные
        return //"This is private data for admins only."
                "admin.html";
    }

    /**
     * Метод, возвращающий публичные данные
     * @return
     */

    @GetMapping("/public-data")
    //@ResponseBody
    public String getPublicData() {
        // Возвращаем публичные данные
        return //"This is public data for all authenticated users."
                "user.html";
    }

    /**
     * Метод, возвращающий форму входа
     * @return
     */
    @GetMapping("/login")
    public String getLogin() {
    	return "login.html";
    }
}
