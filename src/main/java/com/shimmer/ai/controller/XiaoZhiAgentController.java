package com.shimmer.ai.controller;

import com.shimmer.ai.assistant.XiaoZhiAgent;
import com.shimmer.ai.entity.ChatForm;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: XiaoZhiAgentController
 * ( ^_^ )
 * @Author: ZT
 * (✿◠‿◠)
 * @Date: 2025/8/22 9:01
 */

/**
 信息查询：提示词中还应该提供医院信息（如位置信息，营业时间等）、科室信息（都有哪些科室）、
 医生信息（都有哪些医生）
 业务实现：预约、取消预约、查询是否预约等
 信息查询可以使用RAG检索增强生成
 业务实现需要通过Function Calling函数调用
 */
@Tag(name = "小智智能体", description = "小智智能体相关接口")//配置前端调用
@RestController
@RequestMapping("/xiaozhi")
public class XiaoZhiAgentController {

    @Autowired
    private XiaoZhiAgent xiaoZhiAgent; // 注入XiaoZhiAgent智能体接口

    @Operation(summary = "小智智能体对话", description = "与小智智能体进行对话")
    @PostMapping("/chat")
    public String chat(@RequestBody ChatForm chatForm) {

        // 调用XiaoZhiAgent的chat方法
        return xiaoZhiAgent.chat(chatForm.getMemoryId(), chatForm.getMessage());
    }


}
