package com.sagnik.java.cart.springboot.controllers;

import com.sagnik.java.cart.springboot.dtos.BrandDTO;
import com.sagnik.java.cart.springboot.dtos.BrandResponseDTO;
import com.sagnik.java.cart.springboot.mappers.BrandMapper;
import com.sagnik.java.cart.springboot.models.Brand;
import com.sagnik.java.cart.springboot.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.logging.Logger;

@RestController// Indicates that this class serves as a RESTful controller that handles incoming HTTP requests and produces HTTP responses.
@RequestMapping("/brands")//Specifies the base path for all the endpoints defined in this controller.
public class BrandController {
    @Autowired// Automatically injects an instance of BrandService, a service class that deals with business logic related to the "brands" resource.
    private BrandService brandService;

    private static final Logger log = Logger.getLogger(BrandController.class.getName());// Creates a Logger instance named log for logging messages related to this class.

    @PostMapping
    public ResponseEntity<?> save(@RequestBody BrandDTO dto) {
        Brand brand = BrandMapper.toBrand(dto);
        brand = brandService.save(brand);
        return ResponseEntity.ok(BrandMapper.toBrandResponseDTO(brand));
    }

    @GetMapping("{myId}")
    public ResponseEntity<BrandResponseDTO> getOneById(@PathVariable("myId") Long id){
        Brand brand = brandService.getById(id);
        return ResponseEntity.ok(BrandMapper.toBrandResponseDTO(brand));
    }

    @PutMapping("{brandId}")
    public ResponseEntity<?> updateById(@PathVariable Long brandId, @RequestBody BrandDTO dto) {
        log.info("Update brand with id = {}");

        Brand brand = brandService.update(brandId, dto);
        return ResponseEntity.ok(BrandMapper.toBrandResponseDTO(brand));
    }

    @DeleteMapping("{brandId}")
    public ResponseEntity<?> deleteById(@PathVariable Long brandId){
        log.info("Delete brand with id = {}");
        brandService.delete(brandId);
        //return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        return ResponseEntity.noContent().build();
    }
}
