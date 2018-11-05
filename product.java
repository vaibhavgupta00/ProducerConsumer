import java.util.*;

class product{
static int v=0;
List<String> products = new ArrayList<>();
Scanner sc = new Scanner(System.in);

public void producer()throws Exception{
synchronized(this){
System.out.println("enter no.s");
for(int i=0;i<=9;i++){
products.add(sc.next());
}
v=1;
notify();
wait();
producer();
}
}

public void consumer()throws Exception{	
synchronized(this){
	if(v==1){
System.out.println("remove");
System.out.println(products+ " " + products.size());
products.clear();
notify();
wait();
consumer();
}
}
}

public void time()throws Exception{
Thread.sleep(3000);
System.exit(0);
}

public static void main(String h[]){

final product a= new product();
Thread t1= new Thread(new Runnable(){
            public void run(){
			try{
			a.producer();
			}catch(Exception e){}
			}
			});
			
Thread t2= new Thread(new Runnable(){
            public void run(){
			try{
			a.consumer();
			}catch(Exception e){}
			}
			});			
			
Thread t= new Thread(new Runnable(){
            public void run(){
			try{
			a.time();
			}catch(Exception e){}
			}
			});							
t.start();			
t2.start();
t1.start();

}
}			
			
