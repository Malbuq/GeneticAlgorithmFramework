package Framework.Strategies;

import Framework.PopulationComponents.PopulationInterface;

public interface ChromosomeCrossoverStrategy<T extends Number> {
    public PopulationInterface<T> crossover(PopulationInterface<T> population, float crossoverProbability);
}
