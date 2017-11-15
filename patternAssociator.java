import java.util.Scanner;

public class patternAssociator{
    
    static int numInputs, numOutputs, numPatterns, numIterations;
    static double learningRate;
    static int[][] inOutValues = {{1,-1,-1,-1},{-1,1,-1,-1},{-1,-1,1,1},{1,1,1,1}};
    //static int[] outPut
    static Double[][] weights = {{0.0,0.0,0.0}, {0.0,0.0,0.0}, {0.0,0.0,0.0},{0.0,0.0,0.0}};
    static boolean Hebb, Delta;
    
    public static void main(String[] args)
    {
        Hebb = false;
        Delta = false;
        
        //TO DO: handle exceptions
        /*
        numInputs = Integer.parseInt(args[0]);
        numOutputs = Integer.parseInt(args[1]);
        numPatterns = Integer.parseInt(args[2]);
        numIterations = Integer.parseInt(args[3]);
        learningRate = Double.parseDouble(args[4]);
        */
        
        numInputs = 3;
        numOutputs = 1;
        numPatterns = 4;
//        numIterations = Integer.parseInt(args[3]);
        learningRate = 0.2;
         
        System.out.println("Please indicate which learning rule you wish to use: 1 for Hebb, 2 for Delta");
        
        Scanner scanner = new Scanner(System.in);
        
        double rule = Double.parseDouble(scanner.nextLine());
        
        
        
        //HOW TO GET UNIT MATRIX???
        
       // inOutValues = int[numPatterns][4];
       // inOutValues = {{1,1,0,2},{1,-1,1,1},{0,1,2,3}};
       // weights = int[numPatterns][3];
        double next = 0;
        /*for (int i = 0; i < numPatterns; i++)
        {
            for (int j=0; j<3 ; j++)
            {
                weights [i][j] = 0.0;
            }
        }
        */
        
        //TO DO: handle exception
        if (rule == 1){
            //Hebb = true;
            learnHebb();
            
        }
        else if (rule == 2){
            Delta = true;
        }
        
        printPatterns();
        printWeights();
        
        
        /*
        for (int i = 0; i < numPatterns; i++)
        {
            System.out.println("Please enter pattern " + i+1)
            for (int j = 0; j < 4; j++)
            {
                if ( j = 3)
                {
                   System.out.println("Please enter output ")
                    next = scanner.nextLine();
                    inOutValues[i][j] = next
                }
                else
                {
                    System.out.println("Please enter input " + j+1)
                    next = scanner.nextLine();
                    inOutValues[i][j] = next;
                }
            
            }
        }*/
        
    }
    
    public static void printWeights()
    {
        for (int i = 0; i < numPatterns; i++)
        {
            System.out.println();
            for (int j=0; j<3 ; j++)
            {
                System.out.print(weights[i][j] + " ");
            }
            
            
        }
        
    }
    public static void printPatterns()
    {
        for (int i = 0; i < numPatterns; i++)
        {
            for (int j=0; j<4 ; j++)
            {
                System.out.print(inOutValues[i][j]+ " ");
            }
            System.out.println();
            
        }
        
    }
    
    
    /*
    public boolean activation(){
   
        return true;
        //calculate sum = inputs*weights
        //calculate activation value = threshold function
        //compare activation value to target value
    }
    */
    
    public static void  learnHebb()
    {
        double sum = 0;
        boolean[] flags = {true, true, true, true};
        int counter=0;
        
        while ((flags[0] == true) && (flags[1] == true) && (flags[2] == true) && (flags[3] == true) && (counter < 10)){
            System.out.println();
            System.out.println("Learning round #  " + counter);
        
            for (int i = 0; i < numPatterns; i++){
                
                for (int j=0; j<3 ; j++){
                    weights [i][j] = weights [i][j] + ( learningRate * inOutValues[i][j] * inOutValues[i][3]);
                
                    
                    sum += weights[i][j] * inOutValues[i][j];
                }
            

                
                if (sum == inOutValues[i][3]){
                    flags[i] = false;
                    System.out.println("predection value: " + sum + " didn't match  target valu: " + inOutValues[i][3]);
                    
                }
            }
                            printWeights();
                            counter++;
        }
    }
   
    
    
    //Learn (Update W) When needed
    //Repeat until you associate all patterns correctly
    
              /*
    class Pattern{
    
        int[3] values;
        int[2] weights;
        
        public Pattern(){
              value = {0, 0, 0, 0};
              weigh = {0, 0, 0};
        }
        
        public Pattern(int[] val, int[] wei){
            values = val;
            weights = wei;
        }
        
        updateValue(int[] newVal){
            values = newVal;
        }
        
        updateWeights(int[] newWei){
            weights = wei;
        }
        
        int[] getValue(){
            return Value;
        }
        
        int[] getWeight(){
            return weight;
        }
    } */
}
    
