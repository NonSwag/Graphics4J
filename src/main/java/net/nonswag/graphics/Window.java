package net.nonswag.graphics;

import lombok.Getter;
import lombok.Setter;
import net.nonswag.graphics.options.Options;
import net.nonswag.graphics.options.WindowOptions;

import javax.swing.*;

@Getter
@Setter
public class Window extends Component<WindowOptions, JFrame> {
    @SuppressWarnings("MagicConstant")
    public Window(Options options) {
        super(options, (self, windowOptions) -> {
            JFrame frame = new JFrame(windowOptions.title());
            if (windowOptions.contentPane() != null) frame.setContentPane(windowOptions.contentPane().swing());
            frame.setIconImage(windowOptions.icon());
            frame.setDefaultCloseOperation(windowOptions.closeOperation());
            frame.setLayout(windowOptions.layout());
            frame.setUndecorated(windowOptions.undecorated());
            windowOptions.panels().forEach((panel, position) -> frame.add(panel.swing(), position));
            return frame;
        });
    }

    public void show() {
        swing().pack();
        swing().setLocationRelativeTo(getOptions().relative() != null ? getOptions().relative().swing() : null);
        swing().setVisible(true);
    }
}
