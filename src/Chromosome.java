


import java.util.Arrays;


public class Chromosome {
    private boolean isFitnessChanged = true;
    private int fitness=0;
    private int[] genes;
    public Chromosome(int length){
        genes = new int[length];
    }
    public Chromosome InitializeChrom(){
        for (int x =0; x < genes.length;x++){
            if(Math.random() >=0.5)//probability to produce good children 
                genes[x]=1;
            else 
                 genes[x]=0;
        }
        return this;
    } 
    public int[] getGenes(){
        isFitnessChanged =true;
        return genes;
    }
    public int getFitness(){
       if(isFitnessChanged){
           fitness=recalulateFitness();
           isFitnessChanged=false;
       }
        return fitness;
    }
    public int recalulateFitness(){
        int ChromosomeFitness=0;
        for(int x =0; x < genes.length ;x++){
            if (genes[x] == GeneticAlgo.Target_Chromosome[x])
                ChromosomeFitness++;
        }
        return ChromosomeFitness;
    }
    @Override
    public String toString(){
        return Arrays.toString(this.genes);
    }
}
