package dev;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod("simplestep")
public class SimpleStepMod {
    private boolean autoJumpDisabled = false;

    public SimpleStepMod() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent event) {
        if (!autoJumpDisabled && Minecraft.getInstance().player != null) {
            Minecraft.getInstance().options.autoJump().set(false);
            autoJumpDisabled = true;
        }
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.START) {
            event.player.setMaxUpStep(1.1F);
        }
    }
}