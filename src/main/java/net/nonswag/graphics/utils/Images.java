package net.nonswag.graphics.utils;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import net.nonswag.core.api.annotation.FieldsAreNullableByDefault;
import net.nonswag.core.api.annotation.MethodsReturnNonnullByDefault;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.net.URL;

@Getter
@Accessors(fluent = true)
@FieldsAreNullableByDefault
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Images {
    private final Image image;
    private ImageIcon icon;

    public Images scaled(int size) {
        return scaled(size, size);
    }

    public Images scaled(int width, int height) {
        return scaled(width, height, Image.SCALE_SMOOTH);
    }

    public Images scaled(int width, int height, int hints) {
        return new Images(image != null ? image.getScaledInstance(width, height, hints) : null);
    }

    @Nullable
    public Icon icon() {
        return icon != null ? icon : image != null ? icon = new ImageIcon(image) : null;
    }

    public static Images get(URL url) {
        try {
            return new Images(ImageIO.read(url));
        } catch (Exception e) {
            return new Images(null);
        }
    }

    public static Images get(File file) {
        try {
            return new Images(ImageIO.read(file));
        } catch (Exception e) {
            return new Images(null);
        }
    }
}
