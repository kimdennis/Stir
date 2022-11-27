package io.john.amiscaray.stir.domain;

import io.john.amiscaray.stir.domain.elements.Script;
import io.john.amiscaray.stir.domain.elements.Style;
import io.john.amiscaray.stir.util.ElementProcessor;

import java.util.ArrayList;
import java.util.List;

public class HTMLDocument {

    private final List<Object> elements = new ArrayList<>();
    private final List<Style> styleSheets = new ArrayList<>();
    private final List<Script> headerScripts = new ArrayList<>();
    private final List<Script> footerScripts = new ArrayList<>();
    private String title;
    private final ElementProcessor processor = ElementProcessor.getInstance();

    public static Builder builder(){
        return new Builder();
    }

    public enum DocumentPosition{
        HEADER,
        FOOTER
    }

    public static class Builder{

        private final HTMLDocument doc;

        public Builder(){
            doc = new HTMLDocument();
        }

        public HTMLDocument.Builder addElement(Object element){
            doc.elements.add(element);
            return this;
        }

        public HTMLDocument.Builder addScript(Script script, DocumentPosition position){
            if(position.equals(DocumentPosition.HEADER)){
                doc.headerScripts.add(script);
            }else{
                doc.footerScripts.add(script);
            }
            return this;
        }

        public HTMLDocument.Builder title(String title){
            doc.title = title;
            return this;
        }

        public HTMLDocument.Builder addStyle(Style style){
            doc.styleSheets.add(style);
            return this;
        }

        public HTMLDocument build(){
            return doc;
        }

    }

    private String generateStylesMarkup(){
        return String.format("%s".repeat(styleSheets.size()),
                styleSheets.stream()
                        .map(element -> processor.getMarkup(element).indent(ElementProcessor.getIndentationSize() * 2))
                        .toArray());
    }

    private String generateFooterScriptsMarkup(){
        return String.format("%s".repeat(footerScripts.size()),
                footerScripts.stream()
                        .map(element -> processor.getMarkup(element).indent(ElementProcessor.getIndentationSize() * 2))
                        .toArray()
                );
    }

    public String generateDocumentString(){
        String builder = """
                <!DOCTYPE html>
                <html lang="en">
                    <head>
                        <meta charset="UTF-8">
                        <title>""" + (title != null ? title : "Title") +
                """
                </title>
                """ +
                generateStylesMarkup() +
                """
                    </head>
                    <body>
                """ +
                "%s\n".repeat(elements.size()).trim() +
                generateFooterScriptsMarkup()
                +
                """
                    </body>
                </html>""";
        return String.format(builder, elements.stream().map(element -> processor.getMarkup(element).indent(ElementProcessor.getIndentationSize() * 2)).toArray());
    }

}
