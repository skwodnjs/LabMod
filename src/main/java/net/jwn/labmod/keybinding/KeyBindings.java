package net.jwn.labmod.keybinding;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class KeyBindings {
    public static final String KEY_CATEGORY_UTILS = "key.category.lab_mod.utils";

    public static final String KEY_ONE = "key.lab_mod.one";
    public static final KeyMapping ONE_KEY =
            new KeyMapping(KEY_ONE, KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_Z, KEY_CATEGORY_UTILS);

    // go to client events
}
