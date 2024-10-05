package Framework.Test;

import Framework.PopulationComponents.ChromosomeInterface;
import Framework.PopulationComponents.PopulationInterface;
import Framework.Strategies.FitnessEvaluatorStrategy;

public class SphereEvaluatorStrategy implements FitnessEvaluatorStrategy {

    @Override
    public float calculatePopulationFitness(PopulationInterface population) {
        float populationTotalFitness = 0;

        for (int i = 0; i < population.getSize(); i++) {
            ChromosomeInterface chromosome = population.getChromosomeAt(i);
            populationTotalFitness += chromosome.getFitness();
        }

        return populationTotalFitness;
    }

    @Override
    public float calculateChromosomeFitness(ChromosomeInterface chromosome) {
        float chromosomeTotalFitness = 0;

        for(int i = 0; i < chromosome.getLength(); i++) {
            chromosomeTotalFitness += chromosome.getGeneAt(i).intValue() * chromosome.getGeneAt(i).intValue();
        }

        return chromosomeTotalFitness;
    }

}
