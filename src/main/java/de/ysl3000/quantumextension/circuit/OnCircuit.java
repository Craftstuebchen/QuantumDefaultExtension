package de.ysl3000.quantumextension.circuit;

import com.ne0nx3r0.quantum.api.circuit.AbstractCircuit;
import com.ne0nx3r0.quantum.api.receiver.Receiver;
import com.ne0nx3r0.quantum.api.receiver.ReceiverNotValidException;
import com.ne0nx3r0.quantum.api.receiver.ValueNotChangedException;

import java.util.Map;
import java.util.UUID;

/**
 * Created by Yannick on 25.01.2017.
 */
public class OnCircuit extends AbstractCircuit {
    public OnCircuit(UUID playerUUID, int delay) {
        super(playerUUID, delay);
    }

    public OnCircuit(Map<?, ?> map) {
        super(map);
    }

    @Override
    public void calculate(Receiver receiver, int oldCurrent, int newCurrent) {
        try {
            if (newCurrent > 0 && oldCurrent == 0) {
                receiver.setActive(true);
            }
        } catch (ValueNotChangedException e) {
            e.printStackTrace();
        } catch (ReceiverNotValidException e) {
            e.printStackTrace();
        }
    }

}
