package com.giffer.service;

import java.util.List;
import java.util.Map;

public interface InterfaceChanger {
    List<String> getListKeyCurrency();

    Map<String, Double> getLatest();

    Map<String, Double> getOneValue(String key);


}