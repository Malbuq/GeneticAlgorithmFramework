package Framework.Strategies;

import Framework.PopulationComponents.PopulationInterface;

public interface MatingProbabilityCalculatorStrategy {
    public void calculatePopulationMateProbability(PopulationInterface population);
}
