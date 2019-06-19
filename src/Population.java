


import java.util.Arrays;


public class Population {
    private Chromosome[] chromosomes;
    public Population(int length){
        chromosomes = new Chromosome[length];
    }
    public Population initiPopulation(){
        for(int x=0;x<chromosomes.length;x++){
            chromosomes[x] = new Chromosome(GeneticAlgo.Target_Chromosome.length).InitializeChrom();
        }
        storChromosonesByFitness();
        return this;
    }
     public Chromosome[] geChromosomes(){
           return chromosomes;  
         }
    public void storChromosonesByFitness(){
        Arrays.sort(chromosomes,(chromosome1,chromosome2) -> {
        int flage=0;
        if (chromosome1.getFitness() > chromosome2.getFitness())
            flage=-1;
        else if(chromosome1.getFitness() < chromosome2.getFitness())
            flage=1;
        return flage;
        
    });
    }
}
