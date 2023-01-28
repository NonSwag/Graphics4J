package net.nonswag.graphics.options;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import net.nonswag.graphics.components.RadioButton;

import javax.swing.event.ChangeEvent;
import java.util.function.BiConsumer;

@Getter
@Setter
@Accessors(fluent = true, chain = true)
public class RadioButtonOptions extends Options {
    private String text, toolTip;
    private BiConsumer<RadioButton, ChangeEvent> changeEvent;
    private boolean selected;
}
