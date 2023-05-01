package org.example;

public class impl {
    public static void main(String[] args) {
        book b=new book();
        b.setISBNnumber("45678");
        b.setDescription("horrorbook");
        b.setTitle("conjuring");
        b.setPrice(800.87f);
        System.out.println(" "+b.getTitle()+","+b.getISBNnumber()+","+b.getDescription());
        System.out.println(" "+b.getPrice());
        author a=new author();
        a.setAuthorname("s.hook");
        a.setAuthorpenname("s.hk");
        b.setAuth(a);
        System.out.println(" "+a.getAuthorname()+","+a.getAuthorpenname());
        System.out.println(b);
        student s1=new student(23,46,32);
        System.out.println(s1);
        student s2=new student(46,43,56);
        System.out.println(s2);
        student s3=new student(56,78,89);
        System.out.println(s3);
        s3.setMarks1(34);
        s3.setMarks2(67);
        s3.setMarks3(86);
        System.out.println(""+s3.getMarks1()+""+s3.getMarks2()+""+s3.getMarks3());
        System.out.println(s3);


    }

}
