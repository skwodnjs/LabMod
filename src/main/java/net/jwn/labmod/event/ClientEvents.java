package net.jwn.labmod.event;

import net.jwn.labmod.Main;
import net.jwn.labmod.client.ExampleHubOverlay;
import net.jwn.labmod.experiments.SideOnlyTest;
import net.jwn.labmod.item.ModItems;
import net.jwn.labmod.util.KeyBindings;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ClientEvents {
    @Mod.EventBusSubscriber(modid = Main.MOD_ID, value = Dist.CLIENT)
    public static class ClientForgeEvents {
        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event) {
            Player player = Minecraft.getInstance().player;
            if (KeyBindings.ONE_KEY.consumeClick()) {
                if (player.getMainHandItem().getItem() == ModItems.TEST_ITEM.get()) {
                    if (player.getMainHandItem().getCount() == 1) {
                        player.sendSystemMessage(Component.literal("skill 1"));
                        SideOnlyTest.clientOnlyMethod(player);
//                        SideOnlyTest.serverOnlyMethod(Minecraft.getInstance().player);}
                    } else if (player.getMainHandItem().getCount() == 2) {
                        player.setDeltaMovement(0, 0.5, 0);
                    } else if (player.getMainHandItem().getCount() == 3) {
                        ExampleHubOverlay.button();
                    }
                }
            }
        }
    }

    @Mod.EventBusSubscriber(modid = Main.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents {
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event) {
            event.register(KeyBindings.ONE_KEY);
        }

        @SubscribeEvent
        public static void onRegisterGuiOverlaysEvent(RegisterGuiOverlaysEvent event) {
            System.out.println("RegisterGuiOverlaysEvent");
            event.registerAboveAll("example_gui", ExampleHubOverlay.HUD_EXAMPLE);
        }
    }
}
