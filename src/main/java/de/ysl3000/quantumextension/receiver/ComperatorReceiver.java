package de.ysl3000.quantumextension.receiver;

import de.ysl3000.quantum.api.receiver.AbstractKeepAliveReceiver;
import de.ysl3000.quantum.api.receiver.ReceiverNotValidException;
import de.ysl3000.quantum.api.receiver.ValueNotChangedException;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.material.Comparator;

import java.util.Arrays;
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
        BlockState blockState = location.getBlock().getState();
        Comparator comparator = (Comparator) blockState.getData();
        return comparator.isPowered();
    }

    @Override
    public void setActive(boolean powerOn) {
        try {
            super.setActive(powerOn);
        } catch (ValueNotChangedException | ReceiverNotValidException e) {
            return;
        }

        BlockState blockState = location.getBlock().getState();
        Comparator comparator = (Comparator) blockState.getData();
        comparator = new Comparator(comparator.getFacing(), comparator.isSubtractionMode(), powerOn);
        blockState.setData(comparator);
        blockState.update();

    }

    @Override
    public List<Material> getValidMaterials() {
        return Arrays.asList(Material.REDSTONE_COMPARATOR_OFF, Material.REDSTONE_COMPARATOR_ON);
    }
}
