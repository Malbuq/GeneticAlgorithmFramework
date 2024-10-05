package Framework.Strategies;

import Framework.PopulationInterface;

public interface MatingProbabilityCalculatorStrategy<T extends Number> {
    public void calculatePopulationMateProbability(PopulationInterface<T> population);
}
