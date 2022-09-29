public class Phone {
    private String phoneKind, phoneNumber;

    public Phone(String phoneKind, String phoneNumber){
        this.phoneKind = phoneKind;
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneKind() {
        return phoneKind;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
