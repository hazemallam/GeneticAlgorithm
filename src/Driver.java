


import java.util.Arrays;


public class Driver {
    public static void main(String[] args) {
    Population population =new Population(GeneticAlgo.Population_Size).initiPopulation();
        GeneticAlgo geneticAlgo=new GeneticAlgo();
   System.out.println("--------------------------------------");
        System.out.println("Generation # 0" + " | Fittest chromosome fitness: " + population.geChromosomes()[0].getFitness());
        printPopulation(population, "Target Chromosome: "+Arrays.toString(GeneticAlgo.Target_Chromosome));
    int generationNumber=0;
    while (population.geChromosomes()[0].getFitness()< GeneticAlgo.Target_Chromosome.length){
        generationNumber++;
         System.out.println("\n--------------------------------------");
               population=geneticAlgo.evolve(population);
                population.storChromosonesByFitness();
        System.out.println("Generation # "+generationNumber+" | Fittest chromosome fitness: " + population.geChromosomes()[0].getFitness());
        printPopulation(population, "Target Chromosome: "+Arrays.toString(GeneticAlgo.Target_Chromosome));
   
    }
    }
    public static void printPopulation(Population population, String heading){
        System.out.println(heading);
        System.out.println("------------------------------");
        for(int x=0; x<population.geChromosomes().length;x++){
            System.out.println("Chromosome # "+ x + " : " + Arrays.toString(population.geChromosomes()[x].getGenes())+
            " | Fitness: "+ population.geChromosomes()[x].getFitness());
        }
    }
}


