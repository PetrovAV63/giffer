package com.giffer.controller;

import com.giffer.client.ChangerClient;
import com.giffer.model.ChangerFallBack;
import com.giffer.model.ChangerModel;
import com.giffer.service.ChangerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/gifs")
@RestController
@RequiredArgsConstructor
public class MainController {

    private final ChangerService service;



    @GetMapping
    public void getGif() {
        ChangerModel model = service.getLatestCourse("USD");
         String s = model.getDisclaimer();
        System.out.println(s);
    }



}
