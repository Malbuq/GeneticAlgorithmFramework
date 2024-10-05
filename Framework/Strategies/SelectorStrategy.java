package Framework.Strategies;

import Framework.PopulationComponents.PopulationInterface;

public interface SelectorStrategy {
    public PopulationInterface selectNextGeneration(PopulationInterface population);
}
