package com.social_logins.Controller;

/*
Author nicksy
 9/15/24
*/

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecureController {

    @GetMapping("secure")
    public String secure(Authentication authentication) {
        //todo: judge if authentication is due to normal username and password login
        if (authentication instanceof UsernamePasswordAuthenticationToken authenticationToken) {
            System.out.println(authenticationToken);
        } else if (authentication instanceof OAuth2AccessToken oauth2AccessToken) {
            System.out.println(oauth2AccessToken);
        }
        return "secure.html";
    }
}
