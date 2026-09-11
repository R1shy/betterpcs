package net.rishy.betterpcs.blocks;


import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.rishy.betterpcs.BPCSAllBlockEntities;
import net.rishy.betterpcs.screens.IRMenu;
import org.jspecify.annotations.Nullable;

public class ImageBlock extends Block implements EntityBlock {
    public ImageBlock(Properties properties) {
        super(properties);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new ImageBlockEntity(BPCSAllBlockEntities.IMAGES_BLOCK_ENTITY.get(),blockPos,blockState);
    }
    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player2, BlockHitResult hitResult) {
        player2.openMenu(new SimpleMenuProvider(
                (conID,playerInv,player) -> new IRMenu(conID,playerInv),
                Component.literal("")
        ));
        return InteractionResult.SUCCESS;
    }

}
