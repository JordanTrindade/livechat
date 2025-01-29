package com.livechat.controller;

import com.livechat.domain.ChatInput;
import com.livechat.domain.ChatOutput;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller //controller nao rest
public class LiveChatController {
    @MessageMapping("/new-message") //recebe a messagem nesse endpoint
    @SendTo("/topics/livechat") //envia a mensagem para o topico do broker
    public ChatOutput newMessage(ChatInput chatInput){
        return new ChatOutput(HtmlUtils.htmlEscape( chatInput.userName() + " : " + chatInput.message()));
    }
}
