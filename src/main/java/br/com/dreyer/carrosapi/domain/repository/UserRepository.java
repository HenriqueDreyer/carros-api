package br.com.dreyer.carrosapi.domain.repository;

import br.com.dreyer.carrosapi.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByLogin(String login);
}
