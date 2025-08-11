package com.shimmer.ai.assistant;

import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: MemoryChatAssistantConfig
 * ( ^_^ )
 * @Author: ZT
 * (✿◠‿◠)
 * @Date: 2025/8/11 15:41
 */
@Configuration
public class MemoryChatAssistantConfig {

    @Bean
    ChatMemory chatMemory() {
        // 创建一个消息窗口聊天记忆，最大消息数为10
        return MessageWindowChatMemory.withMaxMessages(10);
    }
}
