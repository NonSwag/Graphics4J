package net.nonswag.graphics;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.nonswag.graphics.options.Options;

import javax.annotation.Nullable;
import java.util.function.BiFunction;

@RequiredArgsConstructor
public abstract class Component<O extends Options, T extends java.awt.Component> {
    private final Options options;
    @Getter
    private final BiFunction<Component<O, T>, O, T> creator;

    @Nullable
    private T component;

    @SuppressWarnings("unchecked")
    public O getOptions() {
        return (O) options;
    }

    protected final synchronized T swing() {
        if (component != null) return component;
        T component = getCreator().apply(this, getOptions());
        component.setBackground(getOptions().background());
        component.setForeground(getOptions().foreground());
        component.setCursor(getOptions().cursor());
        component.setEnabled(getOptions().enabled());
        component.setFocusable(getOptions().focusable());
        component.setMinimumSize(getOptions().minimumSize());
        component.setMaximumSize(getOptions().maximumSize());
        component.setPreferredSize(getOptions().preferredSize());
        component.setIgnoreRepaint(getOptions().focusPainted());
        if (getOptions().bounds() != null) component.setBounds(getOptions().bounds());
        if (getOptions().font() != null) component.setFont(getOptions().font());
        if (getOptions().orientation() != null) component.setComponentOrientation(getOptions().orientation());
        component.setLocale(getOptions().locale());
        return this.component = component;
    }
}
