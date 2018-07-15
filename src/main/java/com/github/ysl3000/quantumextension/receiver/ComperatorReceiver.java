package com.github.ysl3000.quantumextension.receiver;

import com.github.ysl3000.quantum.api.receiver.AbstractKeepAliveReceiver;
import org.bukkit.Location;
import org.bukkit.Material;
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
        return isActive(location.getBlock(),Powerable.class,Powerable::isPowered);
    }

    @Override
    public void setActive(boolean powerOn) {
        setActive(location.getBlock(), Powerable.class, powerable -> powerable.setPowered(powerOn));
    }

    @Override
    public List<Material> getValidMaterials() {
        return Collections.singletonList(Material.COMPARATOR);
    }
}
