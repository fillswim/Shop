package com.fillswim.shop.Service;

import com.fillswim.shop.DAO.GoodRepository;
import com.fillswim.shop.Entity.Good;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GoodServiceImpl implements GoodService {

    private final GoodRepository goodRepository;

    public GoodServiceImpl(GoodRepository goodRepository) {
        this.goodRepository = goodRepository;
    }

    @Override
    @Transactional
    public List<Good> getAllGoods() {
        return goodRepository.findAll();
    }

    @Override
    @Transactional
    public Good getGood(int id) {

        Good good = null;
        Optional<Good> optionalGood = goodRepository.findById(id);

        if (optionalGood.isPresent()) {
            good = optionalGood.get();
        }

        return good;
    }

    @Override
    @Transactional
    public void saveGood(Good good) {
        goodRepository.save(good);

    }

    @Override
    @Transactional
    public void deleteGood(int id) {
        goodRepository.deleteById(id);
    }
}
