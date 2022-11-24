package io.john.amiscaray.util;

import io.john.amiscaray.domain.elements.Form;
import io.john.amiscaray.domain.elements.Input;
import io.john.amiscaray.setup.ExpectedHTMLLoader;
import io.john.amiscaray.stub.EmptyForm;
import io.john.amiscaray.stub.FormWithChildList;
import io.john.amiscaray.stub.FormWithInputs;
import io.john.amiscaray.stub.SimpleForm;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


class ElementProcessorTest {

    private final ElementProcessor processor = ElementProcessor.getInstance();
    private final ExpectedHTMLLoader htmlLoader = ExpectedHTMLLoader.getInstance();

    @Test
    void isMyFormAForm() {

        assertEquals(processor.getTagName(EmptyForm.class), "form");

    }

    @Test
    void myFormMarkup() throws IOException {

        assertEquals(htmlLoader.getHTMLContentOf("html/myFormMarkUpExpected.html") , processor.getMarkup(new EmptyForm()));

    }

    @Test
    void simpleFormWithAttributes() throws IOException {

        assertEquals(htmlLoader.getHTMLContentOf("html/simpleFormWithAttributesExpected.html"), processor.getMarkup(new SimpleForm()));

    }

    @Test
    void formWithInputs() throws IOException {

        FormWithInputs form = new FormWithInputs();

        assertEquals(htmlLoader.getHTMLContentOf("html/formWithInputsExpected.html"), processor.getMarkup(form));

    }

    @Test
    void formWithChildList() throws IOException {

        Input username = new Input("text", "username", "John", null);
        Input message = new Input("text1", "message", "Some Message", null);
        FormWithChildList form = new FormWithChildList.Builder()
                .addInput(username)
                .addInput(message)
                .build();
        assertEquals(htmlLoader.getHTMLContentOf("html/formWithChildListExpected.html"), processor.getMarkup(form));

    }

    @Test
    void testLibForm() throws IOException {

        Input username = new Input("text", "username", "John", null);
        Input message = new Input("text1", "message", "Some Message", null);
        Form form = new Form.Builder()
                        .addField(username)
                        .addField(message)
                        .setAction("/path")
                        .setMethod("post")
                        .build();
        assertEquals(htmlLoader.getHTMLContentOf("html/testLibFormExpected.html"), processor.getMarkup(form));

    }

    @Test
    void FormWithLabel() throws IOException {

        Input username = new Input("text", "username", "John", "Username");
        Form form = new Form.Builder()
                .addField(username)
                .build();
        assertEquals(htmlLoader.getHTMLContentOf("html/formWithLabelExpected.html"), processor.getMarkup(form));

    }

}