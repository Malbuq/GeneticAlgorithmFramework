package Framework.Strategies;

import Framework.PopulationComponents.PopulationInterface;

public interface MutatePopulationStrategy {
    public PopulationInterface mutate(PopulationInterface population, float mutateProbability);
}
