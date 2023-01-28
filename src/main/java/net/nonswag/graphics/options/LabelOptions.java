package net.nonswag.graphics.options;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.swing.*;

@Getter
@Setter
@Accessors(fluent = true, chain = true)
public class LabelOptions extends Options {
    private String text;
    private Icon icon;
}
