package com.example.market.controller.hasanboy;

import com.example.market.dto.hasanboy.BodyTypesDto;
import com.example.market.dto.hasanboy.ModelsDto;
import com.example.market.model.hasanboy.BodyTypes;
import com.example.market.service.hasanboy.BodyTypesService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/body/types")
public class BodyTypesController {
    private BodyTypesService bodyTypesService;
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody @Valid BodyTypesDto dto){
        boolean result = bodyTypesService.create(dto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Integer id){
        BodyTypesDto result = bodyTypesService.get(id);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody @Valid BodyTypesDto dto){
        boolean result = bodyTypesService.update(id,dto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        boolean result = bodyTypesService.delete(id);
        return ResponseEntity.ok(result);
    }
}
