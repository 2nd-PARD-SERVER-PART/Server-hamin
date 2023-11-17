package protect.pard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import protect.pard.filter.JwtAuthenticationFilter;
import protect.pard.security.TokenProvider;

import java.security.Principal;

@RestController
public class MICController {
    private TokenProvider tokenProvider;
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Autowired
    public MICController(TokenProvider tokenProvider, JwtAuthenticationFilter jwtAuthenticationFilter){
        this.tokenProvider = tokenProvider;
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    @GetMapping("/MIC")
    public String helloMIC(@RequestHeader(value = "Authorization") String token){
        String name = tokenProvider.validate(token.substring(7));
        return name;
    }
}
