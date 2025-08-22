package com.shimmer.ai.Tools;

import dev.langchain4j.agent.tool.P;
import dev.langchain4j.agent.tool.Tool;
import dev.langchain4j.agent.tool.ToolMemoryId;
import dev.langchain4j.service.MemoryId;
import org.springframework.stereotype.Component;

/**
 * @description: CalculatorTools
 * ( ^_^ )
 * @Author: ZT
 * (✿◠‿◠)
 * @Date: 2025/8/22 10:32
 */

/**
 2、@Tool 注解的可选字段
 @Tool 注解有两个可选字段：
 name（工具名称）：工具的名称。如果未提供该字段，方法名会作为工具的名称。
 value（工具描述）：工具的描述信息。
 根据工具的不同，即使没有任何描述，大语言模型可能也能很好地理解它（例如， add(a, b) 就很直
 观），但通常最好提供清晰且有意义的名称和描述。这样，大语言模型就能获得更多信息，以决定是否
 调用给定的工具以及如何调用。
 3、@P 注解
 方法参数可以选择使用 @P 注解进行标注。
 @P 注解有两个字段：
 value：参数的描述信息，这是必填字段。
 required：表示该参数是否为必需项，默认值为 true ，此为可选字段。
 4、@ToolMemoryId
 如果你的AIService方法中有一个参数使用 @MemoryId 注解，那么你也可以使用 @ToolMemoryId 注解
 @Tool 方法中的一个参数。提供给AIService方法的值将自动传递给 @Tool 方法。如果你有多个用户，
 或每个用户有多个聊天记忆，并且希望在 @Tool 方法中对它们进行区分，那么这个功能会很有用。
 */
@Component
public class CalculatorTools {

    @Tool(name = "加法运算", value = "输出两个值的加法运算结果")
    double sum(
            @ToolMemoryId long memoryId,
            @P(value = "第一个值",required = true) double a,
            @P(value = "第二个值", required = true) double b) {
        System.out.println("调用加法运算 memoryId=" + memoryId);
        return a + b;
    }


    @Tool(name = "平方根运算", value = "输出两个值的平方根运算结果")
    double squareRoot(
            @ToolMemoryId long memoryId,double x) {
        System.out.println("调用平方根运算 memoryId=" + memoryId);
        return Math.sqrt(x);
    }
}
