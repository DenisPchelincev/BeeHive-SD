package ru.beehive.sd

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@EnableEurekaClient
@SpringBootApplication
class SCSDEEurekaClient {

    fun main(args: Array<String>) {
        SpringApplication.run(SCSDEEurekaClient::class.java, *args)
    }
}
