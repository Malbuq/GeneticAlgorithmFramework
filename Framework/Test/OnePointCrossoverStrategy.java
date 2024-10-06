package Framework.Test;

import java.util.Random;

import Framework.PopulationComponents.ChromosomeInterface;
import Framework.PopulationComponents.PopulationInterface;
import Framework.Strategies.ChromosomeCrossoverStrategy;

public class OnePointCrossoverStrategy implements ChromosomeCrossoverStrategy {

    @Override
    public PopulationInterface crossoverPopulation(PopulationInterface currentPopulation, float crossoverProbability) {
        int populationSize = currentPopulation.getSize();
        Population newPopulation = new Population(populationSize, currentPopulation.getleftDomainBoundarie(),
                currentPopulation.getRightDomainBoundarie());
        newPopulation.setFitness(currentPopulation.getFitness());
        int randomChomosomeIndex;
        Random random = new Random();
        int newPopulationPointer = 0;

        boolean dontCrossover;
        boolean isPopulationOdd = populationSize % 2 != 0;

        if (isPopulationOdd) {
            randomChomosomeIndex = random.nextInt(populationSize);
            ChromosomeInterface randomChromosome = currentPopulation.getChromosomeAt(randomChomosomeIndex);
            newPopulation.setChromosomeAt(newPopulationPointer, randomChromosome);
            newPopulationPointer++;
        }

        while (newPopulationPointer < populationSize) {
            randomChomosomeIndex = random.nextInt(populationSize);
            ChromosomeInterface chromosomeFather = currentPopulation.getChromosomeAt(randomChomosomeIndex);

            randomChomosomeIndex = random.nextInt(populationSize);
            ChromosomeInterface chromosomeMother = currentPopulation.getChromosomeAt(randomChomosomeIndex);

            double randomProbability = Math.random();

            dontCrossover = randomProbability > crossoverProbability;

            if (dontCrossover) {
                newPopulation.setChromosomeAt(newPopulationPointer, chromosomeFather);
                newPopulationPointer++;

                newPopulation.setChromosomeAt(newPopulationPointer, chromosomeMother);
                newPopulationPointer++;
                continue;
            }

            
            ChromosomeInterface firstChild = this.crossoverChromosomes(chromosomeFather, chromosomeMother);
            ChromosomeInterface secondChild = this.crossoverChromosomes(chromosomeMother, chromosomeFather);
            
            newPopulation.setChromosomeAt(newPopulationPointer, firstChild);
            newPopulationPointer++;
            
            newPopulation.setChromosomeAt(newPopulationPointer, secondChild);
            newPopulationPointer++;
        }
        
        return newPopulation;
    }
    
    public ChromosomeInterface crossoverChromosomes(ChromosomeInterface chromosomeLeft, ChromosomeInterface chromosomeRight) {
        Random random = new Random();
        int chromosomeLength = chromosomeLeft.getLength();
        ChromosomeInterface child = new Chromosome(chromosomeLength);
        int crossoverPoint = random.nextInt(chromosomeLength);

        for(int geneIndex = 0; geneIndex < chromosomeLength; geneIndex++) {
            if(geneIndex < crossoverPoint) {
                child.setGeneAt(geneIndex, chromosomeLeft.getGeneAt(geneIndex));
                continue;
            }
            child.setGeneAt(geneIndex, chromosomeRight.getGeneAt(geneIndex));
        }

        return child;
    }

}
