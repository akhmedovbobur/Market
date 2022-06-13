package com.example.market.controller.asadbek;

import com.example.market.dto.asadbek.ProcessStarusesDto;
import com.example.market.service.asadbek.ProcessStatusesService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/processStatuses")
@AllArgsConstructor
public class ProcessStatusesController {
    private ProcessStatusesService processStatusesService;

    @PutMapping("/create")
    public ResponseEntity<?> create (@RequestBody @Valid ProcessStarusesDto processStarusesDto){
        Boolean result = processStatusesService.create(processStarusesDto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get (@PathVariable("id") Integer id){
        ProcessStarusesDto result = processStatusesService.get(id);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable ("id") Integer id,
                                    @RequestBody @Valid ProcessStarusesDto processStarusesDto){
        Boolean result = processStatusesService.update(id,processStarusesDto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable ("id") Integer id){
        Boolean result = processStatusesService.delete(id);
        return ResponseEntity.ok(result);
    }
 }
