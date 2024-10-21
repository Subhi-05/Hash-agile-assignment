import java.util.Date;

public class EmployeeData {

    private String employee_ID;
    private String full_Name;
    private String job_Title;
    private String department;
    private String business_Unit;
    private String gender;
    private String ethnicity;
    private int age;
    private String hire_Date;
    private String annual_Salary;
    private String bonus_percent;
    private String country;
    private String city;
    private String exit_Date;

    public EmployeeData(){}

    public EmployeeData(String[] ar) {
        this.employee_ID = (ar[0].isEmpty()) ? "" : ar[0];
        this.full_Name = (ar[1].isEmpty()) ? "" : ar[1];
        this.job_Title = (ar[2].isEmpty()) ? "" : ar[2];
        this.department = (ar[3].isEmpty()) ? "" : ar[3];
        this.business_Unit = (ar[4].isEmpty()) ? "" : ar[4];
        this.gender = (ar[5].isEmpty()) ? "" : ar[5];
        this.ethnicity = (ar[6].isEmpty()) ? "" : ar[6];
        this.age = (ar[7].isEmpty()) ? -1 : Integer.parseInt(ar[7]);
        this.hire_Date = (ar[8].isEmpty()) ? "" : ar[8];
        this.annual_Salary = (ar[9].isEmpty()) ? "" : ar[9];
        this.bonus_percent = (ar[10].isEmpty()) ? "" : ar[10];
        this.country = (ar[11].isEmpty()) ? "" : ar[11];
        this.city = (ar[12].isEmpty()) ? "" : ar[12];
        this.exit_Date = (ar.length == 14) ? (ar[13].isEmpty()) ? "" : ar[13] : "";
    }

    public String getEmployee_ID() {
        return employee_ID;
    }

    public void setEmployee_ID(String employee_ID) {
        this.employee_ID = employee_ID;
    }

    public String getFull_Name() {
        return full_Name;
    }

    public void setFull_Name(String full_Name) {
        this.full_Name = full_Name;
    }

    public String getJob_Title() {
        return job_Title;
    }

    public void setJob_Title(String job_Title) {
        this.job_Title = job_Title;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getBusiness_Unit() {
        return business_Unit;
    }

    public void setBusiness_Unit(String business_Unit) {
        this.business_Unit = business_Unit;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHire_Date() {
        return hire_Date;
    }

    public void setHire_Date(String hire_Date) {
        this.hire_Date = hire_Date;
    }

    public String getAnnual_Salary() {
        return annual_Salary;
    }

    public void setAnnual_Salary(String annual_Salary) {
        this.annual_Salary = annual_Salary;
    }

    public String getBonus_percent() {
        return bonus_percent;
    }

    public void setBonus_percent(String bonus_percent) {
        this.bonus_percent = bonus_percent;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getExit_Date() {
        return exit_Date;
    }

    public void setExit_Date(String exit_Date) {
        this.exit_Date = exit_Date;
    }

    @Override
    public String toString() {
        return "employee_ID='" + employee_ID + '\'' +
                ", full_Name='" + full_Name + '\'' +
                ", job_Title='" + job_Title + '\'' +
                ", department='" + department + '\'' +
                ", business_Unit='" + business_Unit + '\'' +
                ", gender='" + gender + '\'' +
                ", ethnicity='" + ethnicity + '\'' +
                ", age=" + age +
                ", hire_Date=" + hire_Date +
                ", annual_Salary='" + annual_Salary + '\'' +
                ", bonus_percent='" + bonus_percent + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", exit_Date=" + exit_Date;
    }
}
