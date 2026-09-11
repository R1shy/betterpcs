package net.rishy.betterpcs.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.rishy.betterpcs.BPCSAllBlockEntities;

public class ImageBlockEntity extends BlockEntity {
    public ImageBlockEntity(BlockEntityType<?> type, BlockPos worldPosition, BlockState blockState) {
        super(BPCSAllBlockEntities.IMAGES_BLOCK_ENTITY.get(), worldPosition, blockState);
    }
}
