package com.shimmer.ai.assistant;

import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;

/**
 * @description: MemeryChatAssistant
 * ( ^_^ )
 * @Author: ZT
 * (✿◠‿◠)
 * @Date: 2025/8/11 15:39
 */
@AiService(
        wiringMode = AiServiceWiringMode.EXPLICIT, // 手动装配指定 chatModel
        chatModel = "openAiChatModel",
        chatMemory = "chatMemory"
)
public interface MemeryChatAssistant {
    String chat(String message) ;
}
