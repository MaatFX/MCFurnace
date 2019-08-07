package fr.mathieu.mcfurnace.utils;

import fr.mathieu.mcfurnace.furnace.basicfurnace.BasicFurnaceBlock;
import fr.mathieu.mcfurnace.furnace.basicfurnace.BasicFurnaceTileEntity;
import fr.mathieu.mcfurnace.furnace.diamondfurnace.DiamondFurnaceBlock;
import fr.mathieu.mcfurnace.furnace.diamondfurnace.DiamondFurnaceTileEntity;
import fr.mathieu.mcfurnace.furnace.goldfurnace.GoldFurnaceBlock;
import fr.mathieu.mcfurnace.furnace.goldfurnace.GoldFurnaceTileEntity;
import fr.mathieu.mcfurnace.items.MagmaCharcoal;
import fr.mathieu.mcfurnace.items.MagmaCoal;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;


@Mod.EventBusSubscriber(modid = MCFurnaceMain.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MCFurnaceBlocksRegistered {

    /* used to register blocks and items */

    // list of all blocks and their registry name

    @ObjectHolder(MCFurnaceMain.MOD_ID + ":basic_furnace")
    public static BasicFurnaceBlock BASIC_FURNACE = null;

    @ObjectHolder(MCFurnaceMain.MOD_ID + ":gold_furnace")
    public static GoldFurnaceBlock GOLD_FURNACE = null;

    @ObjectHolder(MCFurnaceMain.MOD_ID + ":diamond_furnace")
    public static DiamondFurnaceBlock DIAMOND_FURNACE = null;

    @ObjectHolder(MCFurnaceMain.MOD_ID + ":magma_coal")
    public static MagmaCoal MAGMA_COAL = null;

    @ObjectHolder(MCFurnaceMain.MOD_ID + ":magma_charcoal")
    public static  MagmaCharcoal MAGMA_CHARCOAL = null;

    public static TileEntityType<BasicFurnaceTileEntity> BASIC_FURNACE_TE = null;

    public static TileEntityType<GoldFurnaceTileEntity> GOLD_FURNACE_TE = null;

    public static TileEntityType<DiamondFurnaceTileEntity> DIAMOND_FURNACE_TE = null;

    @SubscribeEvent
    public static void registerBlock(final RegistryEvent.Register<Block> registryEvent) {

        // basic furnace

        BASIC_FURNACE = new BasicFurnaceBlock(Block.Properties.from(Blocks.FURNACE));
        BASIC_FURNACE.setRegistryName("basic_furnace");

        // gold furnace

        GOLD_FURNACE = new GoldFurnaceBlock(Block.Properties.from(Blocks.FURNACE));
        GOLD_FURNACE.setRegistryName("gold_furnace");

        // diamond furnace

        DIAMOND_FURNACE = new DiamondFurnaceBlock(Block.Properties.from(Blocks.FURNACE));
        DIAMOND_FURNACE.setRegistryName("diamond_furnace");

        registryEvent.getRegistry().registerAll(BASIC_FURNACE, GOLD_FURNACE, DIAMOND_FURNACE);

    }

    @SubscribeEvent
    public static void registerItem(final RegistryEvent.Register<Item> registryEvent) {

        MAGMA_COAL = new MagmaCoal(new Item.Properties().group(ItemGroup.MATERIALS));
        MAGMA_COAL.setRegistryName("magma_coal");

        MAGMA_CHARCOAL = new MagmaCharcoal(new Item.Properties().group(ItemGroup.MATERIALS));
        MAGMA_CHARCOAL.setRegistryName("magma_charcoal");

        registryEvent.getRegistry().registerAll(MAGMA_COAL, MAGMA_CHARCOAL);
    }

    @SubscribeEvent
    public static void registerBlockItem(final RegistryEvent.Register<Item> registryEvent) {

        // basic furnace

        registryEvent.getRegistry().register(new BlockItem(BASIC_FURNACE,
                new Item.Properties().group(ItemGroup.DECORATIONS)).setRegistryName(BASIC_FURNACE.getRegistryName()));

        // gold furnace

        registryEvent.getRegistry().register(new BlockItem(GOLD_FURNACE,
                new Item.Properties().group(ItemGroup.DECORATIONS)).setRegistryName(GOLD_FURNACE.getRegistryName()));

        // diamond furnace

        registryEvent.getRegistry().register(new BlockItem(DIAMOND_FURNACE,
                new Item.Properties().group(ItemGroup.DECORATIONS)).setRegistryName(DIAMOND_FURNACE.getRegistryName()));

    }

    @SubscribeEvent
    public static void registerTileEntity(final RegistryEvent.Register<TileEntityType<?>> registryEvent) {

        BASIC_FURNACE_TE = TileEntityType.Builder.create(BasicFurnaceTileEntity::new, BASIC_FURNACE).build(null);
        BASIC_FURNACE_TE.setRegistryName(MCFurnaceMain.MOD_ID, "myte");

        GOLD_FURNACE_TE = TileEntityType.Builder.create(GoldFurnaceTileEntity::new, GOLD_FURNACE).build(null);
        GOLD_FURNACE_TE.setRegistryName(MCFurnaceMain.MOD_ID, "myte1");

        DIAMOND_FURNACE_TE = TileEntityType.Builder.create(DiamondFurnaceTileEntity::new, DIAMOND_FURNACE).build(null);
        DIAMOND_FURNACE_TE.setRegistryName(MCFurnaceMain.MOD_ID, "myte2");

        registryEvent.getRegistry().registerAll(BASIC_FURNACE_TE, GOLD_FURNACE_TE, DIAMOND_FURNACE_TE);

    }


}
