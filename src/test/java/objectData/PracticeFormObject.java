package objectData;

import java.util.HashMap;
import java.util.List;

public class PracticeFormObject extends CommonObject {

    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String mobileNo;
    private String gender;
    private List<String> subjects;
    private List<String> hobbies;
    private String state;
    private String city;

    public PracticeFormObject(HashMap<String, String> testData) {
        populateData(testData);

    }

    public void populateData(HashMap<String, String> testData) {
        for (String key : testData.keySet()) {
            switch (key) {
                case "firstName":
                    setFirstName(testData.get(key));
                    break;
                case "lastName":
                    setLastName(testData.get(key));
                    break;
                case "email":
                    setEmail((testData.get(key)));
                    break;
                case "address":
                    setAddress(testData.get(key));
                    break;
                case "mobileNo":
                    setMobileNo(testData.get(key));
                    break;
                case "gender":
                    setGender(testData.get(key));
                    break;
                case "subjects":
                    setSubjects(getValueList(testData.get(key)));
                    break;
                case "hobbies":
                    setHobbies(getValueList(testData.get(key)));
                    break;
                case "state":
                    setState(testData.get(key));
                    break;
                case "city":
                    setCity(testData.get(key));
                    break;
            }
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
