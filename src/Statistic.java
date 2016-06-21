import java.io.*;
import java.util.ArrayList;

public class Statistic implements Serializable {

    private static String pathToDataBase;
    private static Statistic instance;

    private int javaCounter;
    private int rubyCounter;
    private int cSharpCounter;
    private int cppCounter;
    private int pythonCounter;

    private double javaPercent;
    private double rubyPercent;
    private double cSharpPercent;
    private double cppPercent;
    private double pythonPercent;

    private double averageAge;

    private ArrayList<Record> records = new ArrayList<>();

    private Statistic(){}

    public synchronized static Statistic getInstance(){

        if( instance == null){

            instance = deSerialize();

            if( instance == null)
                instance = new Statistic();
        }

        return instance;
    }

    public static void setPathToDataBase(String pathToDataBase) {
        Statistic.pathToDataBase = pathToDataBase;
    }

    public synchronized void add(Record record) {

        records.add(record);

        updateStatistics(record);

        serialize();
    }

    private void updateStatistics(Record record){

        int n = records.size();

        if( record.getJava())   javaCounter++;
        if( record.getCpp())    cppCounter++;
        if( record.getcSharp()) cSharpCounter++;
        if( record.getPython()) pythonCounter++;
        if( record.getRuby())   rubyCounter++;

        javaPercent   = round( (double)javaCounter / n);
        cppPercent    = round( (double)cppCounter / n);
        cSharpPercent = round( (double)cSharpCounter / n);
        pythonPercent = round( (double)pythonCounter / n);
        rubyPercent   = round( (double)rubyCounter / n);

        int total=0;
        for(Record r: records){
            total += r.getAge();
        }
        averageAge = round ( (double) total / n);
    }

    private double round(double a){
        return  (double) Math.round(a*100)/100;
    }

    private static Statistic deSerialize(){

        try(FileInputStream fis = new FileInputStream( pathToDataBase);
            ObjectInputStream ois = new ObjectInputStream(fis)) {

            return (Statistic) ois.readObject();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void serialize(){

        try(FileOutputStream fos = new FileOutputStream( pathToDataBase);
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject( this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getJavaCounter() {
        return javaCounter;
    }

    public int getRubyCounter() {
        return rubyCounter;
    }

    public int getcSharpCounter() {
        return cSharpCounter;
    }

    public int getCppCounter() {
        return cppCounter;
    }

    public int getPythonCounter() {
        return pythonCounter;
    }

    public double getJavaPercent() {
        return javaPercent;
    }

    public double getRubyPercent() {
        return rubyPercent;
    }

    public double getcSharpPercent() {
        return cSharpPercent;
    }

    public double getCppPercent() {
        return cppPercent;
    }

    public double getPythonPercent() {
        return pythonPercent;
    }

    public double getAverageAge() {
        return averageAge;
    }
}
