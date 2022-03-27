package com.fillswim.shop;

import com.fillswim.shop.DAO.GoodRepository;
import com.fillswim.shop.Entity.Good;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
/*
public class RestAPITests {

    private final RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private GoodRepository repository;

    private final String URL = "http://localhost:8080/api/goods";

    @Test
    @Order(1)
    public void testGoodExistsInRepository() {

        int id = 1;

        // Load good from repository
        Good goodFromRepository = repository.findById(id).orElse(null);

        assertNotNull(goodFromRepository);
    }

    // Find good by id      GET     http://localhost:8080/api/goods{goodId}
    @Test
    @Order(2)
    public void testGetGood() {
        int id = 1;

        // Load good with GET request
        Good goodFromTemplate = restTemplate.getForObject(URL + "/" + id, Good.class);
        System.out.println("goodFromTemplate: " + "\t" + goodFromTemplate);

        // Load good from repository
        Good goodFromRepository = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id + " not found"));
        System.out.println("goodFromRepository " + "\t" + goodFromRepository);

        assertEquals(goodFromRepository, goodFromTemplate);
    }

    // Show all goods       GET     http://localhost:8080/api/goods
    @Test
    @Order(3)
    public void testGetAllGoods() {

        // Load list of goods with GET request
        ResponseEntity<List<Good>> responseEntity =
                restTemplate.exchange(URL, HttpMethod.GET, null,
                        new ParameterizedTypeReference<>() {});

        List<Good> goodsFromTemplate = responseEntity.getBody();
        System.out.println(goodsFromTemplate);

        // Load list of goods from repository
        List<Good> goodsFromRepository = repository.findAll();
        System.out.println(goodsFromRepository);

        assertEquals(goodsFromRepository, goodsFromTemplate);
    }

    // Add good             POST    http://localhost:8080/api/goods
    @Test
    @Order(4)
    public void testAddNewGood() {

        int id = 4;
        String title = "Nintendo switch";

        // New good
        Good good = new Good();
        good.setTitle(title);
        good.setPrice(399);
        good.setProducerCountry("USA");

        // Save new good
        ResponseEntity<String> responseEntity =
                restTemplate.postForEntity(URL, good, String.class);
        System.out.println("New good was added to DB: " + responseEntity.getBody());

        assertEquals(title,
                repository
                        .findById(id)
                        .orElseThrow(() -> new EntityNotFoundException(id + " not found"))
                        .getTitle());
    }

    // Update good          PUT     http://localhost:8080/api/goods
    @Test
    @Order(5)
    public void testUpdateGood() {

        int id = 3;
        int newPrice = 1900;

        // Load
        Good good = restTemplate.getForObject(URL + "/" + id, Good.class);
        if (good != null) {
            good.setPrice(newPrice);

            // Update
            restTemplate.put(URL, good);
        } else {
            throw new EntityNotFoundException(id + " not found");
        }

        assertEquals(newPrice,
                repository
                        .findById(id)
                        .orElseThrow(() -> new EntityNotFoundException(id + " not found"))
                        .getPrice());

    }

    // Delete good          DELETE  http://localhost:8080/api/goods{goodId}
    @Test
    @Order(6)
    public void testDeleteGood() {

        int id = 3;

        restTemplate.delete(URL + "/" + id);
        System.out.println("Good with id = " + id + " was deleted");

        assertNull(repository.findById(id).orElse(null));
    }





}
*/
