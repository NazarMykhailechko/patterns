package patterns.builder;

public class TestBuilder {

    public static void main(String[] args) {
         MyEmailBuilder myEmailBuilder = new MyEmailBuilder();
         MyEmail myEmail = myEmailBuilder.from("WIN72007@ukr.net")
                                         .to("Mykhailechko@accordbank.com.ua")
                                         .copy("voitkiv@ukr.net")
                                         .subject("some new info")
                                         .text("Hello, how are you doing?")
                                         .buildEmail();
        System.out.println(myEmail);

    }

}

class MyEmail{

    private String from;
    private String to;
    private String copy;
    private String subject;
    private String text;

    public void setFrom(String from) {
        this.from = from;
    }
    public void setTo(String to) {
        this.to = to;
    }
    public void setCopy(String copy) {
        this.copy = copy;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "MyEmail{" +
                "from='" + from + '\n' +
                ", to='" + to + '\n' +
                ", copy='" + copy + '\n' +
                ", subject='" + subject + '\n' +
                ", text='" + text + '\n' +
                '}';
    }
}

class MyEmailBuilder{

    private MyEmail myEmail;

    public MyEmailBuilder() {
        myEmail = new MyEmail();
    }

    public MyEmailBuilder(MyEmail myEmail) {
        this.myEmail = myEmail;
    }

    public MyEmailBuilder from(String from){
        myEmail.setFrom(from);
        return this;
    }
    public MyEmailBuilder to(String to){
        myEmail.setTo(to);
        return this;
    }
    public MyEmailBuilder copy(String copy){
        myEmail.setCopy(copy);
        return this;
    }
    public MyEmailBuilder subject(String subject){
        myEmail.setSubject(subject);
        return this;
    }
    public MyEmailBuilder text(String text){
        myEmail.setText(text);
        return this;
    }

    public MyEmail buildEmail(){
        return myEmail;
    }
}
