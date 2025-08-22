package shimmer.ai.langchain4j;

import com.shimmer.ai.MedicalAssistantApplication;
import com.shimmer.ai.assistant.SperatorMemeryChatAssistant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = MedicalAssistantApplication.class)
public class ToolsTest {

    @Autowired
    private SperatorMemeryChatAssistant speratorMemeryChatAssistant;

    @Test
    public void testCalculatorTools() {
        String answer = speratorMemeryChatAssistant.chat(100, "1+2等于几，475695037565的平方根是多少？");
//答案：3，689706.4865
        System.out.println(answer);
    }
}