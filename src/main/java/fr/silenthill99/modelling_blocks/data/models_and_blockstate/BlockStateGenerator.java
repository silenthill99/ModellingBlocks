package fr.silenthill99.modelling_blocks.data.models_and_blockstate;

import fr.silenthill99.modelling_blocks.Main;
import fr.silenthill99.modelling_blocks.init.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BlockStateGenerator extends BlockStateProvider {
    public BlockStateGenerator(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Main.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        directionalBlock(ModBlocks.DISPLAY_CASE.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/display_case")), 0);
    }

    @Override
    public void directionalBlock(Block block, ModelFile model, int angleOffset) {
        super.directionalBlock(block, model, angleOffset);
        simpleBlockItem(block, model);
    }
}
