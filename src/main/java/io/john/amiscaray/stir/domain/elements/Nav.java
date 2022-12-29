package io.john.amiscaray.stir.domain.elements;

import io.john.amiscaray.stir.annotation.HTMLElement;
import io.john.amiscaray.stir.annotation.Nested;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

@HTMLElement(tagName = "nav")
public class Nav extends AbstractUIElement{

    @Nested
    private NavLinkList list;

    public Nav(String id, List<String> cssClasses, String style, NavLinkList list) {
        super(id, cssClasses, style);
        this.list = list;
    }

    public Nav() {
    }

    public static Nav fromLabelHrefMap(LinkedHashMap<String, String> labelHref){

        LinkedHashMap<String, String> linkedMap = new LinkedHashMap<>(labelHref);
        Nav nav = new Nav();
        List<NavLink> links = linkedMap.entrySet().stream()
                .map(e -> NavLink.fromLabelAndHref(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
        nav.list = new NavLinkList(links);

        return nav;

    }

    public static NavBuilder builder() {
        return new NavBuilder();
    }

    public void addNavLink(NavLink link){

        list.addNavLink(link);

    }

    public static class NavBuilder {
        private String id;
        private ArrayList<String> cssClasses;
        private String style;
        private NavLinkList list;

        NavBuilder() {
        }

        public NavBuilder id(String id) {
            this.id = id;
            return this;
        }

        public NavBuilder cssClass(String cssClass) {
            if (this.cssClasses == null) this.cssClasses = new ArrayList<String>();
            this.cssClasses.add(cssClass);
            return this;
        }

        public NavBuilder cssClasses(Collection<? extends String> cssClasses) {
            if (this.cssClasses == null) this.cssClasses = new ArrayList<String>();
            this.cssClasses.addAll(cssClasses);
            return this;
        }

        public NavBuilder clearCssClasses() {
            if (this.cssClasses != null)
                this.cssClasses.clear();
            return this;
        }

        public NavBuilder style(String style) {
            this.style = style;
            return this;
        }

        public NavBuilder list(NavLinkList list) {
            this.list = list;
            return this;
        }

        public Nav build() {
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

            return new Nav(id, cssClasses, style, list);
        }

        public String toString() {
            return "Nav.NavBuilder(id=" + this.id + ", cssClasses=" + this.cssClasses + ", style=" + this.style + ", list=" + this.list + ")";
        }
    }
}
