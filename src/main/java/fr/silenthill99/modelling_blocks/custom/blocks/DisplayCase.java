package fr.silenthill99.modelling_blocks.custom.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("deprecation")
public class DisplayCase extends Block {

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public DisplayCase(Properties pProperties) {
        super(pProperties);
    }

    public static final VoxelShape SHAPES_NORTH = Shapes.or(
            box(2, 0, 2, 14, 1, 14),
            box(4, 1, 4, 12, 22, 12),
            box(3, 22, 3, 13, 23, 13),
            box(3, 23, 12, 13, 24, 13)
    );
    public static final VoxelShape SHAPES_SOUTH = Shapes.or(
            box(2, 0, 2, 14, 1, 14),
            box(4, 1, 4, 12, 22, 12),
            box(3, 22, 3, 13, 23, 13),
            box(3, 23, 3, 13, 24, 4)
    );
    public static final VoxelShape SHAPES_EAST = Shapes.or(
            box(2, 0, 2, 14, 1, 14),
            box(4, 1, 4, 12, 22, 12),
            box(3, 22, 3, 13, 23, 13),
            box(3, 23, 3, 4, 24, 13)
    );

    public static final VoxelShape SHAPES_WEST = Shapes.or(
            box(2, 0, 2, 14, 1, 14),
            box(4, 1, 4, 12, 22, 12),
            box(3, 22, 3, 13, 23, 13),
            box(12, 23, 3, 13, 24, 13)
    );

    @Override
    public @NotNull VoxelShape getShape(BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos, @NotNull CollisionContext pContext) {
        switch (pState.getValue(FACING)){
            case SOUTH -> {
                return SHAPES_SOUTH;
            }
            case EAST -> {
                return SHAPES_EAST;
            }
            case WEST -> {
                return SHAPES_WEST;
            }
            default -> {
                return SHAPES_NORTH;
            }
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
    }
}
