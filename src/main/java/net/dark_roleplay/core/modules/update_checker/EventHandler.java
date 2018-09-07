package net.dark_roleplay.core.modules.update_checker;

import net.dark_roleplay.core.References;
import net.dark_roleplay.core.common.config.Client;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(value = Side.CLIENT, modid = References.MODID)
public class EventHandler {
	
	@SubscribeEvent
	public static void guiInit(GuiScreenEvent.InitGuiEvent event) {
		if(!Client.DISABLE_UPDATE_INFO && event.getGui() instanceof GuiMainMenu && !Module_UpdateChecker.mods.isEmpty()) {
			GuiMainMenu menu = (GuiMainMenu) event.getGui();
			GuiButton updateAvailableButton = new GuiButton(222, menu.width - 105, 5, 100, 20, "Updates Available!" );
			event.getButtonList().add(updateAvailableButton);
		}
	}
	 
	@SubscribeEvent
	public static void guiButtonPressed(GuiScreenEvent.ActionPerformedEvent event) {
		if(event.getGui() instanceof GuiMainMenu && event.getButton().id == 222) {
			Minecraft.getMinecraft().displayGuiScreen(new Gui_UpdateInformation());
		}
	}
}
