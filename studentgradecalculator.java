import java.util.Scanner;
public class studentgradecalculator
{
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of subjects:");
        int numSubjects=scanner.nextInt();
        double totalMarks=0;
        for(int i=1;i<=numSubjects;i++)
        {
            System.out.println("Enter marks obtained in subject_"+i+":");
            double subjectsMarks=scanner.nextDouble();
            totalMarks+=subjectsMarks;
        }

        System.out.println("Total Marks:"+totalMarks);
        double averagePercentage=totalMarks/(numSubjects*100)*100;
        System.out.println("Average Percentage:"+averagePercentage+"%");
        char grade;
        if(averagePercentage >= 85)
        {
            grade='A';
        }
        else if(averagePercentage >=70)
        {
            grade='B';
        }
        else if(averagePercentage >=65)
        {
            grade='C';
        }  
        else if(averagePercentage >=45)
        {
            grade='D';
        }
        else
        {
            grade='F';
        }
    
        System.out.println("grade:"+grade);
        scanner.close();

    }
}