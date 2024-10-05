package Framework.Test;

import java.util.Random;

import Framework.PopulationComponents.ChromosomeInterface;

public class Chromosome implements ChromosomeInterface {
    private int length;
    private Number[] genes;
    private float fitness;
    private float probability;

    public Chromosome(int length) {
        this.length = length;
        genes = new Number[length];
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public float getFitness() {
        return fitness;
    }

    @Override
    public void setFitness(float fitness) {
        this.fitness = fitness;
    }

    @Override
    public float getProbability() {
        return probability;
    }

    @Override
    public void setProbability(float probability) {
        this.probability = probability;
    }

    @Override
    public void populateChromosome(int leftDomainBoundarie, int rightDomainBoundarie) {
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            genes[i] = random.nextInt(rightDomainBoundarie - leftDomainBoundarie) + leftDomainBoundarie;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Chromosome [");
        sb.append("Length: ").append(length).append(", ");
        sb.append("Genes: ");
        for (Number gene : genes) {
            sb.append(gene).append(" ");
        }
        sb.append(", Fitness: ").append(fitness).append(", ");
        sb.append("Probability: ").append(probability);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public Number getGeneAt(int index) {
        return this.genes[index];
    }

    @Override
    public void setGeneAt(int index, Number geneValue) {
        this.genes[index] = geneValue;
    }

}
