package tickets;

import java.io.BufferedReader;

import java.io.FileInputStream;

import java.io.IOException;

import java.io.InputStreamReader;

import java.text.ParseException;

import java.text.SimpleDateFormat;

import java.util.Date;

import java.util.Scanner;

public class Creator {

String file_name="D:\\ЭКОНОМИЧЕСКАЯ КИБЕРНЕТИКА\\программирование\\SP_train.txt";

int dt;

int train_number;

String train_name;

int pt;

int c1,c2,c3;

double tarif_p,tarif_k,tarif_l;

int kupe;

int N=5;

int M=9;

int i = -1;

String tr [][] = new String [N][M];

Date p_D_buy;

String p_Time;

Date cur_dt = new Date();

public void CR(){

try

{

FileInputStream fstream = new FileInputStream(file_name);

BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

String strLine;

while ((strLine = br.readLine()) != null){

i=i+1;

tr[i][0]=strLine.substring(0, 3).trim();
tr[i][1]=strLine.substring(4, 19).trim();
tr[i][2]=strLine.substring(20, 22).trim();

tr[i][3]=strLine.substring(23, 25).trim();

tr[i][4]=strLine.substring(26, 27).trim();

tr[i][5]=strLine.substring(28, 33).trim();

tr[i][6]=strLine.substring(34, 39).trim();

tr[i][7]=strLine.substring(40, 45).trim();

tr[i][8]=strLine.substring(46, 51).trim();

System.out.println(tr[i][0]+"/"+tr[i][1]+"/"+tr[i][2]+"/"+tr[i][3]+"/"+tr[i][4]+"/"+tr[i][5]+

"/"+tr[i][6]+"/"+tr[i][7]+"/"+tr[i][8]);

}

System.out.println("Задайте номер поезд");

dt=0;

while(dt<1) {

try {

Scanner sc = new Scanner(System.in);

train_number=sc.nextInt();

for (i=0; i<5; i++) {

if (Integer.parseInt(tr[i][0])==train_number) {

train_name=tr[i][1];

c1=Integer.parseInt(tr[i][2]);

c2=Integer.parseInt(tr[i][3]);

c3=Integer.parseInt(tr[i][4]);

tarif_p=Double.parseDouble(tr[i][5])/100;

tarif_k=Double.parseDouble(tr[i][6])/100;

tarif_l=Double.parseDouble(tr[i][7])/100;

p_Time=tr[i][8];

dt=1;

break;

}

}

if (dt==0) System.out.println("Поезда с таким номером нет. Введите существующий поезд");

}

catch (Exception e) {

System.out.println("Поезда с таким номером нет. Введите существующий поезд");

dt=0;

}

}

SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");

dt=0;

while(dt<1) {

System.out.println("Введите дату билета в формате dd.mm.yyyy");

Scanner sc_dat = new Scanner(System.in);

try {

p_D_buy=format.parse(sc_dat.next());

if (p_D_buy.before(cur_dt)) {

dt=0;

System.out.println("Дата билета не может быть меньше текущей. Введите дату повторно.");

}

else dt=1;

}

catch (ParseException ex) {

System.out.println("Дата введена не правильно. Введите дату повторно.");

dt=0;

}

}

}

catch(IOException ex){

System.out.println(ex.getMessage());

}

}

}


