package com.example.market.controller.hasanboy;

import com.example.market.service.hasanboy.BrandsService;
import com.example.market.dto.hasanboy.BrandsDto;
import com.example.market.dto.hasanboy.ModelsDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/brands")
public class BrandsController {
    private BrandsService brandsService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody @Valid BrandsDto dto){
        boolean result = brandsService.create(dto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Integer id){
        BrandsDto result = brandsService.get(id);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody @Valid BrandsDto dto){
        boolean result = brandsService.update(id,dto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        boolean result = brandsService.delete(id);
        return ResponseEntity.ok(result);
    }
}
