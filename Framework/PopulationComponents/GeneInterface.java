package Framework.PopulationComponents;
public interface GeneInterface<T extends Number> {
    public void setGene(T value);
    public T getGene();

    public void setLeftDomainBoundarie(int leftDomainBoundarie);
    public void setRightDomainBoundarie(int RightDomainBoundarie);

    public void randomlyGenerateGene();

    public int getLeftDomainBoundarie();
    public int getRightDomainBoundarie();
}
