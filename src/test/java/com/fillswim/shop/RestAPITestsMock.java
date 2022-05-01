package com.fillswim.shop;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fillswim.shop.DAO.GoodRepository;
import com.fillswim.shop.Entity.Good;
import com.google.gson.Gson;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ActiveProfiles("test")
@Transactional
@SpringBootTest
@AutoConfigureMockMvc
public class RestAPITestsMock {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GoodRepository mockRepository;

    @BeforeEach
    public void init() {
        Good good = new Good();
        good.setId(1);
        good.setTitle("Title");
        good.setPrice(100);
        good.setProducerCountry("UK");

        when(mockRepository.findById(1)).thenReturn(Optional.of(good));
    }

    @Test
    public void getAllGoods_200Ok() throws Exception {

        List<Good> goods = Arrays.asList(
                new Good(1, "Title One", 100, "UK"),
                new Good(2, "Title Two", 200, "DE"));

        when(mockRepository.findAll()).thenReturn(goods);

        mockMvc.perform(get("/api/goods"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].title", is("Title One")))
                .andExpect(jsonPath("$[0].price", is(100)))
                .andExpect(jsonPath("$[0].producerCountry", is("UK")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].title", is("Title Two")))
                .andExpect(jsonPath("$[1].price", is(200)))
                .andExpect(jsonPath("$[1].producerCountry", is("DE")));

        verify(mockRepository, times(1)).findAll();
    }

    @Test
    public void getGood_200Ok() throws Exception {

        mockMvc.perform(get("/api/goods/1"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.title", is("Title")))
                .andExpect(jsonPath("$.price", is(100)))
                .andExpect(jsonPath("$.producerCountry", is("UK")));

        verify(mockRepository, times(1)).findById(1);
    }


    @Test
    public void addNewGood_200Ok() throws Exception {

        Good good = new Good(1, "Title", 100, "UK");
        String goodJson = new Gson().toJson(good);

        when(mockRepository.save(any(Good.class))).thenReturn(good);

        mockMvc.perform(post("/api/goods")
                .content(goodJson)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.title", is("Title")))
                .andExpect(jsonPath("$.price", is(100)))
                .andExpect(jsonPath("$.producerCountry", is("UK")));

        verify(mockRepository, times(1)).save(any(Good.class));
    }

    @Test
    public void updateGood_200Ok() throws Exception {

        Good good = new Good(1, "TitleNew", 100, "UK");
        String goodJson = new Gson().toJson(good);

        when(mockRepository.save(any(Good.class))).thenReturn(good);

        mockMvc.perform(put("/api/goods")
                .content(goodJson)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.title", is("TitleNew")))
                .andExpect(jsonPath("$.price", is(100)))
                .andExpect(jsonPath("$.producerCountry", is("UK")));

    }

    @Test
    public void deleteGood_200Ok() throws Exception {

        doNothing().when(mockRepository).deleteById(1);

        mockMvc.perform(delete("/api/goods/1"))
                .andDo(print())
                .andExpect(status().isOk());

        verify(mockRepository, times(1)).deleteById(1);
    }

}
