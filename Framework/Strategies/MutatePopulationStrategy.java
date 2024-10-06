package Framework.Strategies;

import Framework.PopulationComponents.PopulationInterface;

public interface MutatePopulationStrategy {
    public void mutate(PopulationInterface population, float mutateProbability);
}
