package com.gerenciamento.loja.gerenciamento_loja.security.jwt;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.stream.Collectors;

@Service
public class JwtService {
    private final JwtEncoder jwtEncoder;

    public JwtService(JwtEncoder jwtEncoder){
        this.jwtEncoder = jwtEncoder;
    }

    public String gerarToken(Authentication authentication) {

        Instant instant = Instant.now();
        long expiracao = 3600L;

        String scopes = authentication.getAuthorities().stream()
                .map(grantedAuthority -> grantedAuthority.getAuthority())
                .collect(Collectors.joining(" "));

        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("gerenciamento_loja")
                .issuedAt(instant)
                .expiresAt(instant.plusSeconds(expiracao))
                .subject(authentication.getName())
                .claim("scope", scopes)
                .build();

        return this.jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }
}
