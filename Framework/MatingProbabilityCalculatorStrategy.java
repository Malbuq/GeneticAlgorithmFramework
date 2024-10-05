package Framework;

public interface MatingProbabilityCalculatorStrategy<T extends Number> {
    public void calculatePopulationMateProbability(PopulationInterface<T> population);
}
