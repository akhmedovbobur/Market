package com.example.market.controller.odamboy;

import com.example.market.dto.odamboy.UserDto;
import com.example.market.service.odamboy.UserService;
import com.example.market.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public HttpEntity<?> get(@PathVariable("id") Integer id) {
        UserDto result = userService.get(id);
        return ResponseEntity.ok().body(
              Response.builder()
                        .timeStep(LocalDateTime.now())
                        .data(Map.of("user", result))
                        .message("User retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @PostMapping()
    public HttpEntity<?> create(@RequestBody UserDto user) {
        UserDto result = userService.create(user);
        return ResponseEntity.ok().body(
             Response.builder()
                        .timeStep(LocalDateTime.now())
                        .data(Map.of("user", result))
                        .message("User creaetd")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @PutMapping("/{id}")
    public HttpEntity<?> update(@PathVariable("id") Integer id,
                                @RequestBody UserDto userDto) {
        UserDto result = userService.update(id, userDto);
        return ResponseEntity.ok().body(
                Response.builder()
                        .timeStep(LocalDateTime.now())
                        .data(Map.of("user", result))
                        .message("User updated")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable("id") Integer id) {
        Boolean result = userService.delete(id);
        return ResponseEntity.ok().body(
                Response.builder()
                        .timeStep(LocalDateTime.now())
                        .data(Map.of("user", result))
                        .message("User deleted")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @GetMapping("/all")
    public HttpEntity<?> getAll(){
        List<UserDto> userDtoList = userService.getAll();
        return ResponseEntity.ok().body(
                Response.builder()
                        .timeStep(LocalDateTime.now())
                        .data(Map.of("users", userDtoList))
                        .message("User retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }
}
