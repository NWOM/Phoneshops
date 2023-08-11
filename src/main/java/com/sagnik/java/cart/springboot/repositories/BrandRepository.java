package com.sagnik.java.cart.springboot.repositories;

import com.sagnik.java.cart.springboot.models.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}
