package net.dark_roleplay.drpcore.client.events.player;

import net.dark_roleplay.drpcore.common.References;
import net.dark_roleplay.drpcore.common.config.Client;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Event_GuiOpen {

	public static boolean hasOpened = false;
	
	@SubscribeEvent
	public void onEvent(GuiOpenEvent event) {
		
		System.out.println(event.getGui() != null ? event.getGui().getClass() : "");
		
		if(event.getGui() instanceof GuiInventory && Client.TUTORIAL.SHOW_CRAFTING_TUT) {
			Minecraft.getMinecraft().getToastGui().add(References.CRAFTING_TUT);
			Client.TUTORIAL.SHOW_CRAFTING_TUT = false;
			ConfigManager.sync(References.MODID, Config.Type.INSTANCE);
		}
//			
//			event.setGui(new GuiTutorial(event.getGui()));
//
//			if(DRPCoreConfigs.GENERAL.FIRST_INSTALL){
//				DRPCoreConfigs.GENERAL.FIRST_INSTALL = false;
//				ConfigManager.sync(DRPCoreInfo.MODID, Config.Type.INSTANCE);
//				event.setGui(new Gui_FirstRun());
//			}else if(DRPCoreConfigs.GENERAL.UPDATE_GUI && DRPCoreInfo.VERSION_STATUS.status == Status.OUTDATED || DRPCoreInfo.VERSION_STATUS.status == Status.BETA_OUTDATED){
//				event.setGui(new Gui_UpdateAvailable());
//				hasOpened = true;
//			}
//		}
	}
	
//	GuiButton updateAvailableButton;
//	
//	@SubscribeEvent
//	public void onEvent(GuiScreenEvent.InitGuiEvent event) {
//		if(event.getGui() instanceof GuiMainMenu){
//			event.getButtonList().add(updateAvailableButton = new GuiButton(9, 5, 25, 100, 20, "Test Button2"));
//		}
//	}
//	
//	@SubscribeEvent
//	public void onEvent(GuiScreenEvent.ActionPerformedEvent event) {
//		if(event.getGui() instanceof GuiMainMenu){
//			if(event.getButton().equals(updateAvailableButton)) {
//				System.out.println("Update");
//			}
//		}
//	}
	
}
