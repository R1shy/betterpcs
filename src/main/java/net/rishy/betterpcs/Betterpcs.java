package net.rishy.betterpcs;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.rishy.betterpcs.screens.IRMenu;
import net.rishy.betterpcs.screens.IRScreen;
import org.testcontainers.DockerClientFactory;

import java.beans.EventHandler;

@Mod(Betterpcs.MODID)
public class Betterpcs {
    public static final String MODID = "betterpcs";
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> BPCS_TAB = CREATIVE_MODE_TABS.register("bpcs", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.betterpcs"))
            .withTabsBefore(CreativeModeTabs.COMBAT).icon(
                    () -> new ItemStack(BPCSAllBlocks.IMAGE_BLOCK.get(), 1))
            .displayItems((parameters, output) -> {
        output.accept(BPCSAllBlocks.IMAGE_BLOCK.get());
    }).build());

    public Betterpcs(IEventBus modEventBus, ModContainer modContainer) {
        CREATIVE_MODE_TABS.register(modEventBus);
        BPCSAllBlockEntities.BLOCK_ENTITY_TYPE_DEFERRED_REGISTER.register(modEventBus);
        BPCSAllBlocks.BLOCKS.register(modEventBus);
        BPCSAllBlocks.ITEMS.register(modEventBus);
        BPCSAllMenus.REGISTER.register(modEventBus);
        NeoForge.EVENT_BUS.addListener(Betterpcs::onPlayerJoin);
        modEventBus.addListener(Betterpcs::registerScreens);
    }

    @SubscribeEvent
    private static void registerScreens(RegisterMenuScreensEvent event) {
        event.register(BPCSAllMenus.IR_MENU.get(), IRScreen::new);
    }

    private static void onPlayerJoin(PlayerEvent.PlayerLoggedInEvent event) {
        Player player = event.getEntity();
        if (!DockerClientFactory.instance().isDockerAvailable()) {
            player.sendSystemMessage(Component.literal("Docker Not Found, Better PCs is disabled"));
            Globals.DISABLE_WHOLE_MOD = 1;
        }
        else {
            player.sendSystemMessage(Component.literal("Docker found, enjoy Better PCs"));
        }
    }
}
