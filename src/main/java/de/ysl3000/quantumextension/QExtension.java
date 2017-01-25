package de.ysl3000.quantumextension;

import com.ne0nx3r0.quantum.api.IQuantumConnectorsAPI;
import com.ne0nx3r0.quantum.api.QuantumExtension;
import de.ysl3000.quantumextension.circuit.*;
import de.ysl3000.quantumextension.receiver.*;

/**
 * Created by Yannick on 24.01.2017.
 */
public class QExtension extends QuantumExtension {
    private IQuantumConnectorsAPI api;

    public void onEnable(IQuantumConnectorsAPI api) {
        this.api = api;
        this.api.getReceiverRegistry().register(this,
                LeverReceiver.class,
                OpenableReceiver.class,
                PistonReceiver.class,
                PoweredRailReceiver.class,
                RedstoneLampReceiver.class,
                TrafficLightStateReceiver.class,
                ComperatorReceiver.class);

        this.api.getCircuitRegistry().register(this,
                OffCircuit.class,
                OnCircuit.class,
                QuantumCircuit.class,
                RandomCircuit.class,
                ReverseCircuit.class,
                ToggleCircuit.class);
    }

    public void onDisable() {

    }
}
