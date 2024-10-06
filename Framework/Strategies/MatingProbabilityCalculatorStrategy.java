package Framework.Strategies;

import Framework.PopulationComponents.PopulationInterface;

public interface MatingProbabilityCalculatorStrategy {
    public void calculatePopulationMatingProbability(PopulationInterface population);
}
