public class Person {
    private String personName;
    private Phone phone;

    public Person(String personName, Phone phone){
        this.personName = personName;
        this.phone = phone;
    }

    public String getPersonName() {
        return personName;
    }

    public void playGame(){
        System.out.println(phone.getPhoneKind() + "으로 게임을 합니다");
    }

    public void sendMessage(Person person){
        System.out.println(person.getPersonName()+"님의 번호 " + person.phone.getPhoneNumber() + "에 문자를 보냈습니다.");
    }
}
