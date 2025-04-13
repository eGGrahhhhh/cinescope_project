package com.cinescope.api;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config.properties"})
public interface ProjectConfig extends Config {

    String baseApiUrl();
    String locale();
    boolean logging();
}
