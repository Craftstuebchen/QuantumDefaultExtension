package com.github.ysl3000.quantumextension.receiver;

import com.github.ysl3000.quantum.api.receiver.AbstractReceiver;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.data.Powerable;
import org.bukkit.block.data.type.Switch;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public class LeverReceiver extends AbstractReceiver {
    /**
     * only use to getValidMaterials
     */
    public LeverReceiver() {
        super();
    }

    public LeverReceiver(Location location) {
        this(location, 0);
    }

    public LeverReceiver(Location location, Integer delay) {
        super(location, delay);
    }

    public LeverReceiver(Map<String, Object> map) {
        super(map);
    }

    @Override
    public Collection<Material> getValidMaterials() {
        return Collections.singleton(Material.LEVER);
    }

    @Override
    public boolean isActive() {
        return isActive(location.getBlock(),Switch.class, Powerable::isPowered);
    }

    @Override
    public void setActive(boolean powerOn) {
        setActive(location.getBlock(), Switch.class, aSwitch -> aSwitch.setPowered(powerOn));
    }

    @Override
    public int getBlockCurrent() {
        return isActive() ? 15 : 0;
    }
}
