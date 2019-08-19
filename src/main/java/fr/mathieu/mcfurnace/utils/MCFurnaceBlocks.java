package fr.mathieu.mcfurnace.utils;

import fr.mathieu.mcfurnace.furnace.adiamondfurnace.ADiamondFurnaceBlock;
import fr.mathieu.mcfurnace.furnace.adiamondfurnace.ADiamondFurnaceTileEntity;
import fr.mathieu.mcfurnace.furnace.adiamondfurnace.container.ADiamondFurnaceContainer;
import fr.mathieu.mcfurnace.furnace.adiamondfurnace.gui.ADiamondFurnaceScreen;
import fr.mathieu.mcfurnace.furnace.agoldfurnace.AGoldFurnaceBlock;
import fr.mathieu.mcfurnace.furnace.agoldfurnace.AGoldFurnaceTileEntity;
import fr.mathieu.mcfurnace.furnace.agoldfurnace.container.AGoldFurnaceContainer;
import fr.mathieu.mcfurnace.furnace.agoldfurnace.gui.AGoldFurnaceScreen;
import fr.mathieu.mcfurnace.furnace.basicfurnace.BasicFurnaceBlock;
import fr.mathieu.mcfurnace.furnace.basicfurnace.BasicFurnaceTileEntity;
import fr.mathieu.mcfurnace.furnace.diamondfurnace.DiamondFurnaceBlock;
import fr.mathieu.mcfurnace.furnace.diamondfurnace.DiamondFurnaceTileEntity;
import fr.mathieu.mcfurnace.furnace.goldfurnace.GoldFurnaceBlock;
import fr.mathieu.mcfurnace.furnace.goldfurnace.GoldFurnaceTileEntity;
import fr.mathieu.mcfurnace.items.MagmaCharcoal;
import fr.mathieu.mcfurnace.items.MagmaCoal;

import net.minecraft.block.AbstractFurnaceBlock;
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
public class MCFurnaceBlocks {

    /* used to register blocks and items */

    // list of all blocks and their registry name

    @ObjectHolder(MCFurnaceMain.MOD_ID + ":basic_furnace")
    public static BasicFurnaceBlock BASIC_FURNACE = null;

    @ObjectHolder(MCFurnaceMain.MOD_ID + ":gold_furnace")
    public static GoldFurnaceBlock GOLD_FURNACE = null;

    @ObjectHolder(MCFurnaceMain.MOD_ID + ":diamond_furnace")
    public static DiamondFurnaceBlock DIAMOND_FURNACE = null;

    @ObjectHolder(MCFurnaceMain.MOD_ID + ":agold_furnace")
    public static AGoldFurnaceBlock AGOLD_FURNACE = null;

    @ObjectHolder(MCFurnaceMain.MOD_ID + ":adiamond_furnace")
    public static ADiamondFurnaceBlock ADIAMOND_FURNACE = null;

    @ObjectHolder(MCFurnaceMain.MOD_ID + ":magma_coal")
    public static MagmaCoal MAGMA_COAL = null;

    @ObjectHolder(MCFurnaceMain.MOD_ID + ":magma_charcoal")
    public static  MagmaCharcoal MAGMA_CHARCOAL = null;


    public static TileEntityType<BasicFurnaceTileEntity> BASIC_FURNACE_TE = null;
    public static TileEntityType<GoldFurnaceTileEntity> GOLD_FURNACE_TE = null;
    public static TileEntityType<DiamondFurnaceTileEntity> DIAMOND_FURNACE_TE = null;
    public static TileEntityType<AGoldFurnaceTileEntity> AGOLD_FURNACE_TE = null;
    public static TileEntityType<ADiamondFurnaceTileEntity> ADIAMOND_FURNACE_TE = null;


    public static ContainerType<AGoldFurnaceContainer> AGOLD_FURNACE_C = null;
    public static ContainerType<ADiamondFurnaceContainer> ADIAMOND_FURNACE_C = null;


    public static AbstractFurnaceBlock[] blocks = {BASIC_FURNACE, GOLD_FURNACE, DIAMOND_FURNACE, AGOLD_FURNACE, ADIAMOND_FURNACE};


    @SubscribeEvent
    public static void registerBlock(RegistryEvent.Register<Block> registryEvent) {

        Block.Properties properties = Block.Properties.from(Blocks.FURNACE);

        BASIC_FURNACE = new BasicFurnaceBlock(properties);
        BASIC_FURNACE.setRegistryName("basic_furnace");

        GOLD_FURNACE = new GoldFurnaceBlock(properties);
        GOLD_FURNACE.setRegistryName("gold_furnace");


        DIAMOND_FURNACE = new DiamondFurnaceBlock(properties);
        DIAMOND_FURNACE.setRegistryName("diamond_furnace");

        AGOLD_FURNACE = new AGoldFurnaceBlock(properties);
        AGOLD_FURNACE.setRegistryName("agold_furnace");

        ADIAMOND_FURNACE = new ADiamondFurnaceBlock(properties);
        ADIAMOND_FURNACE.setRegistryName("adiamond_furnace");

        registryEvent.getRegistry().registerAll(BASIC_FURNACE, GOLD_FURNACE, DIAMOND_FURNACE, AGOLD_FURNACE,
                ADIAMOND_FURNACE);

    }

