/*
* @author: Bianca Catalunha
* Student number: 2014305
* CA2 - Write a Java program to model a Video Kiosk
* April - 2016
*/
import java.util.*;

public class VKiosk{
	
	public static void main(String[] args)
	{			
		Scanner s = new Scanner(System.in);
		List<Video> lv = new ArrayList<Video>();
		int addmore=1;
		
		//ADD TITLES
		Video v1 = new Video ("Gone With the Wind", 1, 9.10);
		lv.add(v1);
		
		v1 = new Video ("Mouling Rouge", 2, 5.60);
		lv.add(v1);
		
		v1 = new Video ("The Notebook", 3, 7.50);
		lv.add(v1);
		
		v1 = new Video ("Monsters University", 4, 5.00);
		lv.add(v1);
		
		v1 = new Video ("Star Wars", 5, 8.00);
		lv.add(v1);
		//END ADD TITLES
		
		//CREATES TWO LINKED LISTS
		List<Video> titles = new LinkedList<Video>(lv);
        List<Video> basket = new LinkedList<Video>();
        
        Iterator<Video> vit;
        
        //MENU
		System.out.println("\n\n"+"Welcome to the Video Kiosk");
		System.out.println("***** Titles Menu *****");
		System.out.println("Serial | Cost | Title ");
		for (Video v : lv)
		{ 		 	
  		   System.out.println(v.getSerial() + "      | " + v.getCost()+ "  | " +v.getTitle());
        }
        //END MENU
        
		do{
       		System.out.println("\n"+ "Please type the serial of the title you would like to rent and press enter." +"\n");
			
			try{
				int ChosenV =Integer.parseInt(s.nextLine());//stores selection
				boolean valid= false;//checks if the input is valid
			
				vit = titles.iterator();//titles iterator
				while(vit.hasNext())
				{
					Video vi = vit.next();
			
					if((vi.getSerial()) == ChosenV)//if the serial chosen matches the linked list of titles
					{
						valid = basket.add(vi);//add title to the basket and sets that the user input is valid
						vit.remove();//delete title from title list
						System.out.println("You have added " +vi.getTitle() + " to your basket");
					}
				}
				
				if(!valid){//if serial number was not found in the titles linked list
					System.out.println("*Error* The title was already added to your basket or the serial numer is invalid.");
				}
				else{// serial number is valid
					boolean opt= true;
					
					while(opt){//while option input is not acceptable 
						try{
							System.out.println("\nEnter 1 to add a title or 0 to go to checkout");
							addmore = Integer.parseInt(s.nextLine());//stores selection
							
							if(addmore == 1 || addmore == 0){//if option is 1 or 0, stops loop
								opt=false;
							}
							else{
								System.out.println("*Error* Please enter a valid option");
							}
							
						}catch(NumberFormatException e){
							opt= true;
							System.out.println("*Error* Please enter a valid option");
						}
					}
				}
			}catch(NumberFormatException e){
				System.out.println("*Error* Please enter a valid serial number");
			}	
		}while(addmore == 1);
		
		//CHECKOUT
		if(addmore == 0)//if user chose 0
		{
			double total=0;
				
			vit = basket.iterator(); 
			while(vit.hasNext())
			{
				Video vi = vit.next();
				total=total + vi.getCost();	//sums cost of all titles
			}	
			
			//SHOWS BASKET
			System.out.println("Your Basket: ");
			vit = basket.iterator(); 
			while(vit.hasNext())
			{
				Video vi = vit.next();
				System.out.println(vi);
			}
			System.out.println("Total: "+ total +"\n");
			//END BASKET
				
			Machine checkout = new Machine();//creates an instance of machine
			checkout.Machine(total);//calls method and pass total
		}				
	}
}