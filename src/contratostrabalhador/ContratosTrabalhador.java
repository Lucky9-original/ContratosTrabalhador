package contratostrabalhador;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class ContratosTrabalhador {
    public static void main(String[] args) throws ParseException {
        // TODO code application logic here
        
        Scanner tec = new Scanner(System.in);
        
        System.out.print("Enter department's name: ");
        String department = tec.nextLine();
        
        System.out.println("Enter worker data: ");
        System.out.print("Name: ");
        String name = tec.nextLine();
        System.out.print("Level: ");
        String workerLevel = tec.nextLine();
        System.out.print("Base salary: ");
        double salary = tec.nextDouble();
        
        Worker worker = new Worker(name, WorkerLevel.valueOf(workerLevel), salary, new Department(department));
        
        System.out.println("");
        System.out.print("How many contracts to this worker? ");
        int n = tec.nextInt();
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 1; i<=n; i++){
            System.out.println("Enter contract #" + i + " data: ");
            System.out.print("Date (DD/MM/YYYY): ");
            Date date = sdf.parse(tec.next());
            System.out.print("Value per hour: ");
            sdf.format(date);
            double valuePerHour = tec.nextDouble();
            System.out.print("Duration (hours): ");
            int hours = tec.nextInt();
            
            worker.addContract(new HourContract(date, valuePerHour, hours));
        }
        
        System.out.println("");
        SimpleDateFormat sdf2 = new SimpleDateFormat("MM/yyyy");
        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        Date date2 = sdf2.parse(tec.next());
        Calendar cal = Calendar.getInstance();
        cal.setTime(date2);
        int year = cal.get(Calendar.YEAR);
        int month = 1 + cal.get(Calendar.MONTH);
        
        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName());
        System.out.println("Income for " + sdf2.format(date2) + ": " + String.format("%.2f", worker.income(year, month)));
        
    }
    
}
