package com.fillswim.shop.Service;

import com.fillswim.shop.Entity.Good;

import java.util.List;

public interface GoodService {

    public List<Good> getAllGoods();

    public Good getGood(int id);

    public void saveGood(Good good);

    public void deleteGood(int id);

}
