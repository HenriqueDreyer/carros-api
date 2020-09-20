package br.com.dreyer.carrosapi.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping("/userInfo")
    public ResponseEntity<UserDetails> userDetails(@AuthenticationPrincipal UserDetails details) {
        return ResponseEntity.ok(details);
    }
}
