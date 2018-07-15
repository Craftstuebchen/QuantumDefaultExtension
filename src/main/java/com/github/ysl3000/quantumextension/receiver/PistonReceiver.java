package com.github.ysl3000.quantumextension.receiver;

import com.github.ysl3000.quantum.api.receiver.AbstractKeepAliveReceiver;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.type.Piston;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;


public class PistonReceiver extends AbstractKeepAliveReceiver {
    /**
     * only use to getValidMaterials
     */
    public PistonReceiver() {
        super();
    }

    public PistonReceiver(Location location) {
        super(location);
    }

    public PistonReceiver(Map<String, Object> map) {
        super(map);
    }

    public PistonReceiver(Location location, Integer delay) {
        super(location, delay);
    }

    @Override
    public Collection<Material> getValidMaterials() {
        return Arrays.asList(Material.PISTON,Material.STICKY_PISTON);
    }

    @Override
    public boolean isActive() {

        BlockData blockData = location.getBlock().getBlockData();

        if (blockData instanceof Piston) {
            return ((Piston) blockData).isExtended();
        }

        return false;
    }

    @Override
    public void setActive(boolean powerOn) {

        if (!isValid()) return;

        setBlockData(location.getBlock(),Piston.class,pistonData -> pistonData.setExtended(true));
    }

    @Override
    public boolean isValid() {
        return location.getBlock().getBlockData() instanceof Piston;
    }
}
