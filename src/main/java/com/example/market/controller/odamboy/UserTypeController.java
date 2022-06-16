package com.example.market.controller.odamboy;

import com.example.market.dto.odamboy.UserTypeDto;
import com.example.market.service.odamboy.UserTypeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user_type")
public class UserTypeController{
        @Autowired
        private UserTypeService userTypeService;

        @GetMapping("/{id}")
        public HttpEntity<?> get(@PathVariable("id") Integer id){
                UserTypeDto result = userTypeService.get(id);
                return ResponseEntity.ok().body(result);
        }

        @PostMapping()
        public HttpEntity<?> create(@RequestBody UserTypeDto userTypeDto){
                userTypeService.create(userTypeDto);
                return ResponseEntity.ok().build();
        }

        @PutMapping("/{id}")
        public HttpEntity<?> update(@PathVariable("id") Integer id,
                                    @RequestBody UserTypeDto userTypeDto){
                UserTypeDto result = userTypeService.update(id,userTypeDto);
                return ResponseEntity.ok().build();
        }

        @DeleteMapping("/{id}")
        public HttpEntity<?> delete(@PathVariable("id") Integer id){
                userTypeService.delete(id);
                return ResponseEntity.ok().build();
        }

        @GetMapping("/getAll")
        public HttpEntity<?> getAll(){
                List<UserTypeDto> result = userTypeService.getAll();
                return ResponseEntity.ok().body(result);
        }

}
