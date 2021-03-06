package novamachina.exnihilosequentia.common.compat.crafttweaker.builder;

import com.blamejared.crafttweaker.api.annotations.ZenRegister;
import com.blamejared.crafttweaker.api.item.IIngredient;
import com.blamejared.crafttweaker.api.item.IItemStack;
import java.util.ArrayList;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import novamachina.exnihilosequentia.api.crafting.hammer.HammerRecipe;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@ZenCodeType.Name("mods.exnihilosequentia.ZenHammerRecipe")
public class ZenHammerRecipe {

    private final HammerRecipe internal;

    private ZenHammerRecipe(ResourceLocation recipeId) {
        this.internal = new HammerRecipe(recipeId, Ingredient.EMPTY, new ArrayList<>());
    }

    @ZenCodeType.Method
    public static ZenHammerRecipe builder(ResourceLocation recipeId) {
        return new ZenHammerRecipe(recipeId);
    }

    @ZenCodeType.Method
    public ZenHammerRecipe addOutput(IItemStack output) {
        internal.addOutput(output.getInternal());
        return this;
    }

    @ZenCodeType.Method
    public ZenHammerRecipe addOutput(IItemStack output, float chance) {
        internal.addOutput(output.getInternal(), chance);
        return this;
    }

    public HammerRecipe build() {
        return internal;
    }

    @ZenCodeType.Method
    public ZenHammerRecipe setInput(IIngredient input) {
        internal.setInput(input.asVanillaIngredient());
        return this;
    }
}
