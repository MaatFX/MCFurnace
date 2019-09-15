package fr.mathieu.mcfurnace.utils;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tileentity.LockableTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;

import java.util.function.Supplier;

public abstract class MCRegistryUtil {

    public static void registerBlock(Block b, String registryName, RegistryEvent.Register<Block> registryEvent) {
        b.setRegistryName(registryName);
        registryEvent.getRegistry().register(b);
    }

    public static void registerItem(Item i, String registryName, RegistryEvent.Register<Item> registryEvent) {
        i.setRegistryName(registryName);
        registryEvent.getRegistry().register(i);
    }

    public static TileEntityType registerTileEntity(Supplier<LockableTileEntity> supplier, String registryName, Block block, RegistryEvent.Register<TileEntityType<?>> registryEvent) {
        TileEntityType tileEntityType = TileEntityType.Builder.create(supplier, block).build(null);
        tileEntityType.setRegistryName(registryName);
        registryEvent.getRegistry().register(tileEntityType);
        return tileEntityType;
    }

}
