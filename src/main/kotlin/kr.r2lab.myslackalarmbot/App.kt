package kr.r2lab.myslackalarmbot

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.scheduling.TaskScheduler
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler
import org.springframework.web.client.RestTemplate

@SpringBootApplication
@EnableScheduling
open class App {

    @Bean
    open fun restTemplate() = RestTemplate()

    @Bean
    open fun taskScheduler(): TaskScheduler {
        val scheduler = ThreadPoolTaskScheduler()
        scheduler.poolSize = 10
        return scheduler
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(App::class.java, *args)
}