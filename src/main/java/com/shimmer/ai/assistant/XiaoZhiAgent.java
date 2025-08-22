package com.shimmer.ai.assistant;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;

/**
 * @description: XiaoZhiAgent
 * ( ^_^ )
 * @Author: ZT
 * (✿◠‿◠)
 * @Date: 2025/8/21 17:20
 */

/**
 * 注入的是chatMemoryProvider就需要@Bean注入ChatMemoryProvider类
 * 如果注入的是chatMemory就需要@Bean注入ChatMemory类
 */
@AiService(
        wiringMode = AiServiceWiringMode.EXPLICIT,
        chatModel = "qwenChatModel",
        chatMemoryProvider = "chatMemoryProviderXiaoZhi"
)
//创建Agent-chat方法；创建memery_provider；创建提示词文件
public interface XiaoZhiAgent {

    @SystemMessage(fromResource = "my_prompt_templatexiaozhi.txt") // 系统消息提示词用法
    String  chat(@MemoryId Long memoryId, @UserMessage String message);
}
