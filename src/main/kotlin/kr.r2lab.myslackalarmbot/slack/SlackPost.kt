package kr.r2lab.myslackalarmbot.slack

/**
 * Created by gyeshinwon on 2016. 10. 29..
 *
 */
data class SlackPost(
    val username: String = "",
    val mrkdwn: Boolean = true,
    val channel: String = "#general",
    val text: String
)

class SlackPostDTO {
    var webhookUrl: String = ""
    var username: String = ""
    var mrkdwn: Boolean = true
    var channel: String = "#general"
    var text: String = ""
    fun toSlackPost() = SlackPost(username, mrkdwn, channel, text)
}