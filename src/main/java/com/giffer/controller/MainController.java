package com.giffer.controller;

import com.giffer.service.InterfaceChanger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping("/gifs")
@RestController
public class MainController {

    private final InterfaceChanger changer;

    public MainController(InterfaceChanger changer) {
        this.changer = changer;
    }

    @GetMapping
    public List<String> getKeysCurrency() {
        return changer.getListKeyCurrency();
    }

    @GetMapping("/{key}")
    public Map<String, Double> getOneValue(@PathVariable String key) {
        return changer.getOneValue(key);
    }

    @GetMapping("/latest")
    public Map<String, Double> getLatest() {
        return changer.getLatest();
    }

}
