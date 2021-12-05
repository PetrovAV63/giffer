package com.giffer.service;

import com.giffer.client.ChangerClient;
import com.giffer.client.FeignChangerClient;
import com.giffer.model.ChangerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ChangerService implements InterfaceChanger {
    @Value("${changer.token}")
    private String token;

    private ChangerModel historicalModel;
    private ChangerModel latestModel;

    ChangerClient changerClient;

    @Autowired
    public ChangerService(FeignChangerClient changerClient) {
        this.changerClient = changerClient;
    }

    @PostConstruct
    private void InitMethod() {
        initHistoricalCurrency();
        initLatestCurrency();
    }

    @Override
    public List<String> getListKeyCurrency() {
        return new ArrayList<>(this.historicalModel.getRates().keySet());
    }

    @Override
    public Map<String, Boolean> getCurrenciesChange() {
        return this.historicalModel.getRates()
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue() <
                        (this.latestModel.getRates().values().iterator().next())));
    }

    @Scheduled(cron = "@daily")
    private void initHistoricalCurrency() {
        String data = LocalDate.now().minusDays(1).toString();
        this.historicalModel = changerClient.getHistoricalCourse(data, this.token);
    }

    @Scheduled(cron = "@hourly")
    private void initLatestCurrency() {
        this.latestModel = changerClient.getLatestCourse(this.token);
    }
}
