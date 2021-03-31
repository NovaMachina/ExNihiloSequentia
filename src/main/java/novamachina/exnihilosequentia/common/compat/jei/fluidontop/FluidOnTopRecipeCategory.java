package novamachina.exnihilosequentia.common.compat.jei.fluidontop;

import java.util.Arrays;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.util.ResourceLocation;
import novamachina.exnihilosequentia.api.crafting.fluidontop.FluidOnTopRecipe;
import novamachina.exnihilosequentia.common.utility.ExNihiloConstants.ModIds;

public class FluidOnTopRecipeCategory implements IRecipeCategory<FluidOnTopRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(ModIds.EX_NIHILO_SEQUENTIA, "fluidontop");
    private static final ResourceLocation texture = new ResourceLocation(ModIds.EX_NIHILO_SEQUENTIA, "textures/gui/jei_fluid_on_top.png");
    private final IDrawableStatic background;

    public FluidOnTopRecipeCategory(IGuiHelper guiHelper) {
        this.background = guiHelper.createDrawable(texture, 0, 0, 166, 63);
    }

    @Override
    public IDrawable getBackground() {
        return background;
    }

    @Override
    public IDrawable getIcon() {
        return null;
    }

    @Override
    public Class<? extends FluidOnTopRecipe> getRecipeClass() {
        return FluidOnTopRecipe.class;
    }

    @Override
    public String getTitle() {
        return "Fluid On Top";
    }

    @Override
    public ResourceLocation getUid() {
        return UID;
    }

    @Override
    public void setIngredients(FluidOnTopRecipe recipe, IIngredients ingredients) {
        ingredients.setInputs(VanillaTypes.FLUID, Arrays.asList(recipe.getFluidInTank(), recipe.getFluidOnTop()));
        ingredients.setOutput(VanillaTypes.ITEM, recipe.getResultItem());
    }

    @Override
    public void setRecipe(IRecipeLayout recipeLayout, FluidOnTopRecipe recipe, IIngredients ingredients) {
        recipeLayout.getFluidStacks().init(0, true, 48, 37);
        recipeLayout.getFluidStacks().init(1, true, 75, 10);
        recipeLayout.getItemStacks().init(0, false, 101, 36);

        recipeLayout.getFluidStacks().set(0, recipe.getFluidInTank());
        recipeLayout.getFluidStacks().set(1, recipe.getFluidOnTop());
        recipeLayout.getItemStacks().set(0, recipe.getResultItem());
    }
}
