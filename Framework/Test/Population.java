package Framework.Test;

import Framework.PopulationComponents.ChromosomeInterface;
import Framework.PopulationComponents.PopulationInterface;

public class Population implements PopulationInterface {
    private int size;
    private ChromosomeInterface[] chromosomes;
    private int populationTail;
    private int leftDomainBoundarie;
    private int rightDomainBoundarie;
    private float fitness;

    public Population(int size, int leftDomainBoundarie, int rightDomainBoundarie) {
        this.size = size;
        this.leftDomainBoundarie = leftDomainBoundarie;
        this.rightDomainBoundarie = rightDomainBoundarie;
        this.chromosomes = new ChromosomeInterface[size];
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
    public void setChromosomeAt(int index, ChromosomeInterface geneValue) {
        this.chromosomes[index] = geneValue;
    }

    @Override
    public ChromosomeInterface getChromosomeAt(int index) {
        return chromosomes[index];
    }

    @Override
    public int getRightDomainBoundarie() {
        return this.rightDomainBoundarie;
    }

    @Override
    public void setRightDomainBoundarie(int rightDomainBoundarie) {
        this.rightDomainBoundarie = rightDomainBoundarie;
    }

    @Override
    public int getleftDomainBoundarie() {
        return this.leftDomainBoundarie;
    }

    @Override
    public void setLeftDomainBoundarie(int leftDomainBoundarie) {
        this.leftDomainBoundarie = leftDomainBoundarie;
    }

    @Override
    public float getFitness() {
        return this.fitness;
    }

    @Override
    public void setFitness(float fitness) {
        this.fitness = fitness;
    }

    @Override
    public void generateInitialPopulation(int chromosomeLength) {
        for (int i = 0; i < this.size; i++) {
            Chromosome chromosome = new Chromosome(chromosomeLength);
            chromosome.populateChromosome(this.leftDomainBoundarie, this.rightDomainBoundarie);
            chromosomes[i] = chromosome;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Population [");
        sb.append("Size: ").append(size).append(", ");
        sb.append("Left Domain Boundarie: ").append(leftDomainBoundarie).append(", ");
        sb.append("Right Domain Boundarie: ").append(rightDomainBoundarie).append(", ");
        sb.append("Fitness: ").append(fitness).append(", ");
        sb.append("Chromosomes:\n");

        for (int i = 0; i < size; i++) {
            sb.append("Chromosome ").append(i).append(": ").append(chromosomes[i]).append("\n");
        }

        sb.append("]");
        return sb.toString();
    }

    @Override
    public void addChromosome(ChromosomeInterface chromosome) {
        if (populationTail >= this.size) {
            return;
        }
        chromosomes[populationTail] = chromosome;
        populationTail++;
    }

}
