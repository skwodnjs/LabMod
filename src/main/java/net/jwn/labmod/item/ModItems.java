package net.jwn.labmod.item;

import net.jwn.labmod.Main;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
<<<<<<< HEAD
=======
import net.minecraftforge.registries.RegistryObject;
>>>>>>> f2ffaafcb341428409a1489982abfb6d07900b97

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Main.MOD_ID);

<<<<<<< HEAD

=======
    public static final RegistryObject<Item> TEST_ITEM = ITEMS.register("test",
            () -> new Item(new Item.Properties()));
>>>>>>> f2ffaafcb341428409a1489982abfb6d07900b97

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> f2ffaafcb341428409a1489982abfb6d07900b97
