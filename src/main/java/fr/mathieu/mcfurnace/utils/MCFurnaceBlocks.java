package fr.mathieu.mcfurnace.utils;

import fr.mathieu.mcfurnace.furnace.simplefurnace.basicfurnace.BasicFurnaceBlock;
import fr.mathieu.mcfurnace.furnace.simplefurnace.basicfurnace.BasicFurnaceTileEntity;
import fr.mathieu.mcfurnace.furnace.simplefurnace.diamondfurnace.DiamondFurnaceBlock;
import fr.mathieu.mcfurnace.furnace.simplefurnace.diamondfurnace.DiamondFurnaceTileEntity;
import fr.mathieu.mcfurnace.furnace.simplefurnace.goldfurnace.GoldFurnaceBlock;
import fr.mathieu.mcfurnace.furnace.simplefurnace.goldfurnace.GoldFurnaceTileEntity;
import fr.mathieu.mcfurnace.furnace.simplegenerator.basicgenerator.BasicGenerator;
import fr.mathieu.mcfurnace.furnace.simplegenerator.basicgenerator.BasicGeneratorTileEntity;
import fr.mathieu.mcfurnace.furnace.simplegenerator.diamondgenerator.DiamondGenerator;
import fr.mathieu.mcfurnace.furnace.simplegenerator.diamondgenerator.DiamondGeneratorTileEntity;
import fr.mathieu.mcfurnace.furnace.simplegenerator.goldgenerator.GoldGenerator;
import fr.mathieu.mcfurnace.furnace.simplegenerator.goldgenerator.GoldGeneratorTileEntity;
import fr.mathieu.mcfurnace.furnace.simplegenerator.irongenerator.IronGenerator;
import fr.mathieu.mcfurnace.furnace.simplegenerator.irongenerator.IronGeneratorTileEntity;
import fr.mathieu.mcfurnace.furnace.simplegenerator.model.container.SimpleGeneratorContainer;
import fr.mathieu.mcfurnace.furnace.simplegenerator.model.gui.SimpleGeneratorScreen;
import fr.mathieu.mcfurnace.items.MCFurnaceCard;
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
public class MCFurnaceBlocks {

    /* used to register blocks and items */

    // list of all blocks and their registry name

    // furnaces

    @ObjectHolder(MCFurnaceMain.MOD_ID + ":basic_furnace")
    public static BasicFurnaceBlock BASIC_FURNACE;

    @ObjectHolder(MCFurnaceMain.MOD_ID + ":gold_furnace")
    public static GoldFurnaceBlock GOLD_FURNACE;

    @ObjectHolder(MCFurnaceMain.MOD_ID + ":diamond_furnace")
    public static DiamondFurnaceBlock DIAMOND_FURNACE;

    //

    // generators

    @ObjectHolder(MCFurnaceMain.MOD_ID + ":basic_generator")
    public static BasicGenerator BASIC_GENERATOR;

    @ObjectHolder(MCFurnaceMain.MOD_ID + ":iron_generator")
    public static IronGenerator IRON_GENERATOR;

    @ObjectHolder(MCFurnaceMain.MOD_ID + ":gold_generator")
    public static GoldGenerator GOLD_GENERATOR;

    @ObjectHolder(MCFurnaceMain.MOD_ID + ":diamond_generator")
    public static DiamondGenerator DIAMOND_GENERATOR;



    //

    // tileEntityTypes

    public static TileEntityType<BasicFurnaceTileEntity> BASIC_FURNACE_TE;
    public static TileEntityType<GoldFurnaceTileEntity> GOLD_FURNACE_TE;
    public static TileEntityType<DiamondFurnaceTileEntity> DIAMOND_FURNACE_TE;

    public static TileEntityType<BasicGeneratorTileEntity> BASIC_GENERATOR_TE;
    public static TileEntityType<IronGeneratorTileEntity> IRON_GENERATOR_TE;
    public static TileEntityType<GoldGeneratorTileEntity> GOLD_GENERATOR_TE;
    public static TileEntityType<DiamondGeneratorTileEntity> DIAMOND_GENERATOR_TE;

    //

    // containers

    public static ContainerType<SimpleGeneratorContainer> SIMPLE_GENERATOR_C;

