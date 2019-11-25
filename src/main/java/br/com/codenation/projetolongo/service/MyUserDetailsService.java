package br.com.codenation.projetolongo.service;

import br.com.codenation.projetolongo.domain.entity.Usuario;
import br.com.codenation.projetolongo.service.interfaces.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        Usuario usuario = usuarioService.findByUserName(s);
        if (usuario == null) {
            throw new UsernameNotFoundException("Not found");
        }
        return new UserRepositoryDetails(usuario);
    }

    private final static class UserRepositoryDetails extends Usuario implements UserDetails {
        private UserRepositoryDetails(Usuario usuario) {
            super(usuario);
        }


        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return null;
        }

        @Override
        public String getPassword() {
            return this.getPassword();
        }

        @Override
        public String getUsername() {
            return this.getUsername();
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
    }
}
