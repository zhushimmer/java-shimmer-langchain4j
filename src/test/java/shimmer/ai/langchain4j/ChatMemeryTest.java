package shimmer.ai.langchain4j;

import com.shimmer.ai.MedicalAssistantApplication;
import com.shimmer.ai.langchain4j.Assistant;
import com.shimmer.ai.assistant.MemeryChatAssistant;
import com.shimmer.ai.assistant.SperatorMemeryChatAssistant;
import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.response.ChatResponse;
import dev.langchain4j.service.AiServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

/**
 * @description: ChatMemeryTest
 * ( ^_^ )
 * @Author: ZT
 * (✿◠‿◠)
 * @Date: 2025/8/11 14:24
 */
@SpringBootTest(classes = MedicalAssistantApplication.class)
public class ChatMemeryTest {

    @Autowired
    private QwenChatModel qwenChatModel;
    @Test
    public void testChatMemeryUseMessage() {
        UserMessage userMessage1 = UserMessage.userMessage("我是一名java开发程序员");
        ChatResponse chatResponse=  qwenChatModel.chat(userMessage1);
        AiMessage aiMessage =chatResponse.aiMessage();
        System.out.println(aiMessage.text());


        UserMessage userMessage2 = UserMessage.userMessage("我的职业是什么");
        ChatResponse chatResponse2=  qwenChatModel.chat(Arrays.asList(userMessage1,aiMessage,userMessage2));
        AiMessage aiMessage2 =chatResponse2.aiMessage();
        System.out.println(aiMessage2.text());
    }
//    使用AIService可以封装多轮对话的复杂性，使聊天记忆功能的实现变得简单
    @Test
    public void testChatMemeryUseAiservice() {
        //创建chatmemery
        MessageWindowChatMemory messageWindowChatMemory =   MessageWindowChatMemory.withMaxMessages(10);
        //创建AiService
        Assistant assistant = AiServices
                .builder(Assistant.class)
                .chatModel(qwenChatModel)
                .chatMemory(messageWindowChatMemory)
                .build();

        String response = assistant.chat("我是一名java开发程序员");
        System.out.println(response);
        String response2 = assistant.chat("我的职业是什么");
        System.out.println(response2);
    }
    //智能体自动调用
    @Autowired
    private MemeryChatAssistant memeryChatAssistant;
    @Test
    public void testChatMemeryUseAiservice2() {
        String response = memeryChatAssistant.chat("我是小燃");
        System.out.println(response);
        String response2 = memeryChatAssistant.chat("我是谁");
        System.out.println(response2);
    }


    //分对话智能体处理

    @Autowired
    private SperatorMemeryChatAssistant speratorMemeryChatAssistant;
    @Test
    public void testChatMemeryUseAiservice3() {
        String response = speratorMemeryChatAssistant.chat(1,"我是一名java开发程序员");
        System.out.println(response);
        String response2 = speratorMemeryChatAssistant.chat(1,"我的职业是什么");
        System.out.println(response2);
        String response3 = speratorMemeryChatAssistant.chat(2,"我的职业是什么");
        System.out.println(response3);
    }
}

