package Framework.Strategies;

import Framework.PopulationComponents.ChromosomeInterface;
import Framework.PopulationComponents.PopulationInterface;

public interface ChromosomeCrossoverStrategy {
    public PopulationInterface crossoverPopulation(PopulationInterface population, float crossoverProbability);
    public ChromosomeInterface crossoverChromosomes(ChromosomeInterface father, ChromosomeInterface mother);

}
