/**
 * Created by gyeshinwon on 2016. 11. 7..
 *
 */
var babel = require('babel');
var react = require('react');
var reactDOM = require('reactDOM');
var common = require('common.js');


$(document).ready(function() {
    $(function () {
        $('#webhookPopoverId').popover({
            container: 'body'
        });
        $('#webhookPopoverId2').popover({
            container: 'body'
        });
    });

    var clicked = 'normal';
    $('#myTabs a').click(function (e) {
        e.preventDefault();
        $(this).tab('show');
        clicked = e.currentTarget.id;
    });

    $('#sendBtn').click(function (e) {
        clickSendBtn();
    });
    function clickSendBtn() {
        var offset = new Date().getTimezoneOffset();
        var radio = $(':radio[name="inlineRadioOptions"]:checked').val();
        var radioBool = radio == "Y";

        var orgVal = $("#sendTime").val();
        var temp = Date.parse(orgVal);

        var d = new Date(temp + offset*60*1000);

        var obj = {
            webhookUrl : $("#webhookUrl").val(),
            username : $("#username").val(),
            channel : $("#channel").val(),
            sendDate: d,
            mrkdwn :  radioBool
        };

        var url = '';
        if(clicked == 'attachments-tab') {
            url = "/sendSlackMessageAttachment";
            var attachment = {
                fallback: $('#fallback').val(),
                color: $('#color').val(),
                pretext: $('#pretext').val(),
                author_name: $('#author_name').val(),
                author_link: $('#author_link').val(),
                author_icon: $('#author_icon').val(),
                title: $('#title').val(),
                title_link: $('#title_link').val(),
                text: $('#text').val(),
                image_url: $('#image_url').val(),
                thumb_url: $('#thumb_url').val(),
                footer: $('#footer').val(),
                footer_icon: $('#footer_icon').val()
            };

            obj.attachments = [];
            obj.attachments.push(attachment);

            obj.validate = function() {
                return obj.webhookUrl && obj.channel
                    && attachment.pretext
                    && attachment.title
                    && attachment.text;
            }
        } else {
            url = "/sendSlackMessage";
            obj.text = $("#message").val();
            obj.validate = function() {
                return obj.webhookUrl && obj.channel && obj.text;
            }
        }

        if(obj.validate()) {
            jQuery.ajax({
                type:"POST",
                url: url,
                contentType: "application/json; charset=UTF-8",
                data: JSON.stringify(obj),
                success : function(data) {
                    alert("메시지 전송완료");
                    $("#message").val('')
                },
                complete : function(data) {
                },
                error : function(xhr, status, error) {
                    alert("메시지 전송실패 : " + status);
                }
            });
        } else {
            alert("need Data");
        }
    }
});