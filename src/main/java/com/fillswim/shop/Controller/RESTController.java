package com.fillswim.shop.Controller;

import com.fillswim.shop.Entity.Good;
import com.fillswim.shop.Service.GoodServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RESTController {

    // Show all goods       GET     http://localhost:8080/api/goods
    // Find good by id      GET     http://localhost:8080/api/goods{goodId}
    // Add good             POST    http://localhost:8080/api/goods
    // Update good          PUT     http://localhost:8080/api/goods
    // Delete good          DELETE  http://localhost:8080/api/goods{goodId}

    private final GoodServiceImpl goodService;

    public RESTController(GoodServiceImpl goodService) {
        this.goodService = goodService;
    }

    // Show all goods       GET     http://localhost:8080/api/goods
    @GetMapping("/goods")
    public List<Good> getAllGoods() {
        return goodService.getAllGoods();
    }

    // Find good by id      GET     http://localhost:8080/api/goods{goodId}
    @GetMapping("/goods/{id}")
    public Good getGood(@PathVariable int id) {
        return goodService.getGood(id);
    }

    // Add good             POST    http://localhost:8080/api/goods
    @PostMapping("/goods")
    public Good addNewGood(@RequestBody Good good) {
        goodService.saveGood(good);
        return good;
    }

    // Update good          PUT     http://localhost:8080/api/goods
    @PutMapping("goods")
    public Good updateGood(@RequestBody Good good) {
        goodService.saveGood(good);
        return good;
    }

    // Delete good          DELETE  http://localhost:8080/api/goods{goodId}
    @DeleteMapping("/goods/{id}")
    public String deleteGood(@PathVariable int id) {

        goodService.deleteGood(id);
        String result = "Good with id = " + id + " was deleted!!";

        return result;
    }



}
