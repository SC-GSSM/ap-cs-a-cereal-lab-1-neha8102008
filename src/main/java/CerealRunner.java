import java.util.Scanner;
import java.util.ArrayList;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class CerealRunner
{
    private ArrayList<Cereal> cereals;

    public CerealRunner(String fileName)
    {
        cereals = new ArrayList<>();

        try
        {
            FileReader fileRdr = new FileReader(fileName);
            Scanner scan = new Scanner(fileRdr);
            
            while(scan.hasNextLine()){
                String myStr = scan.nextLine();
                if(myStr.isEmpty()) continue;
                String[] data = myStr.split(",");
                try {
                int calories = Integer.parseInt(data[1]);
                double fiber = Double.parseDouble(data[2]);
                double carbohydrates = Double.parseDouble(data[3]);
                double cups = Double.parseDouble(data[4]);
                String name = data[0];
                Cereal c = new Cereal(name, calories, fiber, carbohydrates, cups);
                cereals.add(c);
                }catch (NumberFormatException | ArrayIndexOutOfBoundsException e){
                    continue;
                }
            }
            scan.close();
            
            
        


        } catch (FileNotFoundException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        int numCereals = cereals.size();
        System.out.println(numCereals + " records created.");
    }

    public static void main(String[] args)
    {
        String fileName = "src/data/cerealSubset.csv";
        new CerealRunner(fileName);
    }

}

