package Framework.Test;

import Framework.GeneInterface;

public class Gene<T> implements GeneInterface<T> {
    private T geneValue;
    private int leftDomainBoundarie;
    private int rightDomainBoundarie;

    @Override
    public void setGene(T geneValue) {
        this.geneValue = geneValue;
    }

    @Override
    public T getGene() {
        return geneValue;
    }

    @Override
    public void setLeftDomainBoundarie(int leftDomainBoundarie) {
        this.leftDomainBoundarie = leftDomainBoundarie;
    }

    @Override
    public void setRightDomainBoundarie(int rightDomainBoundarie) {
        this.rightDomainBoundarie = rightDomainBoundarie;
    }

    @Override
    public int getLeftDomainBoundarie() {
        return leftDomainBoundarie;
    }

    @Override
    public int getRightDomainBoundarie() {
        return rightDomainBoundarie;
    }

    @Override
    public String toString() {
        return "Gene [Value=" + geneValue + ", LeftBound=" + leftDomainBoundarie + ", RightBound=" + rightDomainBoundarie + "]";
    }
}
