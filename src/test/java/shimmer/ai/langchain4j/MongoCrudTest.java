package shimmer.ai.langchain4j;

import com.shimmer.ai.MedicalAssistantApplication;
import com.shimmer.ai.entity.ChatMessages;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;


/**
 * @description: MongoCrudTest
 * ( ^_^ )
 * @Author: ZT
 * (✿◠‿◠)
 * @Date: 2025/8/13 11:40
 */
@SpringBootTest(classes = MedicalAssistantApplication.class)
public class MongoCrudTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    // 测试 MongoDB 的 CRUD 操作
    // 这里可以添加具体的 CRUD 测试代码
    // 例如：插入、查询、更新、删除等操作
    @Test
    public void testMongoCrud() {
        ChatMessages chatMessages = new ChatMessages();
        chatMessages.setContent("测试消息内容");
        chatMessages.setMessageId(689);
        mongoTemplate.insert(chatMessages);
    }

    @Test
    public void testMongoUpdate() {
        // 这里可以添加具体的更新操作
        Criteria criteria = Criteria.where("content").is("测试消息内容");
        Query query =new Query(criteria);
        Update update = new Update();
        update.set("messageId", "1472393");
        mongoTemplate.upsert(query, update, ChatMessages.class);

    }

    @Test
    public void testMongoFind() {
        // 这里可以添加具体的查询操作
    ChatMessages chatMessages = mongoTemplate.findById("689c0a10105b7a383bb1fcb0", ChatMessages.class);
        System.out.println(chatMessages);
    }

    @Test
    public void testMongoDelete() {
        Criteria criteria = Criteria.where("_id").is("689c0a10105b7a383bb1fcb0");
        Query query = new Query(criteria);
        mongoTemplate.remove(query, ChatMessages.class);
    }
}
