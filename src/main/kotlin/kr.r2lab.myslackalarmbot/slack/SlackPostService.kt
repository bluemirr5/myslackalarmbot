package kr.r2lab.myslackalarmbot.slack

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

/**
 * Created by gyeshinwon on 2016. 10. 29..
 *
 */
@Service
class SlackPostService
@Autowired
constructor(
        val restTemplate: RestTemplate
)
{
    val url = "https://hooks.slack.com/services/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"

    fun hello(): String {
        return "hello"
    }

    fun sendMessage(message: SlackPostDTO): Boolean {
        val response = try {
            restTemplate.postForEntity(message.webhookUrl, message.toSlackPost(), String::class.java)
        } catch (e: Exception) {
            println(e)
            null
        }
        return response != null && response.statusCode == HttpStatus.OK &&
                response.body == "ok"
    }
}