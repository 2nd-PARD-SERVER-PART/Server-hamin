package three.seminar.depping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import three.seminar.depping.repository.UserRepository;
import three.seminar.depping.user.User;

import java.util.List;

@RestController
@RequestMapping("/user")
public class Controller {
    private final UserRepository userRepository;
    @Autowired
    public Controller(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @PostMapping("/add")
    public String userAdd(@RequestParam Integer stuNum, @RequestParam String stuName){
        User user = new User();
        user.setStuNum(stuNum);
        user.setStuName(stuName);
        userRepository.save(user);
        return "version 1";
    }

    @PostMapping("/add/{stuNum}/{stuName}")
    public String userAdd2(@PathVariable Integer stuNum, @PathVariable String stuName){
        User user = new User();

        user.setStuNum(stuNum);
        user.setStuName(stuName);
        userRepository.save(user);
        return "version 2";
    }

    @PostMapping("/add3")
    public String userAdd3(@RequestBody User user){
        userRepository.save(user);
        return "version 3";
    }

    @GetMapping("/findAll")
    public List<User> userFind(){
        List<User> hguStudent = userRepository.findAll();
        return hguStudent;
    }

    @GetMapping("/findOne/{stuNum}")
    public User userFindOne(@PathVariable Integer stuNum){
        User user = userRepository.findById(stuNum);
        return user;
    }

    @PatchMapping("/update/{stuNum}")
    public String userUpdate(@PathVariable Integer stuNum, @RequestBody User user){
        userRepository.update(stuNum, user);
        return "change success";
    }

    @DeleteMapping("/delete/{stuNum}")
    public String userDelete(@PathVariable Integer stuNum){
        userRepository.delete(stuNum);
        return "delete success";
    }
}
