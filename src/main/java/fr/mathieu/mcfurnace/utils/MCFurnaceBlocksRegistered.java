package fr.mathieu.mcfurnace.utils;

import fr.mathieu.mcfurnace.furnace.basicfurnace.BasicFurnaceBlock;
import fr.mathieu.mcfurnace.furnace.basicfurnace.BasicFurnaceTileEntity;
import fr.mathieu.mcfurnace.furnace.diamondfurnace.DiamondFurnaceBlock;
import fr.mathieu.mcfurnace.furnace.diamondfurnace.DiamondFurnaceTileEntity;

import fr.mathieu.mcfurnace.furnace.diamondfurnace.container.DiamondFurnaceContainer;
import fr.mathieu.mcfurnace.furnace.diamondfurnace.gui.DiamondFurnaceScreen;
import fr.mathieu.mcfurnace.furnace.goldfurnace.GoldFurnaceBlock;
import fr.mathieu.mcfurnace.furnace.goldfurnace.GoldFurnaceTileEntity;
import fr.mathieu.mcfurnace.furnace.goldfurnace.container.GoldFurnaceContainer;
import fr.mathieu.mcfurnace.furnace.goldfurnace.gui.GoldFurnaceScreen;
import fr.mathieu.mcfurnace.items.MagmaCharcoal;
import fr.mathieu.mcfurnace.items.MagmaCoal;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
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

    // items

    @ObjectHolder(MCFurnaceMain.MOD_ID + ":magma_coal")
    public static MagmaCoal MAGMA_COAL = null;

    @ObjectHolder(MCFurnaceMain.MOD_ID + ":magma_charcoal")
    public static  MagmaCharcoal MAGMA_CHARCOAL = null;

    public static TileEntityType<BasicFurnaceTileEntity> BASIC_FURNACE_TE = null;

    public static TileEntityType<GoldFurnaceTileEntity> GOLD_FURNACE_TE = null;

    public static TileEntityType<DiamondFurnaceTileEntity> DIAMOND_FURNACE_TE = null;


    public static ContainerType<DiamondFurnaceContainer> DIAMOND_FURNACE_CONTAINER = null;

    public static ContainerType<GoldFurnaceContainer> GOLD_FURNACE_CONTAINER = null;

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

    @SubscribeEvent
    public static void registerContainerType(final RegistryEvent.Register<ContainerType<?>> event) {
        DIAMOND_FURNACE_CONTAINER = IForgeContainerType.create(DiamondFurnaceContainer::new);
        DIAMOND_FURNACE_CONTAINER.setRegistryName(MCFurnaceMain.MOD_ID, "container");

        GOLD_FURNACE_CONTAINER = IForgeContainerType.create(GoldFurnaceContainer::new);
        GOLD_FURNACE_CONTAINER.setRegistryName(MCFurnaceMain.MOD_ID, "container1");

        event.getRegistry().registerAll(DIAMOND_FURNACE_CONTAINER, GOLD_FURNACE_CONTAINER);
    }

    @SubscribeEvent
    public static void setup(FMLClientSetupEvent event) {
        ScreenManager.registerFactory(DIAMOND_FURNACE_CONTAINER, DiamondFurnaceScreen::new);

        ScreenManager.registerFactory(GOLD_FURNACE_CONTAINER, GoldFurnaceScreen::new);

    }


}
