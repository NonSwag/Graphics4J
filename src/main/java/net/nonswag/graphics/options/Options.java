package net.nonswag.graphics.options;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.awt.*;
import java.util.Locale;

@Getter
@Setter
@Accessors(fluent = true, chain = true)
public class Options {
    private Color background, foreground;
    private Cursor cursor;
    private boolean enabled = true, focusable, focusPainted;
    private Dimension preferredSize, minimumSize, maximumSize;
    private Rectangle bounds;
    private Font font;
    private ComponentOrientation orientation;
    private Locale locale;
}
