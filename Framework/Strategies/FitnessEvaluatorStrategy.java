package Framework.Strategies;

import Framework.PopulationComponents.ChromosomeInterface;
import Framework.PopulationComponents.PopulationInterface;

public interface FitnessEvaluatorStrategy {
    public float calculatePopulationFitness(PopulationInterface population);
    public float calculateChromosomeFitness(ChromosomeInterface chromosome);
}
