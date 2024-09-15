package com.social_logins.configs;

/*
Author nicksy
 9/15/24
*/

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    //todo: use oauth2Login to tell spring we are using it
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(
                requests -> requests.requestMatchers("/secure").authenticated()
                        .anyRequest().permitAll())
                .formLogin(Customizer.withDefaults())
                .oauth2Login(Customizer.withDefaults());
        return httpSecurity.build();
    }


    //todo: tell spring the type of auth server we are using i.e our own or social logins
    //spring has enum class that can allow social logins i,e CommonOAuth2Provider.class
    // that returns ClientRegistration
    @Bean
    ClientRegistrationRepository clientRegistrationRepository() {
        ClientRegistration github  = githubClientRegistration();
       // ClientRegistration facebook  = facebookClientRegistration();
        return new InMemoryClientRegistrationRepository(github);
    }


    //todo : go to github https://github.com/settings/applications/new to register
    //nb create the ids and secret to under configs
    private ClientRegistration githubClientRegistration() {
        return  CommonOAuth2Provider.GITHUB.getBuilder("github").clientId("Ov23liDpJKvBB2lQqbIg")
                .clientSecret("cfbc0025ac0b68c604b258ca418220c0590bf1ad").build();
    }
    //todo: do the same for facebook go to developers page , remember to allow email scope otherwise it wont work
//    private ClientRegistration facebookClientRegistration() {
//        return CommonOAuth2Provider.FACEBOOK.getBuilder("facebook").clientId("")
//                .clientSecret("").build();
//    }
}
