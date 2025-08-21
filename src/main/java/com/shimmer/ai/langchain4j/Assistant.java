package com.shimmer.ai.langchain4j;

import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @description: AIServiceAssistant
 * ( ^_^ )
 * @Author: ZT
 * (✿◠‿◠)
 * @Date: 2025/8/11 10:57
 */
@AiService(
        wiringMode = AiServiceWiringMode.EXPLICIT, // 手动装配指定 chatModel
        chatModel = "openAiChatModel"
)
@Service
@Component
public interface Assistant {

    String chat(String userMessage);
}