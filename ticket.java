package tickets;







public class ticket {



double tea;



double bed;



int s_student;



String Student;



String Tea;



String Bed;



double price;



ticket( String Student,String Tea,String Bed,double tarif){



if ("Да".equals(Tea)) {



tea=8.00;



} else{tea=0.00;}



if ("Да".equals(Bed)){



bed=25.00;



}else{bed=0.00;}



if ("Да".equals(Student)){



s_student=50;



}else{s_student=100;}







price=(tarif*s_student/100)+tea+bed;







}





}
