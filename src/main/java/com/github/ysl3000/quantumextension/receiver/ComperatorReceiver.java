package com.github.ysl3000.quantumextension.receiver;

import com.github.ysl3000.quantum.api.receiver.AbstractKeepAliveReceiver;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Powerable;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ComperatorReceiver extends AbstractKeepAliveReceiver {

    /**
     * only use to getValidMaterials
     */
    public ComperatorReceiver() {
        super();
    }

    public ComperatorReceiver(Location location) {
        super(location);
    }

    public ComperatorReceiver(Location location, Integer delay) {
        super(location, delay);
    }

    public ComperatorReceiver(Map<String, Object> map) {
        super(map);
    }

    @Override
    public boolean isActive() {
        if (!isValid()) return false;

        BlockData blockData = location.getBlock().getBlockData();

        if (blockData instanceof Powerable) {

            Powerable powerable = (Powerable) blockData;
            return powerable.isPowered();
        }

        return false;
    }

    @Override
    public void setActive(boolean powerOn) {

        BlockData blockData = location.getBlock().getBlockData();

        if (blockData instanceof Powerable) {

            Powerable powerable = (Powerable) blockData;
            powerable.setPowered(powerOn);
        }
    }

    @Override
    public List<Material> getValidMaterials() {
        return Collections.singletonList(Material.COMPARATOR);
    }
}
