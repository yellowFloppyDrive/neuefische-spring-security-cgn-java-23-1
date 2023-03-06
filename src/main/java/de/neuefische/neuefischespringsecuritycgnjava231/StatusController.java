package de.neuefische.neuefischespringsecuritycgnjava231;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/status")
public class StatusController {
    @GetMapping
    public String getStatus() {
        return "OK";
    }
}
