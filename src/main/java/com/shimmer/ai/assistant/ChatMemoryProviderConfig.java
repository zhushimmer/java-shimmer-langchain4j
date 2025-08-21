package com.shimmer.ai.assistant;

import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.ChatMemoryProvider;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.store.memory.chat.InMemoryChatMemoryStore;
import org.springframework.beans.factory.annotation.Autowired;
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
/**
 * 标识配置类：告诉 Spring 容器该类包含 Bean 的定义。
 * 替代 XML 配置：可以用 Java 代码代替传统的 XML 配置文件。
 * 与 @Bean 配合使用：在配置类中，使用 @Bean 注解的方法会返回一个 Bean，并将其注册到 Spring 容器中。
 */
public class ChatMemoryProviderConfig {

    @Autowired
    private MongoChatMemoryStore mongoChatMemoryStore;

    @Bean
    ChatMemoryProvider chatMemoryProvider() {
        return memeryid-> MessageWindowChatMemory
                .builder()
                .id(memeryid)
                .maxMessages(10)
        // 使用内存流式聊天模型,两种InMemoryChatMemeryStore和SingleSlotChatMemoryStore（默认不需要配置）
//                .chatMemoryStore(new InMemoryChatMemoryStore())
                // 使用自定义的MongoDB存储模型
                .chatMemoryStore(mongoChatMemoryStore)
                .build();
    }
}
