package net.jwn.labmod.screen;

import net.jwn.labmod.Main;
import net.jwn.labmod.block.ModBlocks;
import net.jwn.labmod.item.ModItems;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.ImageWidget;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.lwjgl.glfw.GLFW;

public class TestScreen extends Screen {
    public TestScreen() {
        super(Component.literal("test screen"));
    }

    private int leftPos, topPos;
    private ImageWidget health, damage, attack_speed, attack_range, mining_speed, movement_speed, luck, coin;
    private ImageButton delete;
    private ImageButton lock;
    private ImageButton[] slots = new ImageButton[27];

    private boolean flag = true;

    private static final ResourceLocation BACKGROUND_RESOURCE = new ResourceLocation(Main.MOD_ID, "textures/gui/screen1.png");
    private static final ResourceLocation DAMAGE_RESOURCE = new ResourceLocation(Main.MOD_ID, "textures/stat/damage.png");
    private static final ResourceLocation NO_IMAGE_RESOURCE = new ResourceLocation(Main.MOD_ID, "textures/item/no_image.png");

    @Override
    protected void init() {
        super.init();

        leftPos = (width - 176) / 2;
        topPos = (height - 166) / 2;

        health = new ImageWidget(leftPos + 13, topPos + 23, 12, 12, NO_IMAGE_RESOURCE);
        damage = new ImageWidget(leftPos + 13, topPos + 36, 12, 12, DAMAGE_RESOURCE);
        attack_speed = new ImageWidget(leftPos + 50, topPos + 23, 12, 12, NO_IMAGE_RESOURCE);
        attack_range = new ImageWidget(leftPos + 50, topPos + 36, 12, 12, NO_IMAGE_RESOURCE);
        mining_speed = new ImageWidget(leftPos + 87, topPos + 23, 12, 12, NO_IMAGE_RESOURCE);
        movement_speed = new ImageWidget(leftPos + 87, topPos + 36, 12, 12, NO_IMAGE_RESOURCE);
        luck = new ImageWidget(leftPos + 124, topPos + 23, 12, 12, NO_IMAGE_RESOURCE);
        coin = new ImageWidget(leftPos + 124, topPos + 36, 12, 12, NO_IMAGE_RESOURCE);

        health.setTooltip(Tooltip.create(Component.literal("health")));
        damage.setTooltip(Tooltip.create(Component.literal("damage")));
        attack_speed.setTooltip(Tooltip.create(Component.literal("attack_speed")));
        attack_range.setTooltip(Tooltip.create(Component.literal("attack_range")));
        mining_speed.setTooltip(Tooltip.create(Component.literal("mining_speed")));
        movement_speed.setTooltip(Tooltip.create(Component.literal("movement_speed")));
        luck.setTooltip(Tooltip.create(Component.literal("luck")));
        coin.setTooltip(Tooltip.create(Component.literal("coin")));

        addRenderableWidget(health);
        addRenderableWidget(damage);
        addRenderableWidget(attack_speed);
        addRenderableWidget(attack_range);
        addRenderableWidget(mining_speed);
        addRenderableWidget(movement_speed);
        addRenderableWidget(luck);
        addRenderableWidget(coin);

        delete = new ImageButton(leftPos + 152, topPos + 65, 16, 16, 52, 166, 0,
                BACKGROUND_RESOURCE, 256, 256,
                pButton -> {
            flag = !flag;
            rebuildWidgets();
        });
        addRenderableWidget(delete);

        for (int i = 0; i < slots.length; i++) {
            slots[i] = new ImageButton(leftPos + 8 + 18 * (i % 9), topPos + 89 + 24 * (i / 9), 16, 16, 0, 0, 0, NO_IMAGE_RESOURCE, 16, 16, pButton -> {});
            addRenderableWidget(slots[i]);
        }

        lock = new ImageButton(leftPos + 18, topPos + 99, 7, 7, 68, 166, 0, BACKGROUND_RESOURCE, 256, 256, pButton -> {});
        if (flag) {
            addRenderableWidget(lock);
        }
    }

    @Override
    public void render(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        renderBackground(pGuiGraphics);
        pGuiGraphics.blit(BACKGROUND_RESOURCE, leftPos, topPos, 0, 0, 176, 166);
        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
        
        pGuiGraphics.drawString(font, "Stuff I Found", leftPos + 7, topPos + 7, 0x404040, false);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    @Override
    public boolean keyPressed(int pKeyCode, int pScanCode, int pModifiers) {
        if (pKeyCode == GLFW.GLFW_KEY_Z) {
            onClose();
            return true;
        }
        return super.keyPressed(pKeyCode, pScanCode, pModifiers);
    }
}
