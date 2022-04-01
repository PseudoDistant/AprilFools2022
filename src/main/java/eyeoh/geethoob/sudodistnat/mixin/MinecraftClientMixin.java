package eyeoh.geethoob.sudodistnat.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.CloudRenderMode;
import net.minecraft.client.option.Option;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {

    @Redirect(method = "render", at = @At(value = "INVOKE", target = "Ljava/lang/String;format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;"))
    public String AprilFools(String format, Object[] args) {
        return String.format("%d fps T: %s%s%s%s B: %d", 69420, ((MinecraftClient)(Object)this).options.maxFps == Option.FRAMERATE_LIMIT.getMax() ? "inf" : ((MinecraftClient)(Object)this).options.maxFps, ((MinecraftClient)(Object)this).options.enableVsync ? " vsync" : "", ((MinecraftClient)(Object)this).options.graphicsMode, ((MinecraftClient)(Object)this).options.cloudRenderMode == CloudRenderMode.OFF ? "" : (((MinecraftClient)(Object)this).options.cloudRenderMode == CloudRenderMode.FAST ? " fast-clouds" : " fancy-clouds"), ((MinecraftClient)(Object)this).options.biomeBlendRadius);
    }
}
