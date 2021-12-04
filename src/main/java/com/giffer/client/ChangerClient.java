package com.giffer.client;

import com.giffer.model.ChangerModel;

public interface ChangerClient {
    ChangerModel getLatestCourse(String base, String appId);
}
