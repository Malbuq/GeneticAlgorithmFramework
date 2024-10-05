package Framework.Test;
import java.util.Random;

import Framework.GeneInterface;

public class Gene<T extends Number> implements GeneInterface<T> {
    private T value;
    private int leftDomainBoundarie;
    private int rightDomainBoundarie;
    
    @Override
    public void setGene(T value) {
        this.value = value;
    }
    
    @Override
    public T getGene() {
        return value;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public void randomlyGenerateGene() {
        this.value = (T) Integer.valueOf(leftDomainBoundarie + (int) (Math.random() * (rightDomainBoundarie - leftDomainBoundarie)));
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
        return "Gene [Value=" + value + ", LeftBound=" + leftDomainBoundarie + ", RightBound=" + rightDomainBoundarie + "]";
    }

}

