package net.rishy.betterpcs.screens;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.rishy.betterpcs.BPCSAllMenus;
import org.jspecify.annotations.NonNull;

public class IRMenu extends AbstractContainerMenu {
    public IRMenu(int containerId, Inventory playerInventory) {
        super(BPCSAllMenus.IR_MENU.get(), containerId);
    }

    @Override
    public @NonNull ItemStack quickMoveStack(Player player, int i) {
        return ItemStack.EMPTY;
    }


    @Override
    public boolean stillValid(Player player) {
        return true;
    }
}
