package com.example.config.autoconfig

import com.example.config.MyConfigurationProperties

/**
 * @author nespot2
 **/
@MyConfigurationProperties(prefix = "data")
data class MyDataSourceProperties(
    var driverClassName: String,
    var url: String,
    var username: String,
    var password: String,
)