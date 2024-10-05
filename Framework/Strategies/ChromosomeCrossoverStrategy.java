package Framework.Strategies;

import Framework.PopulationComponents.PopulationInterface;

public interface ChromosomeCrossoverStrategy {
    public PopulationInterface crossover(PopulationInterface population, float crossoverProbability);
}
