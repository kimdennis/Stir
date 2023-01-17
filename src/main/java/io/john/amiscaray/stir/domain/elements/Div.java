package io.john.amiscaray.stir.domain.elements;

import io.john.amiscaray.stir.annotation.HTMLElement;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * A pojo representing a div element
 */
@EqualsAndHashCode(callSuper = true)
@HTMLElement(tagName = "div")
@NoArgsConstructor
public class Div extends AbstractElementContainer<AbstractUIElement>{

    public Div(String id, List<String> cssClasses, String style, List<AbstractUIElement> children, boolean hidden) {
        super(id, cssClasses, style, children, hidden);
    }

    public static DivBuilder builder() {
        return new DivBuilder();
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Div;
    }

    public static class DivBuilder {
        private String id;
        private ArrayList<String> cssClasses;
        private String style;
        private ArrayList<AbstractUIElement> children;
        private boolean hidden;

        DivBuilder() {
        }

        public DivBuilder id(String id) {
            this.id = id;
            return this;
        }

        public DivBuilder cssClass(String cssClass) {
            if (this.cssClasses == null) this.cssClasses = new ArrayList<String>();
            this.cssClasses.add(cssClass);
            return this;
        }

        public DivBuilder cssClasses(Collection<? extends String> cssClasses) {
            if (this.cssClasses == null) this.cssClasses = new ArrayList<String>();
            this.cssClasses.addAll(cssClasses);
            return this;
        }

        public DivBuilder clearCssClasses() {
            if (this.cssClasses != null)
                this.cssClasses.clear();
            return this;
        }

        public DivBuilder style(String style) {
            this.style = style;
            return this;
        }

        public DivBuilder child(AbstractUIElement child) {
            if (this.children == null) this.children = new ArrayList<AbstractUIElement>();
            this.children.add(child);
            return this;
        }

        public DivBuilder children(Collection<? extends AbstractUIElement> children) {
            if (this.children == null) this.children = new ArrayList<AbstractUIElement>();
            this.children.addAll(children);
            return this;
        }

        public DivBuilder clearChildren() {
            if (this.children != null)
                this.children.clear();
            return this;
        }

        public DivBuilder hidden(boolean hidden) {
            this.hidden = hidden;
            return this;
        }

        public Div build() {
            List<String> cssClasses;
            switch (this.cssClasses == null ? 0 : this.cssClasses.size()) {
                case 0:
                    cssClasses = java.util.Collections.emptyList();
                    break;
                case 1:
                    cssClasses = java.util.Collections.singletonList(this.cssClasses.get(0));
                    break;
                default:
                    cssClasses = java.util.Collections.unmodifiableList(new ArrayList<String>(this.cssClasses));
            }
            List<AbstractUIElement> children;
            switch (this.children == null ? 0 : this.children.size()) {
                case 0:
                    children = java.util.Collections.emptyList();
                    break;
                case 1:
                    children = java.util.Collections.singletonList(this.children.get(0));
                    break;
                default:
                    children = java.util.Collections.unmodifiableList(new ArrayList<AbstractUIElement>(this.children));
            }

            return new Div(id, cssClasses, style, children, hidden);
        }

        public String toString() {
            return "Div.DivBuilder(id=" + this.id + ", cssClasses=" + this.cssClasses + ", style=" + this.style + ", children=" + this.children + ", hidden=" + this.hidden + ")";
        }
    }
}
