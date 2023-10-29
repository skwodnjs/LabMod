package net.jwn.labmod.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.jwn.labmod.Main;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

public class ExampleHubOverlay {
    private static final ResourceLocation IMAGE = new ResourceLocation(Main.MOD_ID, "textures/item/no_image.png");

    private static boolean flag = true;

    public static void button() {
        flag = !flag;
    }

    public static final IGuiOverlay HUD_EXAMPLE = ((gui, guiGraphics, partialTick, screenWidth, screenHeight) -> {
        int x = screenWidth / 2;
        int y = screenHeight;

        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        RenderSystem.setShaderTexture(0, IMAGE);

        for(int i = 0; i < 10; i++) {
            guiGraphics.blit(IMAGE, x - 94 + (i * 9), y - 54, 0, 0, 12, 12,
                    12, 12);
        }
        if (flag) {
            for (int i = 0; i < 7; i++) {
                guiGraphics.drawString(Minecraft.getInstance().font, "stat " + (i + 1), 10, 10 + i * 10, 0x8b00ff, false);
            }
        }
    });
}
