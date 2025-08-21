package com.shimmer.ai.assistant;

import dev.langchain4j.memory.chat.ChatMemoryProvider;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * @description: ChatMemoryProviderXiaoZhiConfig
 * ( ^_^ )
 * @Author: ZT
 * (✿◠‿◠)
 * @Date: 2025/8/21 17:25
 */
@Configuration
public class ChatMemoryProviderXiaoZhiConfig {

    @Autowired
    private MongoChatMemoryStore mongoChatMemoryStore;

    /**
     * 创建一个聊天记忆提供者，使用MongoDB存储聊天记忆。
     * @return ChatMemoryProvider
     */
    public ChatMemoryProvider chatMemoryProviderXiaoZhi() {
        return memeryid -> MessageWindowChatMemory
                .builder()
                .id(memeryid)
                .maxMessages(20)
                // 使用自定义的MongoDB存储模型
                .chatMemoryStore(mongoChatMemoryStore)
                .build();
    }
}
