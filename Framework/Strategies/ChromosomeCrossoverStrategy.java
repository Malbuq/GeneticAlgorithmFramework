package Framework.Strategies;

import Framework.PopulationInterface;

public interface ChromosomeCrossoverStrategy<T extends Number> {
    public PopulationInterface<T> crossover(PopulationInterface<T> population, float crossoverProbability);
}
