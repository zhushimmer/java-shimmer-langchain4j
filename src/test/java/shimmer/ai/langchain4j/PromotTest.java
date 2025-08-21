package shimmer.ai.langchain4j;

import com.shimmer.ai.MedicalAssistantApplication;
import com.shimmer.ai.assistant.SperatorMemeryChatAssistant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @description: PromotTest
 * ( ^_^ )
 * @Author: ZT
 * (✿◠‿◠)
 * @Date: 2025/8/21 16:37
 */
@SpringBootTest(classes = MedicalAssistantApplication.class)
public class PromotTest {

    @Autowired
    private SperatorMemeryChatAssistant speratorMemeryChatAssistant;


    @Test
    public void testPromot() {
        // 测试分离聊天记录的智能体
        String response = speratorMemeryChatAssistant.chat(5, "我是谁");
        System.out.println("Response: " + response);


        String response2 = speratorMemeryChatAssistant.chat(5, "我是小燃");
        System.out.println("Response2: " + response2);

    }

    @Test
    public void testPromot2() {
        // 测试分离聊天记录的智能体
        String response = speratorMemeryChatAssistant.chat2(6, "我是谁");
        System.out.println("Response: " + response);


        String response2 = speratorMemeryChatAssistant.chat2(6, "我是小燃");
        System.out.println("Response2: " + response2);

    }

    @Test
    public void testPromot3() {
        // 测试分离聊天记录的智能体
        String response = speratorMemeryChatAssistant.chat3(1, "我今年多大","小明","18");
        System.out.println("Response: " + response);
    }

}
