package com.example.market.controller.asadbek;

import com.example.market.dto.asadbek.ApplicationsDto;
import com.example.market.model.asadbek.Applications;
import com.example.market.service.asadbek.ApplicationsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/v1/applications")
@AllArgsConstructor
public class ApplicationsController {
        private ApplicationsService applicationsService;

        @PutMapping("/create")
            public ResponseEntity<?> create(@RequestBody @Valid ApplicationsDto applicationsDto){
            Boolean result = applicationsService.create(applicationsDto);
            return ResponseEntity.ok(result);
        }


        @GetMapping("/{id}")
            public ResponseEntity<?> get (@PathVariable("id") Integer id){
            ApplicationsDto result = applicationsService.get(id);
            return ResponseEntity.ok(result);
        }

        @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable ("id") Integer id,
                                    @RequestBody @Valid ApplicationsDto applicationsDto){
            Boolean result = applicationsService.update(id,applicationsDto);
            return ResponseEntity.ok(result);
        }

        @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable("id") Integer id){
            Boolean result = applicationsService.delete(id);
            return ResponseEntity.ok(result);
        }

}