    //

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> registryEvent) {

        Block.Properties furnaceLikeProperties = Block.Properties.from(Blocks.FURNACE);

        MCRegistryUtil.registerBlock(new BasicFurnaceBlock(furnaceLikeProperties), ":basic_furnace", registryEvent);
        MCRegistryUtil.registerBlock(new GoldFurnaceBlock(furnaceLikeProperties), ":gold_furnace", registryEvent);
        MCRegistryUtil.registerBlock(new DiamondFurnaceBlock(furnaceLikeProperties), ":diamond_furnace", registryEvent);

        Block.Properties stoneLikeProperties = Block.Properties.from(Blocks.STONE);

        MCRegistryUtil.registerBlock(new BasicGenerator(stoneLikeProperties), ":basic_generator", registryEvent);
        MCRegistryUtil.registerBlock(new IronGenerator(stoneLikeProperties), ":iron_generator", registryEvent);
        MCRegistryUtil.registerBlock(new GoldGenerator(stoneLikeProperties), ":gold_generator", registryEvent);
        MCRegistryUtil.registerBlock(new DiamondGenerator(stoneLikeProperties), ":diamond_generator", registryEvent);

    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> registryEvent) {

        Item.Properties properties = new Item.Properties().group(ItemGroup.MATERIALS);

        MCRegistryUtil.registerItem(new MagmaCoal(properties), ":magma_coal", registryEvent);
        MCRegistryUtil.registerItem(new MagmaCharcoal(properties), ":magma_charcoal", registryEvent);

        JSONFileGenerator jsonFileGenerator = new JSONFileGenerator();
        MCFurnaceCard[] cards = jsonFileGenerator.generate(false);

        registryEvent.getRegistry().registerAll(cards);

    }

    @SubscribeEvent
    public static void registerBlockItem(RegistryEvent.Register<Item> registryEvent) {

        Item.Properties properties = new Item.Properties().group(ItemGroup.DECORATIONS);

        registryEvent.getRegistry().register(new BlockItem(BASIC_FURNACE, properties).setRegistryName(BASIC_FURNACE.getRegistryName()));
        registryEvent.getRegistry().register(new BlockItem(GOLD_FURNACE, properties).setRegistryName(GOLD_FURNACE.getRegistryName()));
        registryEvent.getRegistry().register(new BlockItem(DIAMOND_FURNACE, properties).setRegistryName(DIAMOND_FURNACE.getRegistryName()));

        registryEvent.getRegistry().register(new BlockItem(BASIC_GENERATOR, properties).setRegistryName(BASIC_GENERATOR.getRegistryName()));
        registryEvent.getRegistry().register(new BlockItem(IRON_GENERATOR, properties).setRegistryName(IRON_GENERATOR.getRegistryName()));
        registryEvent.getRegistry().register(new BlockItem(GOLD_GENERATOR, properties).setRegistryName(GOLD_GENERATOR.getRegistryName()));
        registryEvent.getRegistry().register(new BlockItem(DIAMOND_GENERATOR, properties).setRegistryName(DIAMOND_GENERATOR.getRegistryName()));

    }

    @SubscribeEvent
    public static void registerTileEntities(RegistryEvent.Register<TileEntityType<?>> registryEvent) {

        BASIC_FURNACE_TE = MCRegistryUtil.registerTileEntity(BasicFurnaceTileEntity::new, "myte", BASIC_FURNACE, registryEvent);
        GOLD_FURNACE_TE = MCRegistryUtil.registerTileEntity(GoldFurnaceTileEntity::new, "myte1", GOLD_FURNACE, registryEvent);
        DIAMOND_FURNACE_TE = MCRegistryUtil.registerTileEntity(DiamondFurnaceTileEntity::new, "myte2", DIAMOND_FURNACE, registryEvent);

        BASIC_GENERATOR_TE = MCRegistryUtil.registerTileEntity(BasicGeneratorTileEntity::new, "myte3", BASIC_GENERATOR, registryEvent);
        IRON_GENERATOR_TE = MCRegistryUtil.registerTileEntity(IronGeneratorTileEntity::new, "myte4", IRON_GENERATOR, registryEvent);
        GOLD_GENERATOR_TE = MCRegistryUtil.registerTileEntity(GoldGeneratorTileEntity::new, "myte5", GOLD_GENERATOR, registryEvent);
        DIAMOND_GENERATOR_TE = MCRegistryUtil.registerTileEntity(DiamondGeneratorTileEntity::new, "myte6", DIAMOND_GENERATOR, registryEvent);

    }

    @SubscribeEvent
    public static void registerContainerTypes(RegistryEvent.Register<ContainerType<?>> registryEvent) {
        SIMPLE_GENERATOR_C = IForgeContainerType.create(SimpleGeneratorContainer::new);
        SIMPLE_GENERATOR_C.setRegistryName("container");
        registryEvent.getRegistry().register(SIMPLE_GENERATOR_C);
    }

    @SubscribeEvent
    public static void setup(FMLClientSetupEvent event) {
        ScreenManager.registerFactory(SIMPLE_GENERATOR_C, SimpleGeneratorScreen::new);

    }

}
