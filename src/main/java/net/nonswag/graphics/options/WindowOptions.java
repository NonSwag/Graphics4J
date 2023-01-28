package net.nonswag.graphics.options;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import net.nonswag.core.api.math.Range;
import net.nonswag.graphics.Component;
import net.nonswag.graphics.Panel;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@Accessors(fluent = true, chain = true)
public class WindowOptions extends Options implements WindowConstants {
    private String title;
    private Panel contentPane;
    private final Map<Panel, String> panels = new HashMap<>();
    private Image icon;
    @Range(from = 0, to = 3)
    private int closeOperation;
    private Component<?, ?> relative;
    private LayoutManager layout;
    private boolean undecorated;

    public WindowOptions addPanel(Panel panel, String position) {
        panels().put(panel, position);
        return this;
    }
}
