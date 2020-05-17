package com.novamachina.exnihilosequentia;

import com.novamachina.exnihilosequentia.client.setup.ClientSetup;
import com.novamachina.exnihilosequentia.common.loot.modifier.UseHammerModifier;
import com.novamachina.exnihilosequentia.common.setup.ModInitialization;
import com.novamachina.exnihilosequentia.common.utility.Config;
import com.novamachina.exnihilosequentia.common.utility.Constants;
import com.novamachina.exnihilosequentia.common.utility.Constants.ModInfo;
import com.novamachina.exnihilosequentia.common.utility.LogUtil;
import javax.annotation.Nonnull;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Constants.ModInfo.MOD_ID)
public class ExNihiloSequentia {

    public static boolean itemRegistrationFinished = false;

    public ExNihiloSequentia() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.COMMON_CONFIG);

        ModInitialization.init(FMLJavaModLoadingContext.get().getModEventBus());

        FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientSetup::init);
    }

    @EventBusSubscriber(modid = ModInfo.MOD_ID, bus = Bus.MOD)
    public static class EventHandlers {

        @SubscribeEvent
        public static void registerModifierSerializers(
            @Nonnull final RegistryEvent.Register<GlobalLootModifierSerializer<?>> event) {
            LogUtil.info("Register Modifiers");
            event.getRegistry()
                .register(new UseHammerModifier.Serializer()
                    .setRegistryName(ModInfo.MOD_ID, "use_hammer"));
        }
    }

//    public void onModLoading(FMLLoadCompleteEvent event) {
//        RegistryManager.ACTIVE.getRegistry(GameData.BLOCKS).getRaw(new ResourceLocation("minecraft","cobblestone"));
//        RegistryManager.ACTIVE.getRegistry(GameData.BLOCKS).getEntries();
//    }
}