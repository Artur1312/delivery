package tickets;

public class Carriage {
String carriage_type;

int max_number;

boolean []mesto;
Carriage(String carriage_type){
this.carriage_type=carriage_type;
if(carriage_type=="P"){
max_number=54;
}else if(carriage_type=="K"){



max_number=36;



}
else if(carriage_type=="L"){


max_number=18;





}



mesto=new boolean[max_number+1];





}



}
