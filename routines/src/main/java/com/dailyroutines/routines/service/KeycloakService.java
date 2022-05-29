package com.dailyroutines.routines.service;
import java.security.Principal;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class KeycloakService {
    
    public String getKeycloakUserId(){
        KeycloakAuthenticationToken authenticationToken = (KeycloakAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Principal principal = (Principal) authenticationToken.getPrincipal();
        KeycloakPrincipal kPrincipal = (KeycloakPrincipal) principal;
        String userId = kPrincipal.getKeycloakSecurityContext().getToken().getSubject();
        return userId;
    }

}
