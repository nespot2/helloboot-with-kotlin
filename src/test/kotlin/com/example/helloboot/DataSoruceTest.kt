package com.example.helloboot

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import javax.sql.DataSource

/**
 * @author nespot2
 **/
@HellobootTest
class DataSoruceTest @Autowired constructor(
    private val dataSource: DataSource
) {

    @Test
    fun `test dataSource`() {
        val connection = dataSource.connection
        connection.close()
    }
}