package io.github.tt432.espero.gui.widget;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.function.Supplier;

/**
 * @author DustW
 **/
public class ItemIconWidget extends ImageWidget {
    ItemStack icon;

    public ItemIconWidget(AbstractContainerScreen<?> screen,
                          int pX, int pY,
                          int pWidth, int pHeight,
                          Supplier<Component> message, boolean needTooltip,
                          ResourceLocation texture, int texX, int texY,
                          ItemStack icon) {
        super(screen, pX, pY, pWidth, pHeight, message, needTooltip, texture, texX, texY);

        this.icon = icon;
    }

    public ItemIconWidget(AbstractContainerScreen<?> screen,
                          int pX, int pY,
                          int pWidth, int pHeight,
                          ResourceLocation texture, int texX, int texY,
                          boolean needTooltip,
                          ItemStack icon) {
        super(screen, pX, pY, pWidth, pHeight, () -> {
            var result = new TextComponent("");
            icon.getTooltipLines(Minecraft.getInstance().player, TooltipFlag.Default.NORMAL).forEach(result::append);
            return result;
        }, needTooltip, texture, texX, texY);

        this.icon = icon;
    }

    @Override
    public void renderIn(PoseStack poseStack, int mouseX, int mouseY, float partialTick) {
        // TODO 物品的渲染
    }
}
