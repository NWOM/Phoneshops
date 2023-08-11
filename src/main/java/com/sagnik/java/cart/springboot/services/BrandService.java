package com.sagnik.java.cart.springboot.services;

import com.sagnik.java.cart.springboot.dtos.BrandDTO;
import com.sagnik.java.cart.springboot.models.Brand;

public interface BrandService {
    Brand save(Brand brand);

    Brand getById(Long id);

    Brand update(Long brandId, BrandDTO dto);

    void delete(Long brandId);
}
