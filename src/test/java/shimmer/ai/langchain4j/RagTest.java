package shimmer.ai.langchain4j;

import com.shimmer.ai.MedicalAssistantApplication;
import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.loader.FileSystemDocumentLoader;
import dev.langchain4j.data.document.parser.TextDocumentParser;
import dev.langchain4j.data.document.parser.apache.pdfbox.ApachePdfBoxDocumentParser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.PathMatcher;
import java.util.List;

/**
 * @description: RagTest
 * ( ^_^ )
 * @Author: ZT
 * (✿◠‿◠)
 * @Date: 2025/8/22 16:56
 */
@SpringBootTest(classes = MedicalAssistantApplication.class)
public class RagTest {

    @Test
    public void testRagDocument() {
        Document ragDocument = FileSystemDocumentLoader.loadDocument("src/main/resources/rag");
        System.out.println(ragDocument.text());
    }

    /**
     *来自 langchain4j 模块的文本文档解析器（TextDocumentParser），它能够解析纯文本格式的文件
     * （例如 TXT、HTML、MD 等）。
     */
    @Test
    public void testRagDocumentList() {
        // 加载单个文档
        Document document = FileSystemDocumentLoader.loadDocument("E:/NLP/knowledge/测试.txt", new
                TextDocumentParser());
// 从一个目录中加载所有文档
        List<Document> documents = FileSystemDocumentLoader.loadDocuments("E:/NLP/knowledge", new
                TextDocumentParser());
// 从一个目录中加载所有的.txt文档
        PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:*.txt");
        List<Document> documents1 = FileSystemDocumentLoader.loadDocuments("E:/NLP/knowledge",
                pathMatcher, new TextDocumentParser());
// 从一个目录及其子目录中加载所有文档
        List<Document> documents2 =
                FileSystemDocumentLoader.loadDocumentsRecursively("E:/NLP/knowledge", new
                        TextDocumentParser());
    }

    /**
     * 解析PDF
     1.来自 langchain4j-document-parser-apache-pdfbox 模块的 Apache PDFBox 文档解析器
     （ApachePdfBoxDocumentParser），它可以解析 PDF 文件。
     2.来自 langchain4j-document-parser-apache-poi 模块的 Apache POI 文档解析器
     （ApachePoiDocumentParser），它能够解析微软办公软件的文件格式（例如 DOC、DOCX、PPT、
     PPTX、XLS、XLSX 等）。
     3.来自 langchain4j-document-parser-apache-tika 模块的 Apache Tika 文档解析器
     （ApacheTikaDocumentParser），它可以自动检测并解析几乎所有现有的文件格式。
     */
    @Test
    public void testParsePDF() {
        Document document = FileSystemDocumentLoader.loadDocument(
                "E:/NLP/knowledge/医院信息.pdf",
                new ApachePdfBoxDocumentParser()
        );
        System.out.println(document);
    }

    @Test
    public void doc(){
        Document doc = FileSystemDocumentLoader.loadDocument("E:/NLP/knowledge/医院信息.pdf"
                );
        System.out.println(doc.text());

    }
}
