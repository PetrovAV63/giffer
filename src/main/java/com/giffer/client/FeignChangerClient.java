package com.giffer.client;

import com.giffer.model.ChangerFallBack;
import com.giffer.model.ChangerModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "changerClient", url = "${changer.url}", fallback = ChangerFallBack.class)
public interface FeignChangerClient extends ChangerClient {
    @Override
    @GetMapping("/latest.json?base=${changer.base}")
    ChangerModel getLatestCourse(@RequestParam("app_id") String appId);

    @Override
    @GetMapping("/historical/{data}.json?base=${changer.base}")
    ChangerModel getHistoricalCourse(@PathVariable("data") String data, @RequestParam("app_id") String appId);
}
