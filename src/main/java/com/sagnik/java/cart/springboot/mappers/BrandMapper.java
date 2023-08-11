package com.sagnik.java.cart.springboot.mappers;

import com.sagnik.java.cart.springboot.dtos.BrandDTO;
import com.sagnik.java.cart.springboot.dtos.BrandResponseDTO;
import com.sagnik.java.cart.springboot.models.Brand;

public class BrandMapper {
    public static Brand toBrand(BrandDTO dto) {
        Brand brand=new Brand();
        brand.setActive(true);
        brand.setName(dto.getName());
        return brand;
    }

    public static BrandResponseDTO toBrandResponseDTO(Brand entity) {
        BrandResponseDTO dto=new BrandResponseDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }
}
