package net.shaheri.ml.ds;

import net.shaheri.ml.functions.ActivationFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Network {

    private List<NetLayer> layers;

    public List<NetLayer> getLayers() {
        if (layers == null)
            layers = new ArrayList<NetLayer>();
        return layers;
    }

    private class NetLayer {

        private List<Neuron> neurons;

        public NetLayer(int dimension, ActivationFunction activationFunction, NetLayer predecessor){
            neurons = new ArrayList<>();
            for (int i = 0; i < dimension; i++) {
                neurons.add(
                        new Neuron(
                                activationFunction,
                                predecessor.neurons.stream().map(neuron -> new Neuron.InputLink(neuron.output())).collect(Collectors.toList())
                        )
                );
            }
        }

    }
}
