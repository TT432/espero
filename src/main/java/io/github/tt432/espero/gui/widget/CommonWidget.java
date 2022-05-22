package io.github.tt432.espero.gui.widget;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.narration.NarratedElementType;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;

import java.util.function.Supplier;

/**
 * @author DustW
 **/
public class CommonWidget extends AbstractWidget {
    Supplier<Component> message;
    boolean needTooltip;
    AbstractContainerScreen<?> screen;

    public CommonWidget(AbstractContainerScreen<?> screen,
                        int pX, int pY,
                        int pWidth, int pHeight,
                        Supplier<Component> message, boolean needTooltip) {
        super(pX, pY, pWidth, pHeight, message.get());

        this.screen = screen;
        this.message = message;
        this.needTooltip = needTooltip;
    }

    public CommonWidget(AbstractContainerScreen<?> screen,
                        int x, int y,
                        int width, int height) {
        this(screen, x, y, width, height, () -> TextComponent.EMPTY, false);
    }

    @Override
    public void render(PoseStack poseStack, int mouseX, int mouseY, float partialTick) {
        if (!visible) {
            return;
        }

        this.isHovered = mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width && mouseY < this.y + this.height;

        renderIn(poseStack, mouseX, mouseY, partialTick);

        renderToolTip(poseStack, mouseX, mouseY);
    }

    protected void renderIn(PoseStack poseStack, int mouseX, int mouseY, float partialTick) {

    }

    @Override
    public void renderToolTip(PoseStack poseStack, int mouseX, int mouseY) {
        if (isHovered && needTooltip) {
            screen.renderTooltip(poseStack, getMessage(), mouseX, mouseY);
        }
    }

    @Override
    public Component getMessage() {
        return message.get();
    }

    @Override
    public void updateNarration(NarrationElementOutput output) {
        if (this.needTooltip) {
            output.add(NarratedElementType.HINT, getMessage());
        }
    }
}
