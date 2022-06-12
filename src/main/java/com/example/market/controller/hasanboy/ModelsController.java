package com.example.market.controller.hasanboy;

import com.example.market.dto.hasanboy.ModelsDto;
import com.example.market.service.hasanboy.ModelsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/models")
public class ModelsController {
    private ModelsService modelsService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody @Valid ModelsDto dto){
        boolean result = modelsService.create(dto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Integer id){
        ModelsDto result = modelsService.get(id);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody @Valid ModelsDto dto){
        boolean result = modelsService.update(id,dto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        boolean result = modelsService.delete(id);
        return ResponseEntity.ok(result);
    }
}
