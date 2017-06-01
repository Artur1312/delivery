package tickets;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Controller { 
double result=0.00; 
double tarif;
String k,type_k;
int c_p,c_k,c_sv;
int train_number; 
String train_name; 
int pt;
int dt=0;
int n_carriage;
int n_mesto;
int c1,c2,c3; 
String Tea,Bed,Student;
double ticket(Train tr1){ 
  SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
 c_p=tr1.c1;
 c_k=tr1.c1+tr1.c2;
 c_sv=tr1.c1+tr1.c2+tr1.c3;
System.out.println("Выбран поезд номер № "+tr1.train_number+" сообщением "+tr1.train_name
  +" дата отправления "+format.format(tr1.p_D_buy)); 
System.out.println("Вагоны: плацкарт с 1 по "+ (tr1.c1)
  +", купе с "+(tr1.c1+1)+" по "+c_k
  +", СВ с "+(c_k+1)+" по "+c_sv); 
dt=0;
k="";
System.out.println("Выберите номер вагона"); 
while(dt<1) {
try {
Scanner sc_c=new Scanner(System.in); 
n_carriage=sc_c.nextInt(); 
if (n_carriage>0 && n_carriage<=tr1.c1) {
 k="P";
 type_k="Плацкарт";
 tarif=tr1.tarif_p; 
}
else if (n_carriage>tr1.c1 && n_carriage<=c_k) {
 k="K";
 type_k="Купе";
 tarif=tr1.tarif_k; 
}
else if (n_carriage>c_k && n_carriage<=c_sv) {
 k="L";
 type_k="СВ";
 tarif=tr1.tarif_l; 
}
if (k=="") System.out.println("Введеный номер вагона отсутствует в поезде. Повторите ввод");
else dt=1;
}
catch (Exception e) {
        System.out.println("Введена не цифра. Повторите ввод");
        dt=0;
    }
}
System.out.println("Выбран тип вагона "+type_k);
Carriage c1=new Carriage(k); 
System.out.println("Максимальное количество мест в вагоне "+tr1.c[n_carriage].max_number); 
System.out.println("Выберите место"); 
dt=0;
while(dt<1) {
try {
 Scanner sc_m=new Scanner(System.in); 
n_mesto=sc_m.nextInt(); 
if (n_mesto<=0 || n_mesto>tr1.c[n_carriage].max_number) System.out.println("Такого места в вагоне нет. Повторите ввод");
else dt=1;
}
catch (Exception e) {
        System.out.println("Введена не цифра. Повторите ввод");
        dt=0;
    }
}
if(tr1.c[n_carriage].mesto[n_mesto]==true){ 
System.out.println("Это место уже занято"); 
}else{ 
tr1.c[n_carriage].mesto[n_mesto]=true; 
System.out.println("Чай: Да/Нет"); 
dt=0;
while(dt<1) {
Scanner sc_t=new Scanner(System.in); 
Tea=sc_t.next(); 
if ("Да".equals(Tea) || "Нет".equals(Tea) ) dt=1;
else if (!"Да".equals(Tea) && !"Нет".equals(Tea) )  
 System.out.println("При выборе чая надо ответить только Да или Нет"); 
}
System.out.println("Постель: Да/Нет"); 
dt=0;
while(dt<1) {
Scanner sc_b=new Scanner(System.in); 
Bed=sc_b.next();
if ("Да".equals(Bed) || "Нет".equals(Bed) ) dt=1;
else if (!"Да".equals(Bed) && !"Нет".equals(Bed) )  
 System.out.println("При выборе постели надо ответить только Да или Нет"); 
}
System.out.println("Студенческий: Да/Нет"); 
dt=0;
while(dt<1) {
Scanner sc_s=new Scanner(System.in); 
Student=sc_s.next();
if ("Да".equals(Student) || "Нет".equals(Student) ) dt=1;
else if (!"Да".equals(Student) && !"Нет".equals(Student) )  
 System.out.println("При выборе студенческого надо ответить только Да или Нет"); 
}
ticket t=new ticket(Student,Tea,Bed,tarif); 
result=t.price; 
System.out.println("_________________________________________________________");
System.out.println(" Проездной документ на поезд № "+tr1.train_number); 
System.out.println(" Сообщением "+tr1.train_name); 
System.out.println(" Дата отправления "+format.format(tr1.p_D_buy)+" "+tr1.p_Time); 
System.out.println(" Вагон "+n_carriage+" Тип вагона "+type_k+" Место "+n_mesto);
System.out.printf("\n %s %.2f %s","Тариф",  tarif,"грн.");
System.out.printf("\n %s %.2f %s %s %.2f %s","Чай ",t.tea,"грн.", "Постель ",t.bed,"грн.");
System.out.printf("\n %s %d %s","Студенческий  ",t.s_student,"% от тарифа");
} 
return result;

}


}