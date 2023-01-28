package net.nonswag.graphics.components;

import net.nonswag.graphics.Component;
import net.nonswag.graphics.options.LabelOptions;
import net.nonswag.graphics.options.Options;

import javax.swing.*;

public class Label extends Component<LabelOptions, JLabel> {
    public Label(Options options) {
        super(options, (self, labelOptions) -> {
            JLabel label = new JLabel(labelOptions.text());
            label.setIcon(labelOptions.icon());
            return label;
        });
    }
}
