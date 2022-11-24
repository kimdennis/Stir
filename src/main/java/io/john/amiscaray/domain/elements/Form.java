package io.john.amiscaray.domain.elements;

import io.john.amiscaray.annotation.Attribute;
import io.john.amiscaray.annotation.ChildList;
import io.john.amiscaray.annotation.HTMLElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@HTMLElement(tagName = "form")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Form {

    @ChildList
    private List<Input> fields = new ArrayList<>();

    @Attribute(name = "method", defaultValue = "get")
    private String method;

    @Attribute(name="action", defaultValue = "/")
    private String action;

    public static class Builder{

        private final Form form;

        public Builder(){

            form = new Form();

        }

        public Builder addField(Input input){

            form.fields.add(input);
            return this;

        }

        public Builder setMethod(String method){

            form.method = method;
            return this;

        }

        public Builder setAction(String action){

            form.action = action;
            return this;

        }

        public Form build(){

            return form;

        }

    }

}
