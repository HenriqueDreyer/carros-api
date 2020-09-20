package br.com.dreyer.carrosapi;

import br.com.dreyer.carrosapi.domain.model.Carro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SpringBootTest(classes = CarrosApiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CarrosApiApplicationTests {
}
