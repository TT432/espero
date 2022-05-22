package io.github.tt432.espero.gui.widget;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

/**
 * @author DustW
 **/
public class ScrollViewWidget extends ImageWidget {
    // 固定

    int maxX;
    int minX;
    int maxY;
    int minY;

    /** 主点的参数，推荐放到中央 */
    int mainX;
    int mainY;

    boolean located;

    public ScrollViewWidget(AbstractContainerScreen<?> screen,
                            int x, int y,
                            int width, int height,
                            ResourceLocation texture, int texX, int texY,
                            int maxX, int minX,
                            int maxY, int minY,
                            int mainX, int mainY) {
        super(screen, x, y, width, height, texture, texX, texY);
        this.maxX = maxX;
        this.minX = minX;
        this.maxY = maxY;
        this.minY = minY;
        this.mainX = mainX;
        this.mainY = mainY;
    }

    // 滚动

    double scrollX;
    double scrollY;
    boolean isScrolling;

    @Override
    public void renderIn(PoseStack poseStack, int mouseX, int mouseY, float partialTick) {
        if (!located) {
            located = true;

            scrollX = mainX;
            scrollY = mainY;
        }
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double dragX, double dragY) {
        if (button != 0) {
            this.isScrolling = false;
            return false;
        } else {
            if (!this.isScrolling) {
                this.isScrolling = true;
            } else {
                scroll(dragX, dragY);
            }

            return true;
        }
    }

    public void scroll(double dragX, double dragY) {
        if (this.maxX - this.minX > width) {
            this.scrollX = Mth.clamp(this.scrollX + dragX, -(this.maxX - width), 0.0D);
        }

        if (this.maxY - this.minY > height) {
            this.scrollY = Mth.clamp(this.scrollY + dragY, -(this.maxY - height), 0.0D);
        }
    }
}
