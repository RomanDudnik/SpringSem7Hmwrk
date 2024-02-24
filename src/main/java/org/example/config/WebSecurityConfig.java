package org.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


/**
 * Конфигурация Spring Security
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * Метод настройки правил доступа
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Настройка правил доступа к ресурсам
        http.authorizeRequests()
                    .antMatchers("/private-data").hasRole("ADMIN") // /private-data доступен только для админов
                    .antMatchers("/public-data").authenticated() // /public-data доступен для всех аутентифицированных пользователей
                .and()
                    .formLogin() // Включение формы входа
                .and()
                    .logout() // Включение выхода из системы
                    .logoutSuccessUrl("/login"); // Перенаправление на форму входа после выхода
    }

    /**
     * Метод добавления пользователей
     * @param auth
     * @throws Exception
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // Настройка пользователей в памяти
        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}password").roles("USER") // Пользователь user с паролем password и ролью USER
                .and()
                .withUser("admin").password("{noop}password").roles("ADMIN"); // Пользователь admin с паролем password и ролью ADMIN
    }

}
