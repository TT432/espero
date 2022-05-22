package io.github.tt432.espero.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

/**
 * @author DustW
 **/
public class EsperoBiomeTagsProvider extends BiomeTagsProvider {
    public EsperoBiomeTagsProvider(DataGenerator generator, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(generator, modId, existingFileHelper);
    }

    @Override
    protected void addTags() {

    }

    @Override
    public String getName() {
        return "Espero Biome Tags";
    }
}
