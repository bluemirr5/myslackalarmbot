package kr.r2lab.myslackalarmbot.slack

import java.util.*

/**
 * Created by gyeshinwon on 2016. 10. 29..
 *
 */
data class NormalSlackPost(
    val username: String = "",
    val mrkdwn: Boolean = true,
    val channel: String = "#general",
    val text: String
)

data class AttachmentSlackPost(
    val username: String = "",
    val mrkdwn: Boolean = true,
    val channel: String = "#general",
    val attachments: List<Attachment>
)


data class Attachment(
    val fallback: String = "",
    val color: String = "",
    val pretext: String = "",
    val author_name: String = "",
    val author_link: String = "",
    val author_icon: String = "",
    val title: String = "",
    val title_link: String = "",
    val text: String = "",
    val image_url: String = "",
    val thumb_url: String = "",
    val footer: String = "",
    val footer_icon: String = "",
    val ts: Long = -1,
    val fields: List<AttachmentSlackPostField>  = listOf()
)

data class AttachmentSlackPostField(
    val title: String,
    val value: String,
    val short: Boolean
)

class NormalSlackPostDTO(
    var webhookUrl: String = "",
    var username: String = "",
    var mrkdwn: Boolean = true,
    var channel: String = "#general",
    var text: String = "",
    var sendDate: Date? = null
){
    fun toSlackPost() = NormalSlackPost(username, mrkdwn, channel, text)
}

data class AttachmentSlackPostDTO(
    var webhookUrl: String = "",
    var username: String = "",
    var mrkdwn: Boolean = true,
    var channel: String = "#general",
    var sendDate: Date? = null,
    val attachments: List<Attachment> = listOf()
){
    fun toSlackPost() = AttachmentSlackPost(username, mrkdwn, channel, attachments)
}