



public class GeneticAlgo {
public static final int Population_Size=8;
    public static final int[] Target_Chromosome = {1,1,0,1,0,0,1,1,1,0};
    private  static final double Mutation_Rate=0.25;
    public static final int Num_Of_Elite_Chromosome=1;
    public static final int Tour_Selection_Size=4;
    public Population evolve(Population population){
        return mutatePopulation(crossoverPopulation(population));
    }
private Population crossoverPopulation(Population population){
    Population crossoverPopulation =new Population(population.geChromosomes().length);
     for(int x =0;x< Num_Of_Elite_Chromosome;x++){
         crossoverPopulation.geChromosomes()[x] = population.geChromosomes()[x];
     }
    for(int x=Num_Of_Elite_Chromosome; x<population.geChromosomes().length;x++){
         Chromosome chromosome1=selectionPopulation(population).geChromosomes()[0];
           Chromosome chromosome2=selectionPopulation(population).geChromosomes()[0];
        crossoverPopulation.geChromosomes()[x]=crossoverChromosome(chromosome1, chromosome2);
    }
     return crossoverPopulation;
}
private Population mutatePopulation(Population population){
     Population mutatePopulation =new Population(population.geChromosomes().length);
     for(int x =0;x< Num_Of_Elite_Chromosome;x++){
         mutatePopulation.geChromosomes()[x] = population.geChromosomes()[x];
     }
     for(int x=Num_Of_Elite_Chromosome;x<population.geChromosomes().length;x++){
         mutatePopulation.geChromosomes()[x]=mutateChromosome(population.geChromosomes()[x]);
     }
    return mutatePopulation;
}
private Chromosome crossoverChromosome(Chromosome chromosome1, Chromosome chromosome2){
    Chromosome crossoverchromosome = new Chromosome(Target_Chromosome.length);
    for (int x =0; x < chromosome1.getGenes().length;x++){
        if(Math.random()<0.5)
            crossoverchromosome.getGenes()[x]=chromosome1.getGenes()[x];
        else
            crossoverchromosome.getGenes()[x]=chromosome2.getGenes()[x];
    }
    return crossoverchromosome;
}
private Chromosome mutateChromosome(Chromosome chromosome){
    Chromosome muChromosome=new Chromosome(Target_Chromosome.length);
    for(int x=0; x<chromosome.getGenes().length;x++){
        if(Math.random()<Mutation_Rate){
            if(Math.random()<0.5)
                muChromosome.getGenes()[x]=1;
            else
                muChromosome.getGenes()[x]=0;
        } else 
            muChromosome.getGenes()[x]=chromosome.getGenes()[x];
    }
    return muChromosome;
}
private Population selectionPopulation(Population population){
    Population tourPopulation=new Population(Tour_Selection_Size);
    for(int x =0;x<Tour_Selection_Size;x++){
        tourPopulation.geChromosomes()[x]=population.geChromosomes()[(int)(Math.random()*population.geChromosomes().length)];
        
    }
    tourPopulation.storChromosonesByFitness();
    return tourPopulation;
}
}
