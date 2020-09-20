package br.com.dreyer.carrosapi.api.controller;

import br.com.dreyer.carrosapi.domain.model.Carro;
import br.com.dreyer.carrosapi.domain.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/carros")
public class CarroController {

    @Autowired
    private CarroService service;

    @GetMapping
    public ResponseEntity<List<Carro>> findAll() {
        List<Carro> body = service.findAll();

        if (body.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(body);
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<Carro>> findByTipo(@PathVariable("tipo") String tipo) {
        List<Carro> body = service.findByTipo(tipo);

        if (body.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(body);
    }

    @PostMapping
    @Secured({"ROLE_ADMIN"})
    public ResponseEntity<Carro> save(@RequestBody Carro carro) {
        Carro body = service.save(carro);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(body.getId()).toUri();
        
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    @Secured({"ROLE_ADMIN"})
    public ResponseEntity<Carro> update(@PathVariable Long id, @RequestBody Carro carro) {
        Carro target = service.update(id, carro);
        return ResponseEntity.ok(target);
    }

    @DeleteMapping("{id}")
    @Secured({"ROLE_ADMIN"})
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
