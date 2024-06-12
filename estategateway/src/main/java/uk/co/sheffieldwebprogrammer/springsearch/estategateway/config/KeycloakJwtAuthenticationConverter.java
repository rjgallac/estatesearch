package uk.co.sheffieldwebprogrammer.springsearch.estategateway.config;


import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.*;
import java.util.stream.Stream;

import static java.util.Collections.emptySet;
import static java.util.stream.Collectors.toSet;

@Component
public class KeycloakJwtAuthenticationConverter implements Converter<Jwt, Mono<? extends AbstractAuthenticationToken>>{

    private List<String> clientIds = Arrays.asList("roles");



    @Override
    public Mono<? extends AbstractAuthenticationToken>  convert(Jwt source)
    {
        JwtAuthenticationToken jwtAuthenticationToken = new JwtAuthenticationToken(source, Stream.concat(new JwtGrantedAuthoritiesConverter().convert(source)
                        .stream(), extractResourceRoles(source).stream())
                .collect(toSet()));
        return Mono.just(jwtAuthenticationToken);
    }

    private Collection<? extends GrantedAuthority> extractResourceRoles(Jwt jwt)
    {
        var resourceAccess = new HashMap<>(jwt.getClaim("realm_access"));
        var resourceRoles = new ArrayList<>();

        clientIds.stream().forEach(id ->
        {
            if (resourceAccess.containsKey(id))
            {
                var resource = (List<String>) resourceAccess.get(id);
                resource.forEach(role -> resourceRoles.add(role));
            }
        });
        Collection<? extends GrantedAuthority> grantedAuthorities = resourceRoles.isEmpty() ? emptySet() : resourceRoles.stream().map(r -> new SimpleGrantedAuthority("ROLE_" + r)).collect(toSet());
        return grantedAuthorities;
    }

}
