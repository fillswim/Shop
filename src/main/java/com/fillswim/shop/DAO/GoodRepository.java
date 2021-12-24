package com.fillswim.shop.DAO;

import com.fillswim.shop.Entity.Good;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GoodRepository extends JpaRepository<Good, Integer> {

}
