package Framework;
public interface GeneInterface<T> {
    public void setGene(T geneValue);
    public T getGene();

    public void setLeftDomainBoundarie(int leftDomainBoundarie);
    public void setRightDomainBoundarie(int RightDomainBoundarie);

    public int getLeftDomainBoundarie();
    public int getRightDomainBoundarie();
}
