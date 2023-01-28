package net.nonswag.graphics.components;

import net.nonswag.graphics.Component;
import net.nonswag.graphics.options.Options;
import net.nonswag.graphics.options.RadioButtonOptions;

import javax.swing.*;

public class RadioButton extends Component<RadioButtonOptions, JRadioButton> {
    public RadioButton(Options options) {
        super(options, (self, radioButtonOptions) -> {
            JRadioButton button = new JRadioButton(radioButtonOptions.text());
            button.setToolTipText(radioButtonOptions.toolTip());
            button.addChangeListener(changeEvent -> SwingUtilities.invokeLater(() ->
                    radioButtonOptions.changeEvent().accept((RadioButton) self, changeEvent)));
            return button;
        });
    }
}
