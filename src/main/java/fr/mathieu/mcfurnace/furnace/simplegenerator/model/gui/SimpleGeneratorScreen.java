package fr.mathieu.mcfurnace.furnace.simplegenerator.model.gui;

import com.mojang.blaze3d.platform.GlStateManager;
import fr.mathieu.mcfurnace.furnace.simplegenerator.model.container.AbstractSimpleGeneratorContainer;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class SimpleGeneratorScreen extends ContainerScreen<AbstractSimpleGeneratorContainer> {


    AbstractSimpleGeneratorContainer abstractSimpleGeneratorContainer;

    public SimpleGeneratorScreen(AbstractSimpleGeneratorContainer abstractSimpleGeneratorContainer, PlayerInventory playerInventory, ITextComponent textComponent) {
        super(abstractSimpleGeneratorContainer, playerInventory, textComponent);
         this.abstractSimpleGeneratorContainer = abstractSimpleGeneratorContainer;

    }

    @Override
    public void render(int p_render_1_, int p_render_2_, float p_render_3_) {
        this.renderBackground();
        super.render(p_render_1_, p_render_2_, p_render_3_);
        this.renderHoveredToolTip(p_render_1_, p_render_2_);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        String s = this.title.getFormattedText();
        this.font.drawString(s, (float)(this.xSize / 2 - this.font.getStringWidth(s) / 2), 6.0F, 4210752);
        this.font.drawString(this.playerInventory.getDisplayName().getFormattedText(), 8.0F, (float)(this.ySize - 96 + 2), 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.getTextureManager().bindTexture(new ResourceLocation("mcfurnace:textures/gui/container/simple_generator_container.png"));
        int i = this.guiLeft;
        int j = this.guiTop;
        this.blit(i, j, 0, 0, this.xSize, this.ySize);

        int l = this.container.getCookProgressionScaled();
        this.blit(i + 79, j + 34, 176, 14, l + 1, 16);
    }

    /*
     public void mappedBlit(int inGamePosXStart, int inGamePosYStart, int texturePosXStart, int texturePosYStart, int texturePosXEnd, int texturePosYEnd) {
        this.blit(inGamePosXStart, inGamePosYStart, texturePosXStart, texturePosYStart, texturePosXEnd, texturePosYEnd);
     }

     */
}
