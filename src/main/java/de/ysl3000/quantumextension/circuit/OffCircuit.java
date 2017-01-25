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
public class OffCircuit extends AbstractCircuit {

    public OffCircuit() {
        super();
    }

    public OffCircuit(UUID playerUUID, Integer delay) {
        super(playerUUID, delay);
    }

    public OffCircuit(Map<?, ?> map) {
        super(map);
    }

    @Override
    public void calculate(Receiver receiver, int oldCurrent, int newCurrent) {
        try {
            if (newCurrent == 0 && oldCurrent > 0) {
                receiver.setActive(false);
            }
        } catch (ValueNotChangedException e) {
            e.printStackTrace();
        } catch (ReceiverNotValidException e) {
            e.printStackTrace();
        }
    }

}
