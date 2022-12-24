package io.john.amiscaray.stir.domain.elements;

import io.john.amiscaray.stir.annotation.HTMLElement;
import io.john.amiscaray.stir.annotation.TableEntries;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Collection;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@HTMLElement(tagName = "table")
public class CollectionTableAdapter extends AbstractUIElement {

    @TableEntries
    private Collection<?> collection;

    private Class<?> clazz;

}
