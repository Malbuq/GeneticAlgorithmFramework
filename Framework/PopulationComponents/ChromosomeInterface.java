package Framework.PopulationComponents;

public interface ChromosomeInterface {
    public int getLength();

    public void setLength(int length);

    public float getFitness();

    public void setFitness(float fitness);

    public float getProbability();

    public void setProbability(float probability);

    public void populateChromosome(int leftDomainBoundarie, int rightDomainBoundarie);

    public Number getGeneAt(int index);

    public void setGeneAt(int index, Number geneValue);
}
