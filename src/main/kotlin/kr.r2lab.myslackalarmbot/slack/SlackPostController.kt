package kr.r2lab.myslackalarmbot.slack

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

/**
 * Created by gyeshinwon on 2016. 10. 29..
 *
 */
@RestController
class SlackPostController
@Autowired constructor(
    val slackPostService: SlackPostService
)
{
    @RequestMapping(value = "/hello", method = arrayOf())
    fun hello() : String {
        return slackPostService.hello()
    }

    @RequestMapping(value = "/sendSlackMessage", method = arrayOf(RequestMethod.POST))
    fun sendMessage(@RequestBody message: SlackPostDTO) =
    if(message.sendDate == null)
        slackPostService.sendMessage(message)
    else
        slackPostService.sendScheduledMessage(message)
}