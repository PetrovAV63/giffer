package com.giffer.client;

import com.giffer.model.ChangerModel;

public interface ChangerClient {
    ChangerModel getLatestCourse(String appId);

    ChangerModel getHistoricalCourse(String data, String appId);
}
