package com.shimmer.ai.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @description: ChatMessages
 * ( ^_^ )
 * @Author: ZT
 * (✿◠‿◠)
 * @Date: 2025/8/13 11:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "chat_messages")
public class ChatMessages {
    @Id
    private ObjectId id; // MongoDB的唯一标识符,自动注入类型必须为Objectid

    private int messageId;

    private String content;
}
