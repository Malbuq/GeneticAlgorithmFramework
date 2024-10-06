package Framework.Test;

import java.util.Random;

import Framework.PopulationComponents.ChromosomeInterface;
import Framework.PopulationComponents.PopulationInterface;
import Framework.Strategies.SelectorStrategy;

public class ProbabilityProportionalSelectorStrategy implements SelectorStrategy {

    @Override
    public PopulationInterface selectNextGeneration(PopulationInterface currentPopulation) {
        int populationSize = currentPopulation.getSize();
        Population newPopulation = new Population(populationSize, currentPopulation.getleftDomainBoundarie(), currentPopulation.getRightDomainBoundarie());
        int newPopulationPointer = 0;
        int randomChomosomeIndex;
        double randomProbability = 0;
        Random random = new Random();   
        
        while(newPopulationPointer < populationSize) {
            randomChomosomeIndex = random.nextInt(populationSize);
            ChromosomeInterface chromosome = currentPopulation.getChromosomeAt(randomChomosomeIndex);
            randomProbability = Math.random();

            if (randomProbability > chromosome.getProbability()) {
                continue;
            }

            newPopulation.setChromosomeAt(newPopulationPointer, chromosome);
            newPopulationPointer++;
            
        }
        
        return newPopulation;
    }

}
