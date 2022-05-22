package io.github.tt432.espero.block;

import io.github.tt432.espero.Espero;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * @author DustW
 **/
public class EsperoBlocks {
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Espero.MOD_ID);

    public static final RegistryObject<Block> SHRINE_CREATOR = BLOCKS.register("shrine_creator",
            () -> new ShrineCreatorBlock(defaultProperties(), new ResourceLocation(Espero.MOD_ID, "shrine")));

    private static BlockBehaviour.Properties defaultProperties() {
        return BlockBehaviour.Properties.of(Material.STONE);
    }

    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }
}
