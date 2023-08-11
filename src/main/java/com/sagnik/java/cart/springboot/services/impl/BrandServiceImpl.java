package com.sagnik.java.cart.springboot.services.impl;

import com.sagnik.java.cart.springboot.dtos.BrandDTO;
import com.sagnik.java.cart.springboot.exception.ApiException;
import com.sagnik.java.cart.springboot.models.Brand;
import com.sagnik.java.cart.springboot.repositories.BrandRepository;
import com.sagnik.java.cart.springboot.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public Brand save(Brand model) {
        return brandRepository.save(model);
    }

    @Override
    public Brand getById(Long id) {
        return brandRepository.findById(id).orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "Brand not found"+id));
    }

    @Override
    public Brand update(Long brandId, BrandDTO dto) {
        Brand brand = getById(brandId);
        brand.setName(dto.getName());
        return brandRepository.save(brand);
    }

    @Override
    public void delete(Long brandId) {
        Brand brand = getById(brandId);
        brand.setActive(false);
        brandRepository.save(brand);
    }
}
