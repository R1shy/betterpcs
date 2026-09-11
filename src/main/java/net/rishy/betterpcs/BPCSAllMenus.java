package net.rishy.betterpcs;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.rishy.betterpcs.screens.IRMenu;

import java.util.function.Supplier;

public class BPCSAllMenus {
    public static final DeferredRegister<MenuType<?>> REGISTER = DeferredRegister.create(
            Registries.MENU,Betterpcs.MODID
    );
    public static final Supplier<MenuType<IRMenu>> IR_MENU = REGISTER.register(
            "ir_menu",
            () -> new MenuType<>(IRMenu::new, FeatureFlagSet.of())
    );

}
