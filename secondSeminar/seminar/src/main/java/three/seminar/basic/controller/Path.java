package three.seminar.basic.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import three.seminar.basic.dto.HelloDto;

import java.util.function.DoubleConsumer;

@Slf4j
@RestController
public class Path {
    @GetMapping("mapping/{userId}")
    public String mappingPath0(@PathVariable String userId){
        log.info("mapping userId = {}",userId);
        return "userId = "+userId;
    }

    @GetMapping("mapping/users/{userId}/age/{age}")
    public String mappingPath1(@PathVariable String userId, @PathVariable(required = false) Integer age){
        log.info("mapping userId = {}, age = {}",userId, age);
        return "userId = "+userId + ", age = "+ age;
    }

    @GetMapping("requestParam/users")
    public String mappingPath2(@RequestParam(defaultValue = "hamin") String name, @RequestParam(required = false) Integer age){
        log.info("RequestParam name = {}, age = {}", name, age);
        return "name = " + name + ", age = "+age;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("requestBody")
    public String requestBody(@RequestBody HelloDto helloDto){
        log.info("RequestBody name = {}, age = {}",helloDto.getUserName(), helloDto.getAge());
        return "name = "+helloDto.getUserName()+", age = "+helloDto.getAge();
    }
}



