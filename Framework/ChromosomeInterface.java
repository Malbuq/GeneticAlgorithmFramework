package Framework;
public interface ChromosomeInterface<T extends Number> {
    public int getLength();
    public void setLength(int length);
    
    public GeneInterface<T>[] getChromosome();
    public void setChromosome(GeneInterface<T>[] genes);

    public GeneInterface<T> getGeneAt(int index);
    public void setGeneAt(int index, GeneInterface<T> gene);

    public float getFitness();
    public void setFitness();

    public float getProbability();
    public void setProbability();

}
