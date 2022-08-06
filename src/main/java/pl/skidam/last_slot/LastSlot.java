package pl.skidam.last_slot;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod("lastslot")
public class LastSlot {
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final String MOD_ID = "Last slot";

    public LastSlot() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        MinecraftForge.EVENT_BUS.register(this);
    }
    private void setup(final FMLCommonSetupEvent event) {
        LOGGER.info("Initialized " + MOD_ID);
    }
}
