package io.github.tt432.espero.item;

import io.github.tt432.espero.Espero;
import io.github.tt432.espero.block.EsperoBlocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * @author DustW
 **/
public class EsperoItems {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Espero.MOD_ID);

    public static final RegistryObject<Item> SHRINE_CREATOR = fromBlock("shrine_creator", EsperoBlocks.SHRINE_CREATOR);

    private static RegistryObject<Item> fromBlock(String name, RegistryObject<Block> block) {
        return ITEMS.register(name, () -> new BlockItem(block.get(), defaultProperties()));
    }

    private static Item.Properties defaultProperties() {
        return new Item.Properties().tab(Espero.ESPERO_TAB);
    }

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
