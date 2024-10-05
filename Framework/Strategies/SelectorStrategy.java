package Framework.Strategies;

import Framework.PopulationComponents.PopulationInterface;

public interface SelectorStrategy<T extends Number> {
    public PopulationInterface<T> selectNextGeneration(PopulationInterface<T> population);
}
