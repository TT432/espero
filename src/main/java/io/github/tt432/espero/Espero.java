package io.github.tt432.espero;

import io.github.tt432.espero.block.EsperoBlocks;
import io.github.tt432.espero.item.EsperoItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

/**
 * @author DustW
 */
@Mod(Espero.MOD_ID)
public class Espero {
    public static final String MOD_ID = "espero";

    public static final CreativeModeTab ESPERO_TAB = new CreativeModeTab(MOD_ID) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(EsperoItems.SHRINE_CREATOR.get());
        }
    };

    public Espero() {
        var bus = FMLJavaModLoadingContext.get().getModEventBus();
        EsperoBlocks.register(bus);
        EsperoItems.register(bus);
    }
}
