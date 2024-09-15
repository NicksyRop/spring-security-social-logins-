package com.social_logins.Controller;

/*
Author nicksy
 9/15/24
*/

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecureController {

    @GetMapping("secure")
    public String secure() {
        return "secure.html";
    }
}
