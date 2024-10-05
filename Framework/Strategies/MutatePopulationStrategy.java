package Framework.Strategies;

import Framework.PopulationInterface;

public interface MutatePopulationStrategy<T extends Number> {
    public PopulationInterface<T> mutate(PopulationInterface<T> population, float mutateProbability);
}
