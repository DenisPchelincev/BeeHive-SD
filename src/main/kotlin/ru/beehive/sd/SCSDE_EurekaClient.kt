package ru.beehive.sd

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@EnableEurekaClient
@SpringBootApplication
class SCSDE_EurekaClient {

    fun main(args: Array<String>) {
        SpringApplication.run(SCSDE_EurekaClient::class.java, *args)
    }
}
