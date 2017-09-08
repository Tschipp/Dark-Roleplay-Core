package net.dark_roleplay.drpcore.client.gui.advanced.buttons.blueprint_controll;

import java.awt.Color;
import java.io.IOException;

import net.dark_roleplay.drpcore.api.gui.advanced.Gui_Button;
import net.dark_roleplay.drpcore.api.gui.modular.ModularGui_Drawer;
import net.dark_roleplay.drpcore.client.gui.structure.Gui_StructureControll;
import net.dark_roleplay.drpcore.common.tile_entities.blueprint_controller.TE_BlueprintController;
import net.minecraft.client.renderer.GlStateManager;

public class Button_SaveLoad extends Gui_Button{

	private boolean saveMode;
	
	private Gui_StructureControll parent;
	
	public Button_SaveLoad(Gui_StructureControll parent, boolean saveMode, int posX, int posY, int width, int height) {
		super(posX, posY, width, height);
		this.saveMode = saveMode;
		this.parent = parent;
	}
	
	@Override
	public boolean mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		if(this.saveMode){
			this.parent.save();
		}else{
			this.parent.load();
		}
		return true;
	}
}
