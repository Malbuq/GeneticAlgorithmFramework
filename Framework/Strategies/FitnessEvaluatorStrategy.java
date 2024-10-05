package Framework.Strategies;

import Framework.ChromosomeInterface;
import Framework.GeneInterface;
import Framework.PopulationInterface;

public interface FitnessEvaluatorStrategy<T extends Number> {
    public float calculatePopulationFitness(PopulationInterface<T> population);
    public float calculateChromosomeFitness(ChromosomeInterface<T> chromosome);
    public float calculateGeneFitness(GeneInterface<T> gene);
}
