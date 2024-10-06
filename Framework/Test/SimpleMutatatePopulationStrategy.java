package Framework.Test;

import java.util.Random;

import Framework.PopulationComponents.ChromosomeInterface;
import Framework.PopulationComponents.PopulationInterface;
import Framework.Strategies.MutatePopulationStrategy;

public class SimpleMutatatePopulationStrategy implements MutatePopulationStrategy {

    @Override
    public void mutate(PopulationInterface population, float mutateProbability) {
        float noMutationProbability = 0;
        boolean dontMutateGene;
        for (int chromosomeIndex = 0; chromosomeIndex < population.getSize(); chromosomeIndex++) {

            ChromosomeInterface chromosome = population.getChromosomeAt(chromosomeIndex);

            for (int geneIndex = 0; geneIndex < chromosome.getLength(); geneIndex++) {
                noMutationProbability = (float) Math.random();
                dontMutateGene = noMutationProbability > mutateProbability;

                if (dontMutateGene) {
                    continue;
                }
                
                Random random = new Random();
                Number newGeneValue = random.nextInt(population.getRightDomainBoundarie() - population.getleftDomainBoundarie()) + population.getleftDomainBoundarie();
                chromosome.setGeneAt(geneIndex, newGeneValue);

            }

        }
    }

}
