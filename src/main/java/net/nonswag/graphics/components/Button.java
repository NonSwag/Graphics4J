package net.nonswag.graphics.components;

import net.nonswag.graphics.Component;
import net.nonswag.graphics.options.ButtonOptions;
import net.nonswag.graphics.options.Options;

import javax.swing.*;

public class Button extends Component<ButtonOptions, JButton> {
    public Button(Options options) {
        super(options, (self, buttonOptions) -> {
            JButton button = new JButton(buttonOptions.text());
            button.setToolTipText(buttonOptions.toolTip());
            button.addActionListener(buttonOptions.actionEvent()::accept);
            return button;
        });
    }
}