    @SubscribeEvent
    public static void registerItem(RegistryEvent.Register<Item> registryEvent) {

        Item.Properties properties = new Item.Properties().group(ItemGroup.MATERIALS);

        MAGMA_COAL = new MagmaCoal(properties);
        MAGMA_COAL.setRegistryName("magma_coal");

        MAGMA_CHARCOAL = new MagmaCharcoal(properties);
        MAGMA_CHARCOAL.setRegistryName("magma_charcoal");

        registryEvent.getRegistry().registerAll(MAGMA_COAL, MAGMA_CHARCOAL);
    }

    @SubscribeEvent
    public static void registerBlockItem(RegistryEvent.Register<Item> registryEvent) {

        Item.Properties properties = new Item.Properties().group(ItemGroup.DECORATIONS);

        registryEvent.getRegistry().register(new BlockItem(BASIC_FURNACE, properties).setRegistryName(BASIC_FURNACE.getRegistryName()));

        registryEvent.getRegistry().register(new BlockItem(GOLD_FURNACE, properties).setRegistryName(GOLD_FURNACE.getRegistryName()));

        registryEvent.getRegistry().register(new BlockItem(DIAMOND_FURNACE, properties).setRegistryName(DIAMOND_FURNACE.getRegistryName()));

        registryEvent.getRegistry().register(new BlockItem(AGOLD_FURNACE, properties).setRegistryName(AGOLD_FURNACE.getRegistryName()));

        registryEvent.getRegistry().register(new BlockItem(ADIAMOND_FURNACE, properties).setRegistryName(ADIAMOND_FURNACE.getRegistryName()));


    }

    @SubscribeEvent
    public static void registerTileEntity(RegistryEvent.Register<TileEntityType<?>> registryEvent) {

        BASIC_FURNACE_TE = TileEntityType.Builder.create(BasicFurnaceTileEntity::new, BASIC_FURNACE).build(null);
        BASIC_FURNACE_TE.setRegistryName(MCFurnaceMain.MOD_ID, "myte");

        GOLD_FURNACE_TE = TileEntityType.Builder.create(GoldFurnaceTileEntity::new, GOLD_FURNACE).build(null);
        GOLD_FURNACE_TE.setRegistryName(MCFurnaceMain.MOD_ID, "myte1");

        DIAMOND_FURNACE_TE = TileEntityType.Builder.create(DiamondFurnaceTileEntity::new, DIAMOND_FURNACE).build(null);
        DIAMOND_FURNACE_TE.setRegistryName(MCFurnaceMain.MOD_ID, "myte2");

        AGOLD_FURNACE_TE = TileEntityType.Builder.create(AGoldFurnaceTileEntity::new, AGOLD_FURNACE).build(null);
        AGOLD_FURNACE_TE.setRegistryName(MCFurnaceMain.MOD_ID, "myte3");

        ADIAMOND_FURNACE_TE = TileEntityType.Builder.create(ADiamondFurnaceTileEntity::new, ADIAMOND_FURNACE).build(null);
        ADIAMOND_FURNACE_TE.setRegistryName(MCFurnaceMain.MOD_ID, "myte4");

        registryEvent.getRegistry().registerAll(BASIC_FURNACE_TE, GOLD_FURNACE_TE, DIAMOND_FURNACE_TE, AGOLD_FURNACE_TE, ADIAMOND_FURNACE_TE);

    }

    @SubscribeEvent
    public static void registerContainerType(RegistryEvent.Register<ContainerType<?>> registryEvent) {
        AGOLD_FURNACE_C = IForgeContainerType.create(AGoldFurnaceContainer::new);
        AGOLD_FURNACE_C.setRegistryName("container1");

        ADIAMOND_FURNACE_C = IForgeContainerType.create(ADiamondFurnaceContainer::new);
        ADIAMOND_FURNACE_C.setRegistryName("container2");

        registryEvent.getRegistry().registerAll(AGOLD_FURNACE_C, ADIAMOND_FURNACE_C);
    }

    @SubscribeEvent
    public static void setup(FMLClientSetupEvent event) {
        ScreenManager.registerFactory(AGOLD_FURNACE_C, AGoldFurnaceScreen::new);
        ScreenManager.registerFactory(ADIAMOND_FURNACE_C, ADiamondFurnaceScreen::new);
    }

}
