package com.giffer.controller;

import com.giffer.service.InterfaceChanger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
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

    @GetMapping("/test/{key}")
    public ResponseEntity getResult(@PathVariable("key") String key) {
        Map<String, Boolean> resp = new HashMap<>();
        if (changer.getCurrenciesChange().containsKey(key)) {
            resp.put(key, changer.getCurrenciesChange().get(key));
        } else {
            return ResponseEntity.notFound().build();
        }
       return ResponseEntity.ok(resp);
    }

}
