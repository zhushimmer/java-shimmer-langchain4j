package com.shimmer.ai.assistant;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;

/**
 * @description: 对话隔离智能体
 * ( ^_^ )
 * @Author: zt
 * (✿◠‿◠)
 * @Date: 2025/8/11 15:47
 */
@AiService
        (
                wiringMode = AiServiceWiringMode.EXPLICIT, // 手动装配指定 chatModel
                chatModel = "openAiChatModel",
                chatMemoryProvider = "chatMemoryProvider"
        )
public interface SperatorMemeryChatAssistant {
        //分离聊天记录
    String chat(@MemoryId  int memoryId, @UserMessage  String userMessage) ;
}
