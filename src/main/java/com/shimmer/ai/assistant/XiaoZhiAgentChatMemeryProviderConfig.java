package com.shimmer.ai.assistant;

import dev.langchain4j.memory.chat.ChatMemoryProvider;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: XiaoZhiAgentChatMemeryProviderConfig
 * ( ^_^ )
 * @Author: ZT
 * (✿◠‿◠)
 * @Date: 2025/8/22 10:07
 */
@Configuration
public class XiaoZhiAgentChatMemeryProviderConfig {

    @Autowired
    private MongoChatMemoryStore mongoChatMemoryStore;

    //配置chatMemoryProvider
    @Bean
    public ChatMemoryProvider chatMemoryProviderXiaoZhi() {
        return memoryId -> MessageWindowChatMemory
                .builder()
                .id(memoryId)
                .chatMemoryStore(mongoChatMemoryStore) // 使用MongoDB存储聊天记录
                .maxMessages(30) // 设置最大消息数
                .build();
    }
}
