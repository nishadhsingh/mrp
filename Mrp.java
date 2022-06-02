/*
 * File:mrp.java
 * This program generates mrp for components of Bicycles
 * mrp = (amount required)/1 * amount of bicycles
 * 
 */

import java.util.*;
import java.math.*;
public class Mrp {
    
    /** static vars */

    public static ArrayList<Double> mrpValue = new ArrayList<Double>();     //mrp values
    public static ArrayList<Double> netOffValue = new ArrayList<Double>(); // netOff values
    public static ArrayList<String> itemList = new ArrayList<String>() ; // item List



    public static void main(String[] args){
        
        
        
        /** private instance variables */
        Item brake_paddle = new Item("Brake paddle",100,1,null);
        Item brake_cable = new Item("Brake cable",75,1,null);
        Item leaver = new Item("set of Leaver",60,1,null);
        Item brake_shoe = new Item("Brake Shoe",50,2,null);
        Item Seat = new Item("Seat",50,1,null);
        Item Frame = new Item("Frame",80,1,null);
        Item Brake_set = new Item("Break Set",25,2,new Item[]{brake_paddle,brake_cable,leaver,brake_shoe});
        Item Handle_bar = new Item("Handle bar",100,1,null);
        Item Wheel = new Item("Wheel",60,2,null);
        Item tires = new Item("Tires",80,2,null);
        Item Chain = new Item("Chain",100,1,null);
        Item Crankset = new Item("Crank set",50,1,null);
        Item Paddle = new Item("paddle",150,2,null);
        Item Bicycle = new Item("Bicycle",0,0,new Item[]{Seat,Frame,Brake_set,Handle_bar,Wheel,tires,Chain,Crankset,Paddle});


        /** main  prompt*/

        Scanner sc = new Scanner(System.in);
        /** Takes input and onlp allows integer greater than 0 */

        int amountRequired = 0;
        do {
            try {
                System.out.print("Enter the amount of Bicycles required: ");
                amountRequired = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("Invalid number of Bicycles required. \n");
            }
            sc.nextLine();
           } while (amountRequired <= 0);
        
        GenMrp(Bicycle,amountRequired);
        printMrp();
         
    
            


    }


    /** 
     * @Method GenMrp generates mrp and netOff values for each item recursively 
     * @Param item is the Item object to genrate mrp.
     * @Param amount is the of item to generate mrp.
     * GenMrp() genrates and prints mrp and netoff 
     * for the Item and amount of item required
     */
    public static void GenMrp(Item item,int amount){

        
        
        for(int i = 0;i<item.getchildComponentCount();i++){
            
            Item[] itemArray = item.getchildComponents();
            if (itemArray[i].getchildComponents() == null){
                
                double mrp = (itemArray[i].getitemRequired()/1)*amount;
                double netOff = -(mrp - itemArray[i].getamountOnHand());
                
                mrpValue.add(mrp);
                netOffValue.add(netOff);
                itemList.add(itemArray[i].getitemName());
            }
            else{

                double mrp = (itemArray[i].getitemRequired()/1)*amount;
                double netOff = Math.abs((mrp - itemArray[i].getamountOnHand()));
                
                mrpValue.add(mrp);
                netOffValue.add(netOff);
                itemList.add(itemArray[i].getitemName());
                GenMrp(itemArray[i],amount);
            
            }
        }
    }
    
    /**
     * @Method printMrp prints formatted mrp and netoff Values for each item
     */


    public static void printMrp(){
        Iterator mrpItr = mrpValue.iterator();
        Iterator netOffItr = netOffValue.iterator();
        Iterator itemListItr = itemList.iterator();
        /** print mrp values for each item */
        System.out.println("_________________________\n"
                          +"Item   "+"Mrp            \n"
                          
                          );
        while(mrpItr.hasNext()){
            System.out.println(itemListItr.next()+"  |  "+mrpItr.next());
        }
        /** print netOff values for each item */
        System.out.println("_________________________\n"
                          +"Item   "+"netOff          \n"
                          
                          );
        Iterator itemListItr2 = itemList.iterator();
        while(netOffItr.hasNext()){
            System.out.println(itemListItr2.next()+"  |  "+netOffItr.next());
        }
    }

	




}
