package br.com.dreyer.carrosapi.domain.repository;

import br.com.dreyer.carrosapi.domain.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {

    public List<Carro> findByTipo(String tipo);
}
