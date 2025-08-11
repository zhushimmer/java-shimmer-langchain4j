package shimmer.ai.langchain4j;

import com.shimmer.ai.MedicalAssistantApplication;
import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.community.model.dashscope.WanxImageModel;
import dev.langchain4j.data.image.Image;
import dev.langchain4j.model.ollama.OllamaChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.output.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @description: LLMDemoTest
 * ( ^_^ )
 * @Author: ZT
 * (✿◠‿◠)
 * @Date: 2025/8/8 9:45
 */
@SpringBootTest(classes = MedicalAssistantApplication.class)
public class LLMDemoTest {

    @Test
    public void test(){
        //初始化模型
        OpenAiChatModel model = OpenAiChatModel.builder()
                //LangChain4j提供的代理服务器，该代理服务器会将演示密钥替换成真实密钥， 再将请求转发给OpenAI API
                .baseUrl("http://langchain4j.dev/demo/openai/v1")
                // 设置模型api地址（如果apiKey="demo"，则可省略baseUrl的配置）
                .apiKey("demo") //设置模型apiKey
                .modelName("gpt-4o-mini") //设置模型名称
                .build();
        String answer = model.chat("我能用你干嘛");
        System.out.println(answer); // Hello World
    }

    @Autowired
    private OpenAiChatModel openAiChatModel;

    @Test
    public void testOpenAiChatModel() {
        String answer = openAiChatModel.chat("我能用你干嘛");
        System.out.println(answer); // Hello World
    }

    //    OpenAiChatModel implements ChatModel
//    @Autowired
//    private ChatModel chatModel;
//    @Test
//    public void testChatModel() {
//        String answer = chatModel.chat("我能用你干嘛");
//        System.out.println(answer); // Hello World
//    }

    //ollama模型
    @Autowired
    private OllamaChatModel ollamaChatModel;
    @Test
    public void testOllamaChatModel() {
        String answer = ollamaChatModel.chat("我能用你干嘛");
        System.out.println(answer); // Hello World
    }


//百炼平台
    @Autowired
    private QwenChatModel qwenChatModel;

    @Test
    public void testQwenChatModel() {
        String answer = qwenChatModel.chat("我能用你干嘛");
        System.out.println(answer); // Hello World

    }
    //通义万象
    @Test
    public void testDashScopeWanx(){
        WanxImageModel wanxImageModel = WanxImageModel.builder()
                .modelName("wanx2.1-t2i-plus")
                .apiKey(System.getenv("ALIBAILIAN_API_KEY")).build();
        Response<Image> answer = wanxImageModel.generate("生成一张猫咪的图片");
        System.out.println(answer.content().url());
    }


    //百炼平台接入deepseek模型
    @Test
    public void testDeepSeek(){
        String answer = openAiChatModel.chat("帮我写一段Java代码");
        System.out.println(answer);
    }
}
