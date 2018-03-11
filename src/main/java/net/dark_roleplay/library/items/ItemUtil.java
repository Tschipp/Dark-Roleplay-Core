package net.dark_roleplay.library.items;

import java.util.ArrayList;

import com.google.common.collect.Lists;

import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

public class ItemUtil {

	/**
	 * An Array that is automaticly filled when an Instance of DRPItem is created,
	 * this array is cleared on every call of {@link registerItemMeshs}
	 */
	public static ArrayList<DRPItem> toRegister = Lists.newArrayList();
	
	/**
	 * Registers all ItemMeshes for Items that extends DRPItem
	 */
	public static void registerItemMeshs() {
		for(DRPItem item : toRegister){
			if(item.getSubNames() != null){
				ResourceLocation[] locations = new ResourceLocation[item.getSubNames().length];
				for(int i = 0; i < item.getSubNames().length; i++){
					locations[i] = new ResourceLocation(item.getRegistryName().getResourceDomain(), item.getItemFolder() + "/" + item.getSubNames()[i]);
				}
				ModelBakery.registerItemVariants(item,locations);
				for(int i = 0; i < locations.length; i++){
					ModelLoader.setCustomModelResourceLocation(item, i, new ModelResourceLocation(locations[i], "inventory"));
				}
			}else{
				String path = item.getRegistryName().getResourcePath();
				if(item.getItemFolder() != null){
					path = item.getItemFolder() + "/" + path;
				}
				ModelBakery.registerItemVariants(item, new ResourceLocation(item.getRegistryName().getResourceDomain(), path));
				ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName().getResourceDomain() + ":" + path, "inventory"));
			}
		}
		toRegister.clear();
	}
	 
	/*
	public static void registerItemMeshs() {
		for(DRPItem item : toRegister){
			if(item.getSubNames() != null){
				ResourceLocation[] locations = new ResourceLocation[item.getSubNames().length];
				for(int i = 0; i < item.getSubNames().length; i++){
					locations[i] = new ResourceLocation(item.getRegistryName().getResourceDomain(), item.getItemFolder() + "/" + item.getSubNames()[i]);
				}
				ModelBakery.registerItemVariants(item,locations);
				for(int i = 0; i < locations.length; i++){
					ModelLoader.setCustomModelResourceLocation(item, i, new ModelResourceLocation(locations[i], "inventory"));
				}
			}else{
				String path = item.getUnlocalizedName().toString().substring(item.getUnlocalizedName().toString().indexOf(".") + 1, item.getUnlocalizedName().toString().length());
				if(item.getItemFolder() != null){
					path = item.getItemFolder() + "/" + path;
				}
				ModelBakery.registerItemVariants(item, new ResourceLocation(item.getRegistryName().getResourceDomain(), path));
				ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName().getResourceDomain() + ":" + path, "inventory"));
			}
		}
		toRegister.clear();
	}*/
}
