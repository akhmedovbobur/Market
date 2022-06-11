package com.example.market.controller.odamboy;

import com.example.market.dto.odamboy.UserDto;
import com.example.market.service.odamboy.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody @Valid UserDto userDto){
        boolean result = userService.create(userDto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?>ger(@PathVariable("id")Integer id){
        UserDto result =userService.get(id);
        return ResponseEntity.ok(result);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id,
                                    @RequestBody @Valid UserDto userDto){
        boolean result = userService.update(id, userDto);
        return ResponseEntity.ok(result);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        boolean result = userService.delete(id);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/admin/list")
    public ResponseEntity<?> getAllForAdmin(@RequestParam("s") Integer size,
                                            @RequestParam("p") Integer page){
        List<UserDto> result = userService.getAllForAdmin(size,page);
        return ResponseEntity.ok(result);
    }

    @PatchMapping("/create-admin/{id}")
    public ResponseEntity<?> changeUserToAdmin(@PathVariable("id") Integer id){
        boolean result = userService.changeUserToAdmin(id);
        return ResponseEntity.ok(result);
    }
}
