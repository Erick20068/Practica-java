package com.example.login.controller;

import com.example.login.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginViewController {

    @Autowired
    private UsuarioService usuarioService;

   
    @GetMapping("/")
    public String showLoginPage() {
        return "login"; 
    }

    @PostMapping("/login-view")
    public String login(@RequestParam("username") String username, 
                        @RequestParam("password") String password, 
                        Model model) {
        
        boolean isAuthenticated = usuarioService.login(username, password);

        if (isAuthenticated) {
            model.addAttribute("success", "¡Inicio de sesión exitoso! Bienvenido al Sistema.");
        } else {
            model.addAttribute("error", "Usuario o contraseña incorrectos.");
        }

        return "login"; 
    }
}