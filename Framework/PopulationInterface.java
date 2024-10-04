package Framework;

public interface PopulationInterface<T> {
    public int getSize();
    public void setSize(int size);

    public void addChromosome(ChromosomeInterface<T> chromosome);
    public ChromosomeInterface<T> getChromosomeAt(int index);
}
