package three.seminar.basic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogTestController {
    @RequestMapping("/log-test")
    public String logTest(){
        String name = "Hamin";
        System.out.println("name = "+name);
        log.info("info log = {}", name);
        log.trace("info log = {}", name);
        log.debug("info log = {}", name);
        log.warn("info log = {}", name);
        log.error("info log = {}", name);
        log.info("info log = ", name);
        return name;
    }
}
