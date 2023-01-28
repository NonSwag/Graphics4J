package net.nonswag.graphics.options;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.awt.*;

@Getter
@Setter
@Accessors(fluent = true, chain = true)
public class PanelOptions extends Options {
    private LayoutManager layout = new FlowLayout();
}
