package name.nkonev.spring.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private UserAccountRepository userAccountRepository;

    @GetMapping
    public String hello() {
        return "Hello native world";
    }

    @GetMapping("/user")
    public Iterable<UserAccount> getUsers() {
        return userAccountRepository.findAll();
    }
}
