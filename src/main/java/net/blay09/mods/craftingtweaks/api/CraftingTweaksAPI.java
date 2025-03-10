package net.blay09.mods.craftingtweaks.api;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;

public class CraftingTweaksAPI {

    private static InternalMethods internalMethods;

    /**
     * Internal Method. Stay away.
     * 
     * @param internalMethods I said stay away.
     */
    public static void setupAPI(InternalMethods internalMethods) {
        CraftingTweaksAPI.internalMethods = internalMethods;
    }

    /**
     * For simple crafting tables that follow Vanilla's standard, you can use this instead of the registerProvider()
     * method that allows custom implementations.
     * Make sure to set things up properly in the returned SimpleTweakProvider (e.g. setPhantomItems(true) if your grid
     * uses phantom items)
     * 
     * @param modid          the mod id the container is part of
     * @param containerClass the container containing a default crafting grid
     * @return a SimpleTweakProvider instance that allows further control over the provider settings
     */
    public static SimpleTweakProvider registerSimpleProvider(String modid, Class<? extends Container> containerClass) {
        return internalMethods.registerSimpleProvider(modid, containerClass);
    }

    /**
     * Registers a tweak provider for the supplied container class.
     * For simple crafting tables that follow Vanilla's standard, consider registerWithDefaultProvider instead.
     * 
     * @param containerClass the container this provider is used for
     * @param provider       the tweak provider implementation for the given container
     */
    public static void registerProvider(Class<? extends Container> containerClass, TweakProvider provider) {
        internalMethods.registerProvider(containerClass, provider);
    }

    /**
     * Returns a default provider implementation you can use within your TweakProvider
     * 
     * @deprecated Use createDefaultProviderV2() instead, it's way better
     * @return default provider implementation with functions to be called from a TweakProvider
     */
    @Deprecated
    public static DefaultProvider createDefaultProvider() {
        return internalMethods.createDefaultProvider();
    }

    /**
     * Returns a default provider implementation you can use within your TweakProvider
     * 
     * @return default provider implementation with functions to be called from a TweakProvider
     */
    public static DefaultProviderV2 createDefaultProviderV2() {
        return internalMethods.createDefaultProviderV2();
    }

    /**
     * Creates a Crafting Tweaks button to balance the grid. To be called from within TweakProvider.initGui()
     * 
     * @param id the crafting grid ID this button is for (usually 0 unless there's more grids in one GUI)
     * @param x  the x position the button should be placed at
     * @param y  the y position the button should be placed at
     * @return a new GuiButton instance that you should add to the buttonList
     */
    public static GuiButton createBalanceButton(int id, int x, int y) {
        return internalMethods.createBalanceButton(id, null, x, y);
    }

    /**
     * Creates a Crafting Tweaks button to balance the grid. To be called from within TweakProvider.initGui()
     * This function stores relative button positions, meaning this version of the button will work correctly for GUIs
     * that do hacky weird things where they temporarily change guiLeft/guiTop before drawing.
     * 
     * @param id        the crafting grid ID this button is for (usually 0 unless there's more grids in one GUI)
     * @param parentGui the parent GUI for this button, used to obtain the absolute position
     * @param relX      the relative position the button should be placed at
     * @param relY      the relative position the button should be placed at
     */
    public static GuiButton createBalanceButtonRelative(int id, GuiContainer parentGui, int relX, int relY) {
        return internalMethods.createBalanceButton(id, parentGui, relX, relY);
    }

    /**
     * Creates a Crafting Tweaks button to rotate the grid. To be called from within TweakProvider.initGui()
     * 
     * @param id the crafting grid ID this button is for (usually 0 unless there's more grids in one GUI)
     * @param x  the x position the button should be placed at
     * @param y  the y position the button should be placed at
     * @return a new GuiButton instance that you should add to the buttonList
     */
    public static GuiButton createRotateButton(int id, int x, int y) {
        return internalMethods.createRotateButton(id, null, x, y);
    }

    /**
     * Creates a Crafting Tweaks button to rotate the grid. To be called from within TweakProvider.initGui()
     * This function stores relative button positions, meaning this version of the button will work correctly for GUIs
     * that do hacky weird things where they temporarily change guiLeft/guiTop before drawing.
     * 
     * @param id        the crafting grid ID this button is for (usually 0 unless there's more grids in one GUI)
     * @param parentGui the parent GUI for this button, used to obtain the absolute position
     * @param relX      the relative position the button should be placed at
     * @param relY      the relative position the button should be placed at
     */
    public static GuiButton createRotateButtonRelative(int id, GuiContainer parentGui, int relX, int relY) {
        return internalMethods.createRotateButton(id, parentGui, relX, relY);
    }

    /**
     * Creates a Crafting Tweaks button to clear the grid. To be called from within TweakProvider.initGui()
     * 
     * @param id the crafting grid ID this button is for (usually 0 unless there's more grids in one GUI)
     * @param x  the x position the button should be placed at
     * @param y  the y position the button should be placed at
     * @return a new GuiButton instance that you should add to the buttonList
     */
    public static GuiButton createClearButton(int id, int x, int y) {
        return internalMethods.createClearButton(id, null, x, y);
    }

    /**
     * Creates a Crafting Tweaks button to clear the grid. To be called from within TweakProvider.initGui()
     * This function stores relative button positions, meaning this version of the button will work correctly for GUIs
     * that do hacky weird things where they temporarily change guiLeft/guiTop before drawing.
     * 
     * @param id        the crafting grid ID this button is for (usually 0 unless there's more grids in one GUI)
     * @param parentGui the parent GUI for this button, used to obtain the absolute position
     * @param relX      the relative position the button should be placed at
     * @param relY      the relative position the button should be placed at
     */
    public static GuiButton createClearButtonRelative(int id, GuiContainer parentGui, int relX, int relY) {
        return internalMethods.createClearButton(id, parentGui, relX, relY);
    }
}
