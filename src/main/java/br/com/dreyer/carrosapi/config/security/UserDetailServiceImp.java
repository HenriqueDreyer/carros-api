package br.com.dreyer.carrosapi.config.security;

import br.com.dreyer.carrosapi.domain.model.User;
import br.com.dreyer.carrosapi.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service(value = "userDetailService")
public class UserDetailServiceImp implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByLogin(username);

        if(user == null){
            throw  new UsernameNotFoundException("Usuário Inválido");
        }

        return user;

    }
}
