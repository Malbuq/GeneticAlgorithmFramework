package Framework.Test;

import java.util.ArrayList;
import java.util.List;

import Framework.ChromosomeInterface;
import Framework.PopulationInterface;

public class Population<T> implements PopulationInterface<T> {
    private List<ChromosomeInterface<T>> chromosomes;
    private int size;

    public Population(int size) {
        this.size = size;
        this.chromosomes = new ArrayList<>(size);
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public void addChromosome(ChromosomeInterface<T> chromosome) {
        if (chromosomes.size() < size) {
            chromosomes.add(chromosome);
        } else {
            System.out.println("Population is full!");
        }
    }

    @Override
    public ChromosomeInterface<T> getChromosomeAt(int index) {
        return chromosomes.get(index);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Population [Size=" + size + ", Chromosomes=\n");
        for (ChromosomeInterface<T> chromosome : chromosomes) {
            sb.append(chromosome).append("\n");
        }
        sb.append("]");
        return sb.toString();
    }
}
