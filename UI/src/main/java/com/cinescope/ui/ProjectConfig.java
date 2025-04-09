package com.cinescope.ui;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config.properties"})
public interface ProjectConfig extends Config {

    String remote();
    String baseUrl();
    String baseApiUrl();
    String locale();
}
