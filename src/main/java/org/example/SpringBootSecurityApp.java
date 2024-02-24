package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootSecurityApp {

    /**
     * Внимание ДЗ выполнять в версии SpringBoot:2.7.14(модули security и web)
     * Вам необходимо создать Spring Boot приложение, которое управляет доступом к ресурсам в зависимости
     * от роли пользователя. У вас должно быть два типа пользователей: USER и ADMIN.
     * 1. Создайте ресурс /private-data, доступный только для аутентифицированных пользователей с ролью ADMIN.
     * 2. Создайте ресурс /public-data, доступный для всех аутентифицированных пользователей независимо от их роли.
     * 3. Реализуйте форму входа для аутентификации пользователей с использованием стандартных средств Spring Security.
     * 4. Если неаутентифицированный пользователь пытается получить доступ к /private-data,
     * он должен быть перенаправлен на форму входа.
     * @param args
     */
    public static void main(String[] args) {
        // Запускаем приложение
        SpringApplication.run(SpringBootSecurityApp.class, args);
    }
}