package Framework.Test;

public class Main {
    public static void main(String[] args) {
        // Create some genes
        Gene<Integer> gene1 = new Gene<>();
        gene1.setGene(5);
        gene1.setLeftDomainBoundarie(0);
        gene1.setRightDomainBoundarie(10);

        Gene<Integer> gene2 = new Gene<>();
        gene2.setGene(8);
        gene2.setLeftDomainBoundarie(0);
        gene2.setRightDomainBoundarie(10);

        // Create a chromosome and set genes
        Chromosome<Integer> chromosome = new Chromosome<>(2);
        chromosome.setGeneAt(0, gene1);
        chromosome.setGeneAt(1, gene2);

        // Print chromosome
        System.out.println(chromosome);

        // Create a population and add the chromosome
        Population<Integer> population = new Population<>(1);
        population.addChromosome(chromosome);

        // Print population
        System.out.println(population);
    }
}
