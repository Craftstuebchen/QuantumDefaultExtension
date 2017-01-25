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
public class QuantumCircuit extends AbstractCircuit {

    public QuantumCircuit() {
        super();
    }

    public QuantumCircuit(UUID playerUUID, Integer delay) {
        super(playerUUID, delay);
    }

    public QuantumCircuit(Map<?, ?> map) {
        super(map);
    }

    @Override
    public void calculate(Receiver receiver, int oldCurrent, int newCurrent) {
        try {
            receiver.setActive(newCurrent >0);
        } catch (ValueNotChangedException e) {
            e.printStackTrace();
        } catch (ReceiverNotValidException e) {
            e.printStackTrace();
        }
    }
}
