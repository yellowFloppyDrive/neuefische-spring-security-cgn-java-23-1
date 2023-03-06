package de.neuefische.neuefischespringsecuritycgnjava231;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cars")
public class CarController {
    @GetMapping
    public String[] getCars() {
        return new String[]{"BMW", "Mercedes", "Audi"};
    }
}
