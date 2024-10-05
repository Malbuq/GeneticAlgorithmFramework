package Framework.Test;

import Framework.PopulationComponents.ChromosomeInterface;
import Framework.PopulationComponents.GeneInterface;

public class Chromosome<T extends Number> implements ChromosomeInterface<T> {
    private GeneInterface<T>[] genes;
    private int length;

    @SuppressWarnings("unchecked")
    public Chromosome(int length) {
        this.length = length;
        this.genes = new GeneInterface[length];
    }

    @Override
    public int getLength() {
        return length;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void setLength(int length) {
        this.length = length;
        this.genes = new GeneInterface[length]; // Reset the genes array to match new length
    }

    @Override
    public GeneInterface<T>[] getChromosome() {
        return genes;
    }

    @Override
    public void setChromosome(GeneInterface<T>[] genes) {
        this.genes = genes;
        this.length = genes.length;
    }

    @Override
    public GeneInterface<T> getGeneAt(int index) {
        return genes[index];
    }

    @Override
    public void setGeneAt(int index, GeneInterface<T> gene) {
        genes[index] = gene;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Chromosome [");
        for (int i = 0; i < length; i++) {
            sb.append(genes[i]);
            if (i < length - 1)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
