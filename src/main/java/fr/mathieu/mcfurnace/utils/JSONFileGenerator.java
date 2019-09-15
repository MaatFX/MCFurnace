package fr.mathieu.mcfurnace.utils;

import fr.mathieu.mcfurnace.furnace.simplegenerator.GeneratorItems;
import fr.mathieu.mcfurnace.items.MCFurnaceCard;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

import java.io.*;
import java.util.function.Function;


public class JSONFileGenerator {

    // this class is used to generate all json files for items

    private final String blockModelBasePath =  new File("").getAbsolutePath().replace("/run", "") + "/src/main/resources/assets/mcfurnace/models/item/";
    private final String blockRecipeBasePath = new File("").getAbsolutePath().replace("/run", "") + "/src/main/resources/data/mcfurnace/recipes/";

    private boolean generateFiles;

    public JSONFileGenerator()  {}

    public MCFurnaceCard[] generate() {
        int size = GeneratorItems.GENERATOR_ITEMS.length;
        MCFurnaceCard[] cards = new MCFurnaceCard[size];


        Function<MCFurnaceCard, Void> generateBlockStateFile = eCard -> {

            File f = null;
            BufferedWriter bufferedWriter = null;
            try {
                f = new File(blockModelBasePath + eCard.getRegistryName().toString().replace(MCFurnaceMain.MOD_ID + ":", "") + ".json");

                f.createNewFile();

                bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f)));

                String blockName = eCard.getFromBlock().getRegistryName().toString().replace("minecraft:", "");

                String content = "{\n" +
                        "    \"parent\": \"item/generated\",\n" +
                        "    \"textures\": {\n" +
                        "        \"layer0\": \"block/" + blockName + "\"\n" +
                        "    }\n" +
                        "}\n";

                bufferedWriter.write(content);
                bufferedWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        };

        Function<MCFurnaceCard, Void> generateRecipeFile = eCard -> {

            File f = null;
            BufferedWriter bufferedWriter = null;
            try {
                f = new File(blockRecipeBasePath + eCard.getRegistryName().toString().replace(MCFurnaceMain.MOD_ID + ":", "") + ".json");

                f.createNewFile();

                bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f)));

                String blockName  = eCard.getFromBlock().getRegistryName().toString().replace("minecraft:", "");

                String content = "{\n" +
                        "  \"type\": \"minecraft:crafting_shaped\",\n" +
                        "  \"pattern\": [\n" +
                        "    \"###\",\n" +
                        "    \"#a#\",\n" +
                        "    \"###\"\n" +
                        "  ],\n" +
                        "  \"key\": {\n" +
                        "    \"#\": {\n" +
                        "      \"item\": \"minecraft:" + blockName + "\"\n" +
                        "    },\n" +
                        "    \n" +
                        "    \"a\": {\n" +
                        "      \"item\": \"minecraft:map\"\n" +
                        "    }\n" +
                        "  },\n" +
                        "  \"result\": {\n" +
                        "    \"item\": \"" + eCard.getRegistryName() + "\"\n" +
                        "  }\n" +
                        "}";

                bufferedWriter.write(content);
                bufferedWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        };

        for (int i = 0; i < size; i++) {

            MCFurnaceCard blockItem = new MCFurnaceCard(new Item.Properties().maxDamage(32).group(ItemGroup.MISC));
            blockItem.setRegistryName(MCFurnaceMain.MOD_ID + ":extractor_card_" + i);
            blockItem.setFromBlock(GeneratorItems.GENERATOR_ITEMS[i]);

            if (generateFiles) {
                generate(generateBlockStateFile, blockItem);
                generate(generateRecipeFile, blockItem);
            }

            cards[i] = blockItem;
        }

        return cards;
    }

    public MCFurnaceCard[] generate(boolean generateFiles) {
        this.generateFiles = generateFiles;
        return this.generate();
    }

    public void generate(Function<MCFurnaceCard, Void> function, MCFurnaceCard eCard) {
        function.apply(eCard);
    }

}
