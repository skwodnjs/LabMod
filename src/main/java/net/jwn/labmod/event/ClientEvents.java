package net.jwn.labmod.event;

import net.jwn.labmod.Main;
import net.jwn.labmod.experiments.SideOnlyTest;
import net.jwn.labmod.util.KeyBindings;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ClientEvents {
    @Mod.EventBusSubscriber(modid = Main.MOD_ID, value = Dist.CLIENT)
    public static class ClientForgeEvents {
        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event) {
            if (KeyBindings.ONE_KEY.consumeClick()) {
                Minecraft.getInstance().player.sendSystemMessage(Component.literal("skill 1"));
                SideOnlyTest.clientOnlyMethod(Minecraft.getInstance().player);
//                SideOnlyTest.serverOnlyMethod(Minecraft.getInstance().player);
            }
        }
    }

    @Mod.EventBusSubscriber(modid = Main.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents {
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event) {
            event.register(KeyBindings.ONE_KEY);
        }
    }
}
