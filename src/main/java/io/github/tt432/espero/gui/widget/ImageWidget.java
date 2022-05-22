package io.github.tt432.espero.gui.widget;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Supplier;

/**
 * @author DustW
 **/
public class ImageWidget extends CommonWidget {
    ResourceLocation texture;
    int texX;
    int texY;

    public ImageWidget(AbstractContainerScreen<?> screen,
                             int x, int y,
                             int width, int height,
                             Supplier<Component> message, boolean needTooltip,
                             ResourceLocation texture, int texX, int texY) {
        super(screen, x, y, width, height, message, needTooltip);

        this.texture = texture;
        this.texX = texX;
        this.texY = texY;
    }

    public ImageWidget(AbstractContainerScreen<?> screen,
                             int x, int y,
                             int width, int height,
                             ResourceLocation texture, int texX, int texY) {
        this(screen, x, y, width, height, () -> TextComponent.EMPTY,
                false, texture, texX, texY);
    }

    @Override
    public void renderIn(PoseStack poseStack, int mouseX, int mouseY, float partialTick) {
        RenderSystem.setShaderTexture(0, texture);
        screen.blit(poseStack, x, y, texX, texY, width, height);
    }
}