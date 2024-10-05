package Framework.Strategies;

import Framework.PopulationComponents.ChromosomeInterface;
import Framework.PopulationComponents.GeneInterface;
import Framework.PopulationComponents.PopulationInterface;

public interface FitnessEvaluatorStrategy<T extends Number> {
    public float calculatePopulationFitness(PopulationInterface<T> population);
    public float calculateChromosomeFitness(ChromosomeInterface<T> chromosome);
    public float calculateGeneFitness(GeneInterface<T> gene);
}
