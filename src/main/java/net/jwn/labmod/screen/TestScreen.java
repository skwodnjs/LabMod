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

        // width 176 height 166

        this.leftPos = (width - 176) / 2;
        this.topPos = (height - 166) / 2;

        this.health = new ImageWidget(this.leftPos + 13, this.topPos + 23, 12, 12, NO_IMAGE_RESOURCE);
        this.damage = new ImageWidget(this.leftPos + 13, this.topPos + 36, 12, 12, DAMAGE_RESOURCE);
        this.attack_speed = new ImageWidget(this.leftPos + 50, this.topPos + 23, 12, 12, NO_IMAGE_RESOURCE);
        this.attack_range = new ImageWidget(this.leftPos + 50, this.topPos + 36, 12, 12, NO_IMAGE_RESOURCE);
        this.mining_speed = new ImageWidget(this.leftPos + 87, this.topPos + 23, 12, 12, NO_IMAGE_RESOURCE);
        this.movement_speed = new ImageWidget(this.leftPos + 87, this.topPos + 36, 12, 12, NO_IMAGE_RESOURCE);
        this.luck = new ImageWidget(this.leftPos + 124, this.topPos + 23, 12, 12, NO_IMAGE_RESOURCE);
        this.coin = new ImageWidget(this.leftPos + 124, this.topPos + 36, 12, 12, NO_IMAGE_RESOURCE);

        this.health.setTooltip(Tooltip.create(Component.literal("health")));
        this.damage.setTooltip(Tooltip.create(Component.literal("damage")));
        this.attack_speed.setTooltip(Tooltip.create(Component.literal("attack_speed")));
        this.attack_range.setTooltip(Tooltip.create(Component.literal("attack_range")));
        this.mining_speed.setTooltip(Tooltip.create(Component.literal("mining_speed")));
        this.movement_speed.setTooltip(Tooltip.create(Component.literal("movement_speed")));
        this.luck.setTooltip(Tooltip.create(Component.literal("luck")));
        this.coin.setTooltip(Tooltip.create(Component.literal("coin")));

        addRenderableWidget(this.health);
        addRenderableWidget(this.damage);
        addRenderableWidget(this.attack_speed);
        addRenderableWidget(this.attack_range);
        addRenderableWidget(this.mining_speed);
        addRenderableWidget(this.movement_speed);
        addRenderableWidget(this.luck);
        addRenderableWidget(this.coin);

        this.delete = new ImageButton(this.leftPos + 152, this.topPos + 65, 16, 16, 52, 166, 0,
                BACKGROUND_RESOURCE, 256, 256,
                pButton -> {
            flag = !flag;
            rebuildWidgets();
        });
        addRenderableWidget(this.delete);

        for (int i = 0; i < slots.length; i++) {
            this.slots[i] = new ImageButton(this.leftPos + 8 + 18 * (i % 9), this.topPos + 89 + 24 * (i / 9), 16, 16, 0, 0, 0, NO_IMAGE_RESOURCE, 16, 16, pButton -> {});
            addRenderableWidget(this.slots[i]);
        }

        this.lock = new ImageButton(this.leftPos + 18, this.topPos + 99, 7, 7, 68, 166, 0, BACKGROUND_RESOURCE, 256, 256, pButton -> {});
        if (flag) {
            addRenderableWidget(this.lock);
        }
    }

    @Override
    public void render(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        renderBackground(pGuiGraphics);
        pGuiGraphics.blit(BACKGROUND_RESOURCE, leftPos, topPos, 0, 0, 176, 166);
        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);

        pGuiGraphics.drawString(this.font, "Stuff I Found", this.leftPos + 7, this.topPos + 7, 0x404040, false);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    @Override
    public boolean keyPressed(int pKeyCode, int pScanCode, int pModifiers) {
        if (pKeyCode == GLFW.GLFW_KEY_Z) {
            this.onClose();
            return true;
        }
        return super.keyPressed(pKeyCode, pScanCode, pModifiers);
    }
}
