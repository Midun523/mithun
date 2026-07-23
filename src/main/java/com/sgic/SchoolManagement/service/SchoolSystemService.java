package com.sgic.SchoolManagement.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SchoolSystemService {
    @Value("${app.name}")
    private String appName;
    @Value("${app.version}")
    private String appVersion;

    public String getAppInfo(){
        return "App Name: " + appName + "App Version: " + appVersion;
    }

}

