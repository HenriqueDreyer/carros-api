package br.com.dreyer.carrosapi;

import br.com.dreyer.carrosapi.domain.model.Carro;
import br.com.dreyer.carrosapi.domain.service.CarroService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CarroServiceTests {

    @Autowired
    CarroService service;

    @Test
    public void insertTest() {
        Carro target = carroBuilder();
        Carro saved = service.save(target);

        Assertions.assertNotNull(saved, "Salvo com sucesso");
    }

    @Test
    public void findBtTipo() {
        List<Carro> carros = service.findByTipo("classicos");
        boolean isFull = carros.size() > 0 ? true : false;

        Assertions.assertTrue(isFull);
    }

    @Test

    private Carro carroBuilder() {
        Carro carro = new Carro();
        carro.setNome("Fusca JUnit Test");
        carro.setDescricao("Fusca 1999");
        carro.setTipo("Classicos");
        carro.setUrl_foto("https://d176s39pnpenan.cloudfront.net/wp-content/uploads/2020/01/81808751_2361560757283257_6708030242453192704_n-1.jpg");

        return carro;
    }
}
