package io.john.amiscaray.stir.domain.elements;

import io.john.amiscaray.stir.annotation.Attribute;
import io.john.amiscaray.stir.annotation.HTMLElement;
import io.john.amiscaray.stir.annotation.InnerContent;
import lombok.*;

/**
 * A pojo representing an HTML anchor tag
 */
@HTMLElement(tagName = "a")
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode(callSuper = true)
@Data
public class Anchor extends AbstractUIElement{

    /**
     * The inner content of the anchor tag
     */
    @InnerContent
    private final String label;
    /**
     * The href the anchor tag points to
     */
    @Attribute(name = "href")
    private final String href;
    /**
     * The download attribute of the anchor tag
     */
    @Attribute(name = "download")
    private String download;
    /**
     * The hrefLang attribute of the anchor tag
     */
    @Attribute(name = "hreflang")
    private String hrefLang;
    /**
     * The ping attribute of the anchor tag
     */
    @Attribute(name = "media")
    private String ping;
    /**
     * The referrerPolicy attribute of the anchor tag
     */
    @Attribute(name = "referrerpolicy")
    private String referrerPolicy;
    /**
     * The rel attribute of the anchor tag
     */
    @Attribute(name = "rel")
    private String rel;
    /**
     * The target attribute of the anchor tag
     */
    @Attribute(name = "target")
    private String target;
    /**
     * The type attribute of the anchor tag
     */
    @Attribute(name = "type")
    private String type;

}
