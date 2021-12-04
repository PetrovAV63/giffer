package com.giffer.client;

import com.giffer.model.ChangerFallBack;
import com.giffer.model.ChangerModel;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "changerClient", url = "${changer.url}", fallback = ChangerFallBack.class)
public interface FeignChangerClient extends ChangerClient {
    @Override
    @GetMapping("/latest.json?base={base}")
    ChangerModel getLatestCourse(@Param("base") String base, @RequestParam("app_id") String appId);
}
