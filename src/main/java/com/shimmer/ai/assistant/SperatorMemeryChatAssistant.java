package com.shimmer.ai.assistant;

import dev.langchain4j.agent.tool.Tool;
import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
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
                chatMemoryProvider = "chatMemoryProvider",
                tools = "calculatorTools" // 使用的工具类,注入bean首字母小写
        )
public interface SperatorMemeryChatAssistant {
    //分离聊天记录
//    @SystemMessage("你是我的好朋友，请用北京话回答问题。今天是{{current_date}}}")//系统消息提示词
    @SystemMessage(fromResource = "my_promot_file.txt")  // 系统消息提示词用法2
    String chat(@MemoryId int memoryId, @UserMessage String userMessage);


    //强制参数名称，多个参数必须用V来指定
    @UserMessage("你是我的好朋友，请用上海话回答问题，并且添加一些表情符号。 {{m}}") //提示词用法1，{{it}}表示这里唯一的参数的占位符
    String chat2(@MemoryId int memoryId,@V("m") String message) ;


    //强制参数名称，多个参数必须用V来指定
    @SystemMessage(fromResource = "my_promot_template.txt") //提示词用法2) //提示词用法1，{{it}}表示这里唯一的参数的占位符
    String chat3(@MemoryId int memoryId,
                 @UserMessage String message,
                 @V("username") String username,
                @V("age")String age) ;

}
