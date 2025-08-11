package com.shimmer.ai.assistant;

import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.ChatMemoryProvider;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.store.memory.chat.InMemoryChatMemoryStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: ChatMemoryProviderConfig
 * ( ^_^ )
 * @Author: ZT
 * (✿◠‿◠)
 * @Date: 2025/8/11 15:52
 */
@Configuration
public class ChatMemoryProviderConfig {

    @Bean
    ChatMemoryProvider chatMemoryProvider() {
        return memeryid-> MessageWindowChatMemory
                .builder()
                .id(memeryid)
                .maxMessages(10)
        // 使用内存流式聊天模型,两种InMemoryChatMemeryStore和SingleSlotChatMemoryStore（默认不需要配置）
                .chatMemoryStore(new InMemoryChatMemoryStore())
                .build();
    }
}
