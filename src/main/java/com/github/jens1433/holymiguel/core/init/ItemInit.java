package com.github.jens1433.holymiguel.core.init;

import com.github.jens1433.holymiguel.HolyMiguel;
import com.github.jens1433.holymiguel.common.item.HolyMiguelItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {
    private ItemInit() {}

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, HolyMiguel.MODID);

    public static final RegistryObject<Item> HOLY_MIGUEL_ITEM = ITEMS.register("holy_miguel_item",
            () -> new HolyMiguelItem(new Item.Properties().fireResistant().tab(HolyMiguel.HOLY_MIGUEL_TAB)));

}
