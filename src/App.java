import java.util.Scanner;

public class App {
    public static void main(String[] args){

//        ReadingUrl nowy = new ReadingUrl("http://api.openweathermap.org/data/2.5/weather?q=Oswiecim,pol&APPID=71ad073f87383bd799851e6388bfcc8a", "http://api.openweathermap.org/data/2.5/forecast?q=oswiecim,pol&APPID=71ad073f87383bd799851e6388bfcc8a" );
//        System.out.println(nowy.getMapMap());

//        WritingToFile nowy = new WritingToFile();
//        ReadingFromFile second = new ReadingFromFile();

//        DoingMath nowy = new DoingMath();
//        nowy.getDifferenceTemperature();

//        WorkingProgram nowy = new WorkingProgram();
//        MathDoing nowy = new MathDoing();
//        WritingMathToFile nowy = new WritingMathToFile();
        Scanner input = new Scanner(System.in);
        System.out.println("Wprowadz nazwe miasta,dla którego chcesz odczytywać dane: ");
        new WorkingProgram(input.nextLine());
    }
}