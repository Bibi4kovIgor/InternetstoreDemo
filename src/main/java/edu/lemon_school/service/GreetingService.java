package edu.lemon_school.service;

import edu.lemon_school.model.Greeting;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class GreetingService {

    public static final String MANY_GREETINGS_WITH_NAME = "Many greetings %s. %s!";

    @GetMapping(value = {"", "/", "/{name}"})
    Greeting greeting(@Nullable @PathVariable String name,
                    @RequestParam(value = "greeting", defaultValue = "Bless you!")
                    @Nullable String greeting) {
        return new Greeting(name, String.format(MANY_GREETINGS_WITH_NAME,
                Optional.ofNullable(name).orElse(" "),
                Optional.ofNullable(greeting).orElse(" ")));
    }
}
