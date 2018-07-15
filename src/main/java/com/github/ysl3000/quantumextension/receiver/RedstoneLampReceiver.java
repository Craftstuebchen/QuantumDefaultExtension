package com.github.ysl3000.quantumextension.receiver;

import com.github.ysl3000.quantum.api.receiver.AbstractKeepAliveReceiver;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.data.Lightable;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;


public class RedstoneLampReceiver extends AbstractKeepAliveReceiver {


    /**
     * only use to getValidMaterials
     */
    public RedstoneLampReceiver() {
        super();
    }

    public RedstoneLampReceiver(Location location) {
        super(location);
    }

    public RedstoneLampReceiver(Location location, Integer delay) {
        super(location, delay);
    }

    public RedstoneLampReceiver(Map<String, Object> map) {
        super(map);
    }

    @Override
    public Collection<Material> getValidMaterials() {
        return Collections.singletonList(Material.REDSTONE_LAMP);
    }

    @Override
    public boolean isValid() {
        return this.location.getBlock().getType() == Material.REDSTONE_LAMP;
    }

    @Override
    public int getBlockCurrent() {
        return isActive() ? 15 : 0;
    }

    @Override
    public boolean isActive() {
        return isActive(location.getBlock(), Lightable.class, Lightable::isLit);
    }

    @Override
    public void setActive(boolean powerOn) {
        setActive(location.getBlock(), Lightable.class, lightable -> lightable.setLit(powerOn));
    }
}
