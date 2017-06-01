package tickets;

import java.util.Date;
public class Train {
String train_name;
int train_number;
Carriage []c;
Date p_D_buy;
int c1;
int c2;
int c3;
double tarif_p;
double tarif_k;
double tarif_l;
String p_Time;

public Train(int train_number,String train_name,int c1,int c2,int c3,
double tarif_p,double tarif_k,double tarif_l,Date p_D_buy,String p_Time){
this.train_number=train_number;
this.train_name=train_name;
this.c1=c1;
this.c2=c2;
this.c3=c3;
this.tarif_p=tarif_p;
this.tarif_k=tarif_k;
this.tarif_l=tarif_l;
this.p_D_buy=p_D_buy;
this.p_Time=p_Time;
c=new Carriage [c1+c2+c3+1];
for(int i=1;i<c1+1;i++){
c[i]=new Carriage("P");



}


for(int i=c1+1;i<c1+c2+1;i++){
c[i]=new Carriage("K");
}
for(int i=c1+c2+1;i<c1+c2+c3+1;i++){
c[i]=new Carriage("L");

}



}



}