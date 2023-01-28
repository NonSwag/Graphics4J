package net.nonswag.graphics.options;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.awt.event.ActionEvent;
import java.util.function.Consumer;

@Getter
@Setter
@Accessors(fluent = true, chain = true)
public class ButtonOptions extends Options {
    private String text, toolTip;
    private Consumer<ActionEvent> actionEvent;
}
