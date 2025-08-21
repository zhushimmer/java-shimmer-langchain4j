package shimmer.ai.langchain4j;

import com.shimmer.ai.langchain4j.Assistant;
import com.shimmer.ai.MedicalAssistantApplication;
import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.service.AiServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @description: AiServiceTest
 * ( ^_^ )
 * @Author: ZT
 * (✿◠‿◠)
 * @Date: 2025/8/11 10:58
 */
@SpringBootTest(classes = MedicalAssistantApplication.class)
public class AiServiceTest {

    @Autowired
    private QwenChatModel qwenChatModel;

    @Autowired
    private Assistant assistant;

    @Test
    public void test() {
        Assistant assistant = AiServices.create(Assistant.class,qwenChatModel);
        String response = assistant.chat("推荐高能量播客");
        System.out.println(response);
    }

    @Test
    public void testAiservice() {
        String response = assistant.chat("推荐高能量播客,并简要介绍每个播客的内容,中国的播客");
        System.out.println(response);
    }



}
