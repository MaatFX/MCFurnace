package fr.mathieu.mcfurnace.furnace.agoldfurnace.gui;

import com.mojang.blaze3d.platform.GlStateManager;
import fr.mathieu.mcfurnace.furnace.agoldfurnace.container.AGoldFurnaceContainer;
import fr.mathieu.mcfurnace.furnace.agoldfurnace.container.AbstractAGoldFurnaceContainer;

import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;


public class AGoldFurnaceScreen extends ContainerScreen<AGoldFurnaceContainer> {

    public AGoldFurnaceScreen(AGoldFurnaceContainer container, PlayerInventory inv, ITextComponent name)
    {
        super(container, inv, name);
    }


    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        String s = this.title.getFormattedText();
        this.font.drawString(s, (float)(this.xSize / 2 - this.font.getStringWidth(s) / 2), 6.0F, 4210752);
        this.font.drawString(this.playerInventory.getDisplayName().getFormattedText(), 8.0F, (float)(this.ySize - 96 + 2), 4210752);
    }

    /**
     * Draws the background layer of this container (behind the items).
     */
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {

        GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.getTextureManager().bindTexture(new ResourceLocation("mcfurnace:textures/gui/container/agold_furnace.png"));
        int i = this.guiLeft;
        int j = this.guiTop;
        this.blit(i, j, 0, 0, this.xSize, this.ySize);
        if (((AbstractAGoldFurnaceContainer)this.container).func_217061_l()) {
            int k = ((AbstractAGoldFurnaceContainer)this.container).getBurnLeftScaled();
            this.blit(i + 56, j + 36 + 12 - k, 176, 12 - k, 14, k + 1);
        }

        int l = ((AbstractAGoldFurnaceContainer)this.container).getCookProgressionScaled();
        this.blit(i + 79, j + 34, 176, 14, l + 1, 16);
    }

}
