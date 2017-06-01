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
System.out.println("������ ����� ����� � "+tr1.train_number+" ���������� "+tr1.train_name
  +" ���� ����������� "+format.format(tr1.p_D_buy)); 
System.out.println("������: �������� � 1 �� "+ (tr1.c1)
  +", ���� � "+(tr1.c1+1)+" �� "+c_k
  +", �� � "+(c_k+1)+" �� "+c_sv); 
dt=0;
k="";
System.out.println("�������� ����� ������"); 
while(dt<1) {
try {
Scanner sc_c=new Scanner(System.in); 
n_carriage=sc_c.nextInt(); 
if (n_carriage>0 && n_carriage<=tr1.c1) {
 k="P";
 type_k="��������";
 tarif=tr1.tarif_p; 
}
else if (n_carriage>tr1.c1 && n_carriage<=c_k) {
 k="K";
 type_k="����";
 tarif=tr1.tarif_k; 
}
else if (n_carriage>c_k && n_carriage<=c_sv) {
 k="L";
 type_k="��";
 tarif=tr1.tarif_l; 
}
if (k=="") System.out.println("�������� ����� ������ ����������� � ������. ��������� ����");
else dt=1;
}
catch (Exception e) {
        System.out.println("������� �� �����. ��������� ����");
        dt=0;
    }
}
System.out.println("������ ��� ������ "+type_k);
Carriage c1=new Carriage(k); 
System.out.println("������������ ���������� ���� � ������ "+tr1.c[n_carriage].max_number); 
System.out.println("�������� �����"); 
dt=0;
while(dt<1) {
try {
 Scanner sc_m=new Scanner(System.in); 
n_mesto=sc_m.nextInt(); 
if (n_mesto<=0 || n_mesto>tr1.c[n_carriage].max_number) System.out.println("������ ����� � ������ ���. ��������� ����");
else dt=1;
}
catch (Exception e) {
        System.out.println("������� �� �����. ��������� ����");
        dt=0;
    }
}
if(tr1.c[n_carriage].mesto[n_mesto]==true){ 
System.out.println("��� ����� ��� ������"); 
}else{ 
tr1.c[n_carriage].mesto[n_mesto]=true; 
System.out.println("���: ��/���"); 
dt=0;
while(dt<1) {
Scanner sc_t=new Scanner(System.in); 
Tea=sc_t.next(); 
if ("��".equals(Tea) || "���".equals(Tea) ) dt=1;
else if (!"��".equals(Tea) && !"���".equals(Tea) )  
 System.out.println("��� ������ ��� ���� �������� ������ �� ��� ���"); 
}
System.out.println("�������: ��/���"); 
dt=0;
while(dt<1) {
Scanner sc_b=new Scanner(System.in); 
Bed=sc_b.next();
if ("��".equals(Bed) || "���".equals(Bed) ) dt=1;
else if (!"��".equals(Bed) && !"���".equals(Bed) )  
 System.out.println("��� ������ ������� ���� �������� ������ �� ��� ���"); 
}
System.out.println("������������: ��/���"); 
dt=0;
while(dt<1) {
Scanner sc_s=new Scanner(System.in); 
Student=sc_s.next();
if ("��".equals(Student) || "���".equals(Student) ) dt=1;
else if (!"��".equals(Student) && !"���".equals(Student) )  
 System.out.println("��� ������ ������������� ���� �������� ������ �� ��� ���"); 
}
ticket t=new ticket(Student,Tea,Bed,tarif); 
result=t.price; 
System.out.println("_________________________________________________________");
System.out.println(" ��������� �������� �� ����� � "+tr1.train_number); 
System.out.println(" ���������� "+tr1.train_name); 
System.out.println(" ���� ����������� "+format.format(tr1.p_D_buy)+" "+tr1.p_Time); 
System.out.println(" ����� "+n_carriage+" ��� ������ "+type_k+" ����� "+n_mesto);
System.out.printf("\n %s %.2f %s","�����",  tarif,"���.");
System.out.printf("\n %s %.2f %s %s %.2f %s","��� ",t.tea,"���.", "������� ",t.bed,"���.");
System.out.printf("\n %s %d %s","������������  ",t.s_student,"% �� ������");
} 
return result;

}


}