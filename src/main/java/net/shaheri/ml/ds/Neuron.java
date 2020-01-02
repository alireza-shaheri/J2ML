package net.shaheri.ml.ds;

import net.shaheri.ml.functions.ActivationFunction;

import java.util.List;

public class Neuron {

    private ActivationFunction activationFunction;

    private List<InputLink> inputs;

    public Neuron(ActivationFunction activationFunction, List<InputLink> inputs) {
        this.activationFunction = activationFunction;
        this.inputs = inputs;
    }

    public Double output(){
        return activationFunction.apply(inputs.parallelStream().mapToDouble(InputLink::effectiveValue).sum());
    }

    public static class InputLink {
        private Double value;
        private Double weight;

        public InputLink(Double value) {
            this.value = value;
            this.weight = Math.random();
        }

        private Double getValue() {
            return value;
        }

        public void setValue(Double value) {
            this.value = value;
        }

        private Double getWeight() {
            return weight;
        }

        public void setWeight(Double weight) {
            this.weight = weight;
        }

        private Double effectiveValue(){
            return weight * value;
        }
    }
}
