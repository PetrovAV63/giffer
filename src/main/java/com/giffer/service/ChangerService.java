package com.giffer.service;

import com.giffer.client.ChangerClient;
import com.giffer.client.FeignChangerClient;
import com.giffer.model.ChangerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ChangerService {
    @Value("${changer.token}")
    private String token;


    FeignChangerClient changerClient;

    @Autowired
    public ChangerService(FeignChangerClient changerClient) {
        this.changerClient = changerClient;
    }


    public ChangerModel getLatestCourse(String base) {
        return changerClient.getLatestCourse(base, this.token);
    }
}
