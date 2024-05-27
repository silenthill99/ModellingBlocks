package fr.silenthill99.modelling_blocks.data.models_and_blockstate;

import fr.silenthill99.modelling_blocks.Main;
import fr.silenthill99.modelling_blocks.init.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BlockStateGenerator extends BlockStateProvider {
    public BlockStateGenerator(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Main.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlockWithItem(ModBlocks.DISPLAY_CASE.get(), new ModelFile.UncheckedModelFile(modLoc("block/display_case")));
    }

    @Override
    public void axisBlock(RotatedPillarBlock block, ModelFile vertical, ModelFile horizontal) {
        super.axisBlock(block, vertical, horizontal);
        simpleBlockItem(block, vertical);
    }
}
