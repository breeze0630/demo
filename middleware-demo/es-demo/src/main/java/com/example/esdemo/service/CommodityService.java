package com.example.esdemo.service;

import com.example.esdemo.dto.Commodity;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CommodityService {

    long count();

    Commodity save(Commodity commodity);

    void delete(Commodity commodity);

    void deleteAll();

    Iterable<Commodity> getAll();

    List<Commodity> getByName(String name);

    Page<Commodity> pageQuery(Integer pageNo, Integer pageSize, String kw);


}
