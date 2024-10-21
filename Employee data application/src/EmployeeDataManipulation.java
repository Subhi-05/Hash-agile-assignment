import java.io.*;
import java.lang.reflect.Field;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class EmployeeDataManipulation {

    public static String columnName[] = new String[14];
    public static LinkedHashMap<String, String> columnMatch = new LinkedHashMap<>();
    public static String Filename = "employeeData.csv";
    public static List<EmployeeData> employeeDataSet = new ArrayList<>();

    public static void createCollection() throws IOException {
        createColumnName();

        try {
            BufferedReader br = new BufferedReader(new FileReader(Filename));
            String x = br.readLine();
            int i=0;
            for(String j: x.split(","))
                columnMatch.put(j, columnName[i++]);

            Iterator it = br.lines().iterator();
            while (it.hasNext()) {
                String data = it.next().toString();
                String[] dataSplit = data.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

                EmployeeData employee = new EmployeeData(dataSplit);
                employeeDataSet.add(employee);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createColumnName() {
        columnName[0] = "employee_ID";
        columnName[1] = "full_Name";
        columnName[2] = "job_Title";
        columnName[3] = "department";
        columnName[4] = "business_Unit";
        columnName[5] = "gender";
        columnName[6] = "ethnicity";
        columnName[7] = "age";
        columnName[8] = "hire_Date";
        columnName[9] = "annual_Salary";
        columnName[10] = "bonus_percent";
        columnName[11] = "country";
        columnName[12] = "city";
        columnName[13] = "exit_Date";
    }

    public static List<List> indexData(List<EmployeeData> emp, String column) {
        List<List> res = new ArrayList<>();
        String col="";
        int count=-1;
        for(Map.Entry<String,String> entry : columnMatch.entrySet())
        {
            count++;
            if(entry.getKey().equals(column))
            {
                col = entry.getValue();
                break;
            }
        }
        for(EmployeeData e : emp)
        {
            List data = getColumn(e, col, count);
            res.add(data);
        }
        return res;
    }

    public static List getColumn(EmployeeData e, String column, int count)
    {
        List res = new ArrayList<>();
        for(int i=0; i<columnName.length; i++)
        {
            if(i != count)
            {
                if(i==0)
                    res.add(e.getEmployee_ID());
                if(i==1)
                    res.add(e.getFull_Name());
                if(i==2)
                    res.add(e.getJob_Title());
                if(i==3)
                    res.add(e.getDepartment());
                if(i==4)
                    res.add(e.getBusiness_Unit());
                if(i==5)
                    res.add(e.getGender());
                if(i==6)
                    res.add(e.getEthnicity());
                if(i==7)
                    res.add(e.getAge());
                if(i==8)
                    res.add(e.getHire_Date());
                if(i==9)
                    res.add(e.getAnnual_Salary());
                if(i==10)
                    res.add(e.getBonus_percent());
                if(i==11)
                    res.add(e.getCountry());
                if(i==12)
                    res.add(e.getCity());
                if(i==13)
                    res.add(e.getExit_Date());
            }
        }

        return  res;
    }

    public static List<EmployeeData> searchByColumn(List<EmployeeData> emp, String column, String value) throws NoSuchFieldException, IllegalAccessException {
        String col="";
        for(Map.Entry<String,String> entry : columnMatch.entrySet())
        {
            if(entry.getKey().equals(column))
            {
                col = entry.getValue();
                break;
            }
        }

        List<EmployeeData> res = new ArrayList<>();
        for(EmployeeData e : emp)
        {
            Object x = getPropertyValue(e, col);
            if(x.equals(value))
                res.add(e);
        }

        return res;
    }

    public static Object getPropertyValue(Object obj, String propertyName) throws NoSuchFieldException, IllegalAccessException {
        Field field = obj.getClass().getDeclaredField(propertyName);
        field.setAccessible(true);
        return field.get(obj);
    }

    public static int getEmpCount(List<EmployeeData> emp) {
        return emp.size();
    }

    public static boolean delEmpById(List<EmployeeData> emp, String empId) {
        int size = emp.size();
        for (EmployeeData e : emp) {
            if (e.getEmployee_ID().equals(empId)) {
                emp.remove(e);
                break;
            }
        }

        if (emp.size() == size - 1)
            return true;

        return false;
    }

    public static HashMap<String, Integer> getDepFacet(List<EmployeeData> emp) {
        HashMap<String, Integer> result = new HashMap<>();
        for (EmployeeData e : emp) {
            String key = e.getDepartment().equals("") ? "unknown" : e.getDepartment();

            if (result.containsKey(key)) {
                result.put(key, result.get(key) + 1);
            }
            else
                result.put(key, 1);
        }

        return result;
    }
}
