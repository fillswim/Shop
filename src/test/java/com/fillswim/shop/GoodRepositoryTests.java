package com.fillswim.shop;

import com.fillswim.shop.Controller.RESTController;
import com.fillswim.shop.DAO.GoodRepository;
import com.fillswim.shop.Entity.Good;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

//@ActiveProfiles("test")
//@SpringBootTest
//@Transactional
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//public class GoodRepositoryTests {
//
//    @Autowired
//    private RESTController restController;
//    @Autowired
//    private GoodRepository repository;
//
//    @Test
//    public void contextLoads() {
//        assertThat(restController).isNotNull();
//    }
//
//    @Test
//    @Order(1)
//    public void testCreate() {
//
//        int id = 4;
//
//        Good good = new Good();
//        good.setTitle("Iphone");
//        good.setPrice(2000);
//        good.setProducerCountry("USA");
//
//        repository.save(good);
//
//        assertEquals("Iphone",
//                repository
//                        .findById(id)
//                        .orElseThrow(() -> new EntityNotFoundException(id + " not found"))
//                        .getTitle());
//    }
//
//    @Test
//    @Order(2)
//    public void testReadAll() {
//        List<Good> goods = repository.findAll();
//        assertThat(goods).size().isGreaterThan(0);
//    }
//
//    @Test
//    @Order(3)
//    public void testSimpleGood() {
//
//        int id = 1;
//
//        Good good = repository
//                .findById(id)
//                .orElseThrow(() -> new EntityNotFoundException(id + " not found"));
//
//        assertEquals(299, good.getPrice());
//    }
//
//    @Test
//    @Order(4)
//    public void testUpdate() {
//
//        int id = 1;
//
//        Good good = repository
//                .findById(id)
//                .orElseThrow(() -> new EntityNotFoundException(id + " not found"));
//
//        good.setPrice(500);
//        repository.save(good);
//
//        assertEquals(500,
//                repository
//                        .findById(id)
//                        .orElseThrow(() -> new EntityNotFoundException(id + " not found"))
//                        .getPrice());
//    }
//
//    @Test
//    @Order(5)
//    public void testDelete() {
//
//        int id = 4;
//
//        repository.deleteById(id);
//        assertThat(repository.existsById(id)).isFalse();
//    }
//
//
//}
