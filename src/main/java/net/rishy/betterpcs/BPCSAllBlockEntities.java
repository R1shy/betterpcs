package net.rishy.betterpcs;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.rishy.betterpcs.blocks.ImageBlockEntity;

import java.util.Set;
import java.util.function.Supplier;

public class BPCSAllBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPE_DEFERRED_REGISTER = DeferredRegister.create(
            Registries.BLOCK_ENTITY_TYPE, Betterpcs.MODID
    );

    public static final Supplier<BlockEntityType<ImageBlockEntity>> IMAGES_BLOCK_ENTITY = BLOCK_ENTITY_TYPE_DEFERRED_REGISTER.register(
            "image_block_entity",
            () -> new BlockEntityType<>(
                    BPCSAllBlockEntities::createImageBlockEntity,
                    Set.of(BPCSAllBlocks.IMAGE_BLOCK.get())
            )
    );

    private static ImageBlockEntity createImageBlockEntity(BlockPos pos, BlockState state) {
        return new ImageBlockEntity(IMAGES_BLOCK_ENTITY.get(), pos, state);
    }
}
