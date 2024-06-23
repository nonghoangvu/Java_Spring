package com.vunh.controller;

import com.vunh.model.ChatCompletionRequest;
import com.vunh.model.ChatCompletionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class ChatController {
    @Value("${openai.key}")
    private String key;

    @Autowired
    RestTemplate restTemplate;

    @PostMapping("/get-started")
    String getStarted(@RequestBody String prompt) {
        System.out.println(this.key);
        ChatCompletionRequest chatCompletionRequest = new ChatCompletionRequest("gpt-3.5-turbo-16k", prompt);
        ChatCompletionResponse response = restTemplate.postForObject("https://api.openai.com/v1/chat/completions",
                chatCompletionRequest, ChatCompletionResponse.class);
        return response.getChoices().get(0).getMessage().getContent();

    }

}
