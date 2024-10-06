package Framework.PopulationComponents;

public interface PopulationInterface {
    public int getSize();

    public void setSize(int size);

    public ChromosomeInterface getChromosomeAt(int index);

    public void setChromosomeAt(int index, ChromosomeInterface geneValue);

    public void addChromosome(ChromosomeInterface chromosome);

    public int getRightDomainBoundarie();

    public void setRightDomainBoundarie(int rightDomainBoundarie);

    public int getleftDomainBoundarie();

    public void setLeftDomainBoundarie(int leftDomainBoundarie);

    public float getFitness();

    public void setFitness(float fitness);

    public void generateInitialPopulation(int chromosomeLength);

}
