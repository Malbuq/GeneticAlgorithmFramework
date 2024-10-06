package Framework.Test;

import Framework.PopulationComponents.ChromosomeInterface;
import Framework.PopulationComponents.PopulationInterface;
import Framework.Strategies.MatingProbabilityCalculatorStrategy;

public class ComplementaryMatingProbabilityStrategy implements MatingProbabilityCalculatorStrategy {

    @Override
    public void calculatePopulationMatingProbability(PopulationInterface population) {
        for (int i = 0; i < population.getSize(); i++) {
            ChromosomeInterface chromosome = population.getChromosomeAt(i);
            chromosome.setProbability(1 - chromosome.getFitness() / population.getFitness());
        }
    }

}
