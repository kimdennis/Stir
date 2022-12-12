package io.john.amiscaray.stir.util;

import io.john.amiscaray.stir.domain.HTMLDocument;
import io.john.amiscaray.stir.domain.elements.Form;
import io.john.amiscaray.stir.domain.elements.Input;
import io.john.amiscaray.stir.domain.elements.Script;
import io.john.amiscaray.stir.domain.elements.Style;
import io.john.amiscaray.stir.setup.ExpectedHTMLLoader;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HTMLDocumentTest {

    private final ExpectedHTMLLoader htmlLoader = ExpectedHTMLLoader.getInstance();
    private final Input username = new Input("text", "text", "John", null);
    private final Input message = new Input("text1", "text", "Some Message", null);

    private final Form sampleLibForm = Form.builder()
            .addField(username)
            .addField(message)
            .action("/path")
            .method("post")
            .build();

    @Test
    public void testLibFormAsDocWithStyles() throws IOException {

        HTMLDocument doc = HTMLDocument.builder()
                .addElement(sampleLibForm)
                .addStyle(new Style(
                        "https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css",
                        "sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65",
                        "anonymous"
                ))
                .addStyle(new Style("./styles.css"))
                .title("Hello")
                .build();
        assertEquals(htmlLoader.getHTMLContentOf("html/libFormAsDocExpected.html"), doc.generateDocumentString());

    }

    @Test
    public void testLibFormAsDocWithFooterScript() throws IOException {

        HTMLDocument doc = HTMLDocument.builder()
                .addElement(sampleLibForm)
                .addScript(new Script("./main.js"), HTMLDocument.DocumentPosition.FOOTER)
                .title("Hello")
                .build();
        assertEquals(htmlLoader.getHTMLContentOf("html/docWithFooterScriptExpected.html"), doc.generateDocumentString());

    }

    @Test
    public void testLibFormAsDocWithHeaderScript() throws IOException {

        HTMLDocument doc = HTMLDocument.builder()
                .addElement(sampleLibForm)
                .addScript(new Script("./main.js"), HTMLDocument.DocumentPosition.HEADER)
                .title("Hello")
                .build();
        assertEquals(htmlLoader.getHTMLContentOf("html/docWithHeaderScriptExpected.html"), doc.generateDocumentString());

    }

    @Test
    public void testDocWithHeaderScriptAndStyles() throws IOException {

        HTMLDocument doc = HTMLDocument.builder()
                .addElement(sampleLibForm)
                .addStyle(new Style(
                        "https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css",
                        "sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65",
                        "anonymous"
                ))
                .addStyle(new Style("./styles.css"))
                .addScript(new Script("./main.js"), HTMLDocument.DocumentPosition.HEADER)
                .title("Hello")
                .build();
        assertEquals(htmlLoader.getHTMLContentOf("html/docWithHeaderScriptAndStyleExpected.html"), doc.generateDocumentString());

    }


}
