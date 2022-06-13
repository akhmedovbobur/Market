package com.example.market.controller.asadbek;

import com.example.market.dto.asadbek.ApplicationsTypeDto;
import com.example.market.service.asadbek.ApplicationsTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/applicationsType")
public class ApplicationsTypeController {
        private ApplicationsTypeService applicationsTypeService;

        @PutMapping("/create")
    public ResponseEntity<?> create (@RequestBody @Valid ApplicationsTypeDto applicationsTypeDto){
            Boolean result = applicationsTypeService.create(applicationsTypeDto);
            return ResponseEntity.ok(result);
        }

        @GetMapping("/{id}")
    public ResponseEntity<?> get (@PathVariable("id") Integer id){
            ApplicationsTypeDto result = applicationsTypeService.get(id);
            return ResponseEntity.ok(result);
        }

        @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable ("id") Integer id,
                                    @RequestBody @Valid ApplicationsTypeDto applicationsTypeDto){
            Boolean result = applicationsTypeService.update(id,applicationsTypeDto);
            return ResponseEntity.ok(result);
        }

        @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable("id") Integer id){
            Boolean result = applicationsTypeService.delete(id);
            return ResponseEntity.ok(result);
        }
}
