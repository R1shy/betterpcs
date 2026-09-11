package net.rishy.betterpcs;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.BlockItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.rishy.betterpcs.blocks.ImageBlock;

public class BPCSAllBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Betterpcs.MODID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Betterpcs.MODID);

    public static final DeferredHolder<Block, ImageBlock> IMAGE_BLOCK = BLOCKS.registerBlock(
            "image_registry_block", ImageBlock::new
    );

    public static final DeferredItem<BlockItem> IMAGE_BLOCK_ITEM =
            ITEMS.registerSimpleBlockItem("image_registry_block", IMAGE_BLOCK);
}
