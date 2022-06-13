package com.example.market.controller.azamat;

import com.example.market.dto.azamat.MerchantsDto;
import com.example.market.service.azamat.MerchantsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/merchants")
@AllArgsConstructor
public class MerchantsController {
    private final MerchantsService merchantsService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody @Valid MerchantsDto merchantsDto) {
        boolean result = merchantsService.create(merchantsDto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Integer id) {
        MerchantsDto result = merchantsService.get(id);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id,
                                    @RequestBody @Valid MerchantsDto merchantsDto) {
        boolean result = merchantsService.update(id, merchantsDto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        boolean result = merchantsService.delete(id);
        return ResponseEntity.ok(result);
    }

}
