package com.example.config.autoconfig

import com.example.config.MyConfigurationProperties

/**
 * @author nespot2
 **/
@MyConfigurationProperties(prefix = "server")
data class ServerProperties(
    var contextPath: String,
    var port: Int
)