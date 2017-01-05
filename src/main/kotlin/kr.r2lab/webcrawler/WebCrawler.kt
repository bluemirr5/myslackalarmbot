package kr.r2lab.webcrawler

import org.jsoup.Jsoup
import org.springframework.stereotype.Service

/**
 * Created by gyeshinwon on 2016. 11. 19..
 *
 */
@Service
class WebCrawler {
    fun crawlingTextLink(url: String, keyword: String) {
        val doc = Jsoup.connect(url).get()

//        println(doc?.body()?.toString())

        val pairList = doc?.body()?.allElements?.filter {
            val text = it.ownText()
            text.contains(keyword)
        }?.map {
            val text = it.ownText()
            val link = if(it.nodeName() == "a") {
                it.attr("href")
            } else {
                val parents = it?.parents()
                val filtered = parents?.filter {  it.nodeName() == "a" }
                if(filtered != null && filtered.isNotEmpty()) {
                    filtered.first().attr("href")
                } else {
                    ""
                }
            }
            if(!link.isNullOrBlank()) {
                println(text + ":" +link)
            }
            Pair<String, String>(link, text)
        }

        val resultList = pairList?.filter { it.first.isEmpty() }
        resultList?.forEach { println(it.first + ":" + it.second) }

//        doc?.body()?.allElements?.forEach {
//
//            val text = it.ownText()
//            if(text.contains(keyword)) {
//                val link = if(it.nodeName() == "a") {
//                    it.attr("href")
//                } else {
//                    val parents = it?.parents()
//                    val filtered = parents?.filter {  it.nodeName() == "a" }
//                    if(filtered != null && filtered.isNotEmpty()) {
//                        filtered.first()?.attr("href")
//                    } else {
//                        ""
//                    }
//                }
//                if(!link.isNullOrBlank()) {
//                    println(text + ":" +link)
//                }
//            }
//        }

//        val aList = doc?.body()?.select("a")
//        aList?.forEach { println(it.toString()) }
    }
}

fun main(args: Array<String>) {
    val cl = WebCrawler()
    cl.crawlingTextLink("http://m.naver.com", "대통령")
}