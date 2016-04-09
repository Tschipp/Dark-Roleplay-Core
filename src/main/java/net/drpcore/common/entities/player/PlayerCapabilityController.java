package net.drpcore.common.entities.player;

import net.drpcore.common.DarkRoleplayCore;
import net.drpcore.common.entities.player.advancedInventoryCapabiliy.IPlayerInventoryAdvanced;
import net.drpcore.common.entities.player.advancedInventoryCapabiliy.PlayerCapabilityProvider;
import net.drpcore.common.gui.inventories.PlayerInventory;
import net.minecraft.entity.Entity;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class PlayerCapabilityController {

	@SubscribeEvent
	public void attachPlayerCapabilities(AttachCapabilitiesEvent.Entity event) {

		event.addCapability(new ResourceLocation(DarkRoleplayCore.MODID + ":" + "DRPCore_Inventory"), new PlayerCapabilityProvider(event.getEntity()));
		
	}

	@SubscribeEvent
    public void onInteract(PlayerInteractEvent event)
    {
        if (event.getEntityPlayer().getHeldItemMainhand() == null) return;
        if (event.getEntityPlayer().getHeldItemMainhand().getItem() != Items.stick) return;

        // This is just a example of how to interact with the TE, note the strong type binding that getCapability has
        Entity entity = event.getEntity();
        if (entity != null && entity.hasCapability(DarkRoleplayCore.getDrpcoreInv(), event.getFace()))
        {
            IPlayerInventoryAdvanced inv = entity.getCapability(DarkRoleplayCore.getDrpcoreInv(), event.getFace());
            
            PlayerInventory inventory = event.getEntity().getCapability(DarkRoleplayCore.getDrpcoreInv(), null).getInventory();
            inventory.setInventorySlotContents(1, new ItemStack(Items.stone_axe));
        }
    }
	
}
