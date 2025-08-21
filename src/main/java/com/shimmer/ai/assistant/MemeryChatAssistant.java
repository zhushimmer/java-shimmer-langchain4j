package com.shimmer.ai.assistant;

import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
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

//    @UserMessage("你是我的好朋友，请用上海话回答问题，并且添加一些表情符号。 {{it}}") //提示词用法1，{{it}}表示这里唯一的参数的占位符
//    String chat(String message) ;

    //强制参数名称
    @UserMessage("你是我的好朋友，请用上海话回答问题，并且添加一些表情符号。 {{m}}") //提示词用法1，{{it}}表示这里唯一的参数的占位符
    String chat(@V("m") String message) ;

    //强制参数名称，多个参数必须用V来指定
    @UserMessage("你是我的好朋友，请用上海话回答问题，并且添加一些表情符号。 {{m}}") //提示词用法1，{{it}}表示这里唯一的参数的占位符
    String chat2(@V("m") String message) ;
}
