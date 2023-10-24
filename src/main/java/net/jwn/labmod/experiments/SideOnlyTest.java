package net.jwn.labmod.experiments;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class SideOnlyTest {
    @OnlyIn(Dist.CLIENT)
    public static void clientOnlyMethod(Player player) {
        player.displayClientMessage(Component.literal("client only message"), false);
    }

    @OnlyIn(Dist.DEDICATED_SERVER)
    public static void serverOnlyMethod(Player player) {
        player.displayClientMessage(Component.literal("server only message"), false);
    }

    // OnlyIn DEDICATED_SERVER 는 클라이언트에서 실행했을 때 그냥 팅겨버린다.
}
