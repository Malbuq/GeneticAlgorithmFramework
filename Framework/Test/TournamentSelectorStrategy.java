package Framework.Test;

import java.util.Random;

import Framework.PopulationComponents.ChromosomeInterface;
import Framework.PopulationComponents.PopulationInterface;
import Framework.Strategies.SelectorStrategy;

public class TournamentSelectorStrategy implements SelectorStrategy {

    @Override
    public PopulationInterface selectNextGeneration(PopulationInterface currentPopulation) {
        int populationSize = currentPopulation.getSize();

        Population newPopulation = new Population(populationSize, currentPopulation.getleftDomainBoundarie(),
                currentPopulation.getRightDomainBoundarie());

        newPopulation.setFitness(currentPopulation.getFitness());
        int newPopulationSize = 0;

        Random random = new Random();

        while (newPopulationSize < populationSize) {
            int indexA = random.nextInt(populationSize);
            int indexB = random.nextInt(populationSize);

            ChromosomeInterface A = currentPopulation.getChromosomeAt(indexA);
            ChromosomeInterface B = currentPopulation.getChromosomeAt(indexB);

            if (A.getProbability() > B.getProbability()) {
                newPopulation.addChromosome(A);
            } else {
                newPopulation.addChromosome(B);
            }

            newPopulationSize++;
        }

        return newPopulation;
    }

}
