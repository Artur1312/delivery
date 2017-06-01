package tickets;

import java.util.Scanner;

public class Dispatcher extends Creator {

public static void main(String[] args) {

String Otv="";

int dt;

System.out.println("Ввод данных Y/N");

dt=0;

while(dt<1) {

Scanner sc1 = new Scanner(System.in);

Otv=sc1.next();

if ("Y".equals(Otv) || "N".equals(Otv) ) dt=1;

else if (!"Y".equals(Otv) && !"N".equals(Otv) )

System.out.println("Ответ должен быть только Y или N");

}

while(Otv.equals("Y")) {

Creator cr=new Creator();

cr.CR();

Train tr1=new Train(cr.train_number,cr.train_name,cr.c1,cr.c2,cr.c3,cr.tarif_p,

cr.tarif_k,cr.tarif_l,cr.p_D_buy,cr.p_Time);

Controller c=new Controller();

double result=c.ticket(tr1);

View v1=new View();

v1.WriteDouble(result);

System.out.println("\nХотите еще купить один билет на поезд Y/N");

dt=0;

while(dt<1) {

Scanner sc11 = new Scanner(System.in);

Otv=sc11.next();

if ("Y".equals(Otv) || "N".equals(Otv) ) dt=1;

else if (!"Y".equals(Otv) && !"N".equals(Otv) )

System.out.println("Ответ должен быть только Y или N");

}

}

System.out.println("Работа программы завершена");

}

}
