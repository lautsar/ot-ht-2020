package journal.domain;

public class Horse {
    enum Gender {
        stallion,
        mare,
        gelding
    }
    
    private String name;
    private Gender gender;
    private int yearOfBirth;
    
    public Horse(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setYearOfBirth(int year) {
        this.yearOfBirth = year;
    }
    
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    
    public void printInformation() {
        System.out.println("Name: " + this.name);
        System.out.println("Gender: " + this.gender);
        System.out.println("Year of birth: " + this.yearOfBirth);
    }
}
