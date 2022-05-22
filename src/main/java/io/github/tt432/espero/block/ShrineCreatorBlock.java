package io.github.tt432.espero.block;

import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureManager;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;

import java.util.Random;

/**
 * @author DustW
 **/
public class ShrineCreatorBlock extends Block {
    ResourceLocation structureName;

    public ShrineCreatorBlock(Properties properties, ResourceLocation structureName) {
        super(properties);
        this.structureName = structureName;
    }

    @Override
    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        BlockPos blockpos = pPos.below();
        return this.mayPlaceOn(pLevel.getBlockState(blockpos), pLevel, pPos.below());
    }

    private boolean mayPlaceOn(BlockState blockState, LevelReader pLevel, BlockPos blockpos) {
        return !blockState.isAir();
    }

    @Override
    public void onPlace(BlockState pState, Level commonLevel, BlockPos pPos, BlockState pOldState, boolean pIsMoving) {
        if (commonLevel instanceof ServerLevel level) {
            StructureManager structuremanager = level.getStructureManager();

            StructurePlaceSettings settings = new StructurePlaceSettings()
                    .setMirror(Mirror.NONE).setRotation(Rotation.NONE).setIgnoreEntities(true);

            structuremanager.get(this.structureName).ifPresent(template -> {
                template.placeInWorld(level, pPos, pPos, settings, new Random(Util.getMillis()), 2);
            });
        }
    }
}
