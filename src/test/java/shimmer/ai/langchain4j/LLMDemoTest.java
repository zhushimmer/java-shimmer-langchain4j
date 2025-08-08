package shimmer.ai.langchain4j;

import com.shimmer.ai.langchain4j.MedicalAssistantApplication;
import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.community.model.dashscope.WanxImageModel;
import dev.langchain4j.data.image.Image;
import dev.langchain4j.model.chat.ChatModel;
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

    @Autowired
    private OllamaChatModel ollamaChatModel;
    @Test
    public void testOllamaChatModel() {
        String answer = ollamaChatModel.chat("我能用你干嘛");
        System.out.println(answer); // Hello World
    }



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

        Response<Image> answer = wanxImageModel.generate("蒸汽朋克城市：巨大的齿轮和管道纵横交错，覆盖着整个城市的建筑。高耸入云的烟囱中喷出浓浓的黑烟，天空被染成了暗灰色。街道上，蒸汽驱动的机械车辆穿梭往来，发出嘈杂的轰鸣声。人们穿着皮质的长风衣、戴着护目镜和金属头盔，手中拿着各种机械工具和武器。一座巨大的钟楼矗立在城市中央，齿轮在钟楼上飞速转动，钟声沉闷而悠远。城市边缘，巨大的蒸汽动力飞行器缓缓升空，准备开始新的旅程。");
        System.out.println(answer.content().url());
    }
}
