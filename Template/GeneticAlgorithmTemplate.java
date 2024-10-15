package Template;

import Framework.PopulationComponents.ChromosomeInterface;
import Framework.PopulationComponents.PopulationInterface;
import Framework.Strategies.ChromosomeCrossoverStrategy;
import Framework.Strategies.FitnessEvaluatorStrategy;
import Framework.Strategies.MatingProbabilityCalculatorStrategy;
import Framework.Strategies.MutatePopulationStrategy;
import Framework.Strategies.SelectorStrategy;
import Framework.Test.Chromosome;
import Framework.Test.Population;

public abstract class GeneticAlgorithmTemplate {
    private int populationSize;
    private int chromosomeLength;
    private int leftDomainBound;
    private int rightDomainBound;
    private PopulationInterface population;

    public GeneticAlgorithmTemplate(int populationSize, int chromosomeLength, int leftDomainBound,
            int rightDomainBound) {
        this.populationSize = populationSize;
        this.chromosomeLength = chromosomeLength;
        this.leftDomainBound = leftDomainBound;
        this.rightDomainBound = rightDomainBound;
    }

    public void generateInitialPopulation() {
        population = new Population(populationSize, leftDomainBound, rightDomainBound);

        for (int i = 0; i < populationSize; i++) {
            Chromosome chromosome = new Chromosome(chromosomeLength);
            chromosome.populateChromosome(leftDomainBound, rightDomainBound);
            population.setChromosomeAt(i, chromosome);
        }
    }

    public void evaluatePopulation(FitnessEvaluatorStrategy fitnessEvaluator) {
        for (int geneIndex = 0; geneIndex < population.getSize(); geneIndex++) {
            ChromosomeInterface chromosome = population.getChromosomeAt(geneIndex);
            chromosome.setFitness(fitnessEvaluator.calculateChromosomeFitness(chromosome));
        }

        population.setFitness(fitnessEvaluator.calculatePopulationFitness(population));
    }

    public void calculatePopulationMatingProbability(MatingProbabilityCalculatorStrategy matingProbabilityStrategy) {
        matingProbabilityStrategy.calculatePopulationMatingProbability(population);
    }

    public void createNextGeneration(SelectorStrategy fitnessSelectorStrategy) {
        population = (Population) fitnessSelectorStrategy.selectNextGeneration(population);
    }

    public void crossoverPopulation(ChromosomeCrossoverStrategy crossoverStrategy, float crossoverProbability) {
        population = (Population) crossoverStrategy.crossoverPopulation(population, crossoverProbability);
    }

    public void mutatePopulation(MutatePopulationStrategy mutationStrategy, float mutationProbability) {
        mutationStrategy.mutate(population, mutationProbability);
    }

    public ChromosomeInterface selectBestChromosomeFromPopulation() {
        ChromosomeInterface bestChromosome = population.getChromosomeAt(0);

        for (int geneIndex = 1; geneIndex < population.getSize(); geneIndex++) {
            ChromosomeInterface currenteChromosome = population.getChromosomeAt(geneIndex);
            if (bestChromosome.getFitness() > currenteChromosome.getFitness()) {
                bestChromosome = currenteChromosome;
            }
        }

        return bestChromosome;
    }

    public void run(int numberGenerations, FitnessEvaluatorStrategy fitnessEvaluator,
            MatingProbabilityCalculatorStrategy matingProbabilityStrategy, SelectorStrategy fitnessSelectorStrategy,
            ChromosomeCrossoverStrategy crossoverStrategy, float crossoverProbability,
            MutatePopulationStrategy mutationStrategy, float mutationProbability) {
        generateInitialPopulation();
        for (int iteration = 0; iteration < numberGenerations; iteration++) {
            evaluatePopulation(fitnessEvaluator);
            System.out.println(selectBestChromosomeFromPopulation());
            calculatePopulationMatingProbability(matingProbabilityStrategy);
            createNextGeneration(fitnessSelectorStrategy);
            crossoverPopulation(crossoverStrategy, crossoverProbability);
            mutatePopulation(mutationStrategy, mutationProbability);
        }
    }
}
