package net.nonswag.test.graphics;

import net.nonswag.graphics.Panel;
import net.nonswag.graphics.Window;
import net.nonswag.graphics.components.Button;
import net.nonswag.graphics.components.Label;
import net.nonswag.graphics.options.ButtonOptions;
import net.nonswag.graphics.options.LabelOptions;
import net.nonswag.graphics.options.PanelOptions;
import net.nonswag.graphics.options.WindowOptions;
import net.nonswag.graphics.utils.Images;

import java.awt.*;
import java.io.File;
import java.util.UUID;

public class Graphics {
    private static final Images THENEXTLVL = Images.get(new File("src/test/resources/thenextlvl.png"));

    public static void main(String[] args) {
        Panel content = new Panel(new PanelOptions().background(Color.GRAY));
        Panel header = new Panel(new PanelOptions().background(Color.DARK_GRAY.darker())).
                add(new Button(new ButtonOptions().text("add").actionEvent(event -> {
                    String text = UUID.randomUUID().toString();
                    content.add(new Panel(new PanelOptions().layout(new FlowLayout()).background(Color.LIGHT_GRAY)).
                            add(new Label(new LabelOptions().text(text).icon(THENEXTLVL.scaled(32).icon()))));
                }).background(Color.LIGHT_GRAY))).
                add(new Button(new ButtonOptions().text("remove").actionEvent(event -> {
                    if (content.hasComponents()) content.remove(content.getComponents().get(content.components() - 1));
                }).background(Color.LIGHT_GRAY)));
        Panel footer = new Panel(new PanelOptions().background(Color.BLACK)).add(new Label(new LabelOptions().text("Copyright @ 2023 NonSwag")));
        new Window(new WindowOptions().title("Test").
                layout(new BorderLayout()).icon(THENEXTLVL.image()).
                addPanel(header, BorderLayout.PAGE_START).
                addPanel(content, BorderLayout.CENTER).
                addPanel(footer, BorderLayout.PAGE_END).
                closeOperation(WindowOptions.EXIT_ON_CLOSE).
                preferredSize(new Dimension(1200, 800)).
                minimumSize(new Dimension(600, 400))
        ).show();
    }
}
