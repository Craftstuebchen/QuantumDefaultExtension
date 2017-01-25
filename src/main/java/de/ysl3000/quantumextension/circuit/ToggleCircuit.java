package de.ysl3000.quantumextension.circuit;


import de.ysl3000.quantum.api.circuit.AbstractCircuit;
import de.ysl3000.quantum.api.receiver.Receiver;
import de.ysl3000.quantum.api.receiver.ReceiverNotValidException;
import de.ysl3000.quantum.api.receiver.ValueNotChangedException;

import java.util.Map;
import java.util.UUID;

/**
 * Created by Yannick on 25.01.2017.
 */
public class ToggleCircuit extends AbstractCircuit {

    public ToggleCircuit() {
        super();
    }

    public ToggleCircuit(UUID playerUUID, Integer delay) {
        super(playerUUID, delay);
    }

    public ToggleCircuit(Map<?, ?> map) {
        super(map);
    }

    @Override
    public void calculate(Receiver receiver, int newCurrent, int oldCurrent) {
        if (newCurrent > 0 && oldCurrent == 0) {
            try {
                receiver.setActive(receiver.getBlockCurrent() <= 0);
            } catch (ValueNotChangedException e) {
                e.printStackTrace();
            } catch (ReceiverNotValidException e) {
                e.printStackTrace();
            }
        }
    }
}
