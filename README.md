# 表
```mysql
CREATE TABLE `appointment` (
`id` BIGINT NOT NULL AUTO_INCREMENT,
`username` VARCHAR(50) NOT NULL,
`id_card` VARCHAR(18) NOT NULL,
`department` VARCHAR(50) NOT NULL,
`date` VARCHAR(10) NOT NULL,
`time` VARCHAR(10) NOT NULL,
`doctor_name` VARCHAR(50) DEFAULT NULL,
PRIMARY KEY (`id`)
);
```

# 相关链接
向量模型：https://www.pinecone.io/
向量模型参考文档：https://docs.langchain4j.dev/integrations/embedding-stores/pinecone/
阿里百炼：https://bailian.console.aliyun.com/
langchain4j文档：
1. https://docs.langchain4j.dev/
2. https://docs.langchain4j.dev/get-started/
3. https://docs.langchain4j.dev/tutorials/spring-boot-integration/

大语言排行版：https://superclueai.com/
deepseek接入:https://www.deepseek.com/ ; https://api-docs.deepseek.com/zh-cn/
Ollama接入:https://ollama.com/;    https://docs.langchain4j.dev/integrations/language-models/ollama/#get-started
mongdb接入:https://www.mongodb.com/try/download/community;   https://www.mongodb.com/try/download/shell;   https://www.mongodb.com/try/download/compass
