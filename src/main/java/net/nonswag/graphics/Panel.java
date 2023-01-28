package net.nonswag.graphics;

import net.nonswag.graphics.options.Options;
import net.nonswag.graphics.options.PanelOptions;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Panel extends Component<PanelOptions, JPanel> {
    private final List<Component<? extends Options, ? extends JComponent>> components = new ArrayList<>();

    public Panel(Options options) {
        super(options, (self, panelOptions) -> {
            JPanel panel = new JPanel();
            panel.setLayout(panelOptions.layout());
            return panel;
        });
    }

    public List<Component<? extends Options, ? extends JComponent>> getComponents() {
        return List.copyOf(components);
    }

    public boolean hasComponents() {
        return !components.isEmpty();
    }

    public int components() {
        return components.size();
    }

    public Panel add(Component<? extends Options, ? extends JComponent> component) {
        components.add(component);
        swing().add(component.swing());
        swing().validate();
        return this;
    }

    public Panel remove(Component<? extends Options, ? extends JComponent> component) {
        components.remove(component);
        swing().remove(component.swing());
        swing().repaint();
        swing().validate();
        return this;
    }
}
