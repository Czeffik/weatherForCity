import java.util.Scanner;

public class App {
    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in);
        System.out.println("Wprowadz nazwe miasta,dla którego chcesz odczytywać dane: ");
        new WorkingProgram(input.nextLine());
    }
}