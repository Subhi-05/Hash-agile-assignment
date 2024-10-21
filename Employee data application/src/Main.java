import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Scanner ip = new Scanner(System.in);

    public static void main(String[] args) throws IOException, NoSuchFieldException, IllegalAccessException {
        mainMenu();
    }

    public static void mainMenu() throws IOException, NoSuchFieldException, IllegalAccessException {

//        1. create collection
        EmployeeDataManipulation.createCollection();

//        2. getCount
        int count = EmployeeDataManipulation.getEmpCount(EmployeeDataManipulation.employeeDataSet);
        System.out.println("\nGet count : " + count + "\n");

//        3. delete by employeeId
        String empid = "E02013";
        boolean find = EmployeeDataManipulation.delEmpById(EmployeeDataManipulation.employeeDataSet, empid);
        System.out.println("Delete by employee id:-\n"+((find) ? "Employee data with " + empid + " is deleted\n" : "Employee data with " + empid + " is not found\n"));

//        4. get Department count
        HashMap<String, Integer> res = EmployeeDataManipulation.getDepFacet(EmployeeDataManipulation.employeeDataSet);
        System.out.println("Department count:-");
        for(Map.Entry<String, Integer> emp : res.entrySet())
            System.out.println(emp.getKey()+" : "+ emp.getValue());
        System.out.println("\n");

//        5. search by column
        List<EmployeeData> resdata = EmployeeDataManipulation.searchByColumn(EmployeeDataManipulation.employeeDataSet, "Country", "United States");
        System.out.println("Searching data by column:-");
        for(EmployeeData e: resdata)
            System.out.println(e);
        System.out.println("\n");

//        6 index data excluded
        List<List> x = EmployeeDataManipulation.indexData(EmployeeDataManipulation.employeeDataSet, "Job Title");
        System.out.println("Excluded column:-");
        for(List j : x)
            System.out.println(j);
    }
}