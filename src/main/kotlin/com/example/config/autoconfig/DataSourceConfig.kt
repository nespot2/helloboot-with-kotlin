package com.example.config.autoconfig

import com.example.config.ConditionalMyOnClass
import com.example.config.EnableMyConfigurationProperties
import com.example.config.MyAutoConfiguration
import com.zaxxer.hikari.HikariDataSource
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate
import org.springframework.context.annotation.Bean
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.datasource.SimpleDriverDataSource
import org.springframework.jdbc.support.JdbcTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement
import java.sql.Driver
import javax.sql.DataSource

/**
 * @author nespot2
 **/
@MyAutoConfiguration
@ConditionalMyOnClass("org.springframework.jdbc.core.JdbcOperations")
@EnableMyConfigurationProperties(MyDataSourceProperties::class)
@EnableTransactionManagement
class DataSourceConfig {

    @Bean
    @ConditionalMyOnClass("com.zaxxer.hikari.HikariDataSource")
    fun hikariDataSource(dataSourceProperties: MyDataSourceProperties): DataSource {
        val hikariDataSource = HikariDataSource()
        hikariDataSource.driverClassName = dataSourceProperties.driverClassName
        hikariDataSource.jdbcUrl = dataSourceProperties.url
        hikariDataSource.username = dataSourceProperties.username
        hikariDataSource.password = dataSourceProperties.password
        return hikariDataSource
    }

    @Bean
    @ConditionalOnMissingBean
    fun dataSource(dataSourceProperties: MyDataSourceProperties): DataSource {
        val dataSource = SimpleDriverDataSource()
        dataSource.setDriverClass(Class.forName(dataSourceProperties.driverClassName) as Class<out Driver>)
        dataSource.url = dataSourceProperties.url
        dataSource.username = dataSourceProperties.username
        dataSource.password = dataSourceProperties.password
        return dataSource
    }

    @Bean
    @ConditionalOnSingleCandidate(DataSource::class)
    @ConditionalOnMissingBean
    fun jdbcTemplate(dataSource: DataSource): JdbcTemplate {
        return JdbcTemplate(dataSource)
    }

    @Bean
    @ConditionalOnSingleCandidate(DataSource::class)
    @ConditionalOnMissingBean
    fun jdbcTransactionManager(dataSource: DataSource): JdbcTransactionManager {
        return JdbcTransactionManager(dataSource)
    }


}