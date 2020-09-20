package br.com.dreyer.carrosapi.domain.service;

import br.com.dreyer.carrosapi.domain.exceptions.ObjectNotFoundException;
import br.com.dreyer.carrosapi.domain.model.Carro;
import br.com.dreyer.carrosapi.domain.repository.CarroRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {

    @Autowired
    private CarroRepository repository;

    public List<Carro> findAll() {
        return repository.findAll();
    }

    public Carro findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id, Carro.class.getSimpleName()));
    }

    public List<Carro> findByTipo(String tipo) {
        return repository.findByTipo(tipo);
    }

    public Carro save(Carro carro) {
        return repository.save(carro);
    }

    public Carro update(Long id, Carro carro) {
        Carro target = findById(id);
        BeanUtils.copyProperties(carro, target, "id");

        return repository.save(target);
    }

    public void delete(Long id) {
        Carro target = findById(id);
        repository.delete(target);
    }
}
