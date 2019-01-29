
package com.company;

import businessLayer.Cable.CableDecorator;
import businessLayer.Cable.DefaultCable;
import businessLayer.Cable.GoldenCable;
import businessLayer.Cable.SilverCable;
import businessLayer.Factory.Computer;
import businessLayer.Factory.GamingComputer;
import businessLayer.Factory.RegularComputer;

public class ComputerComparisonApp {
    public static void main(String[] args) {
    	CableDecorator decorator;
    	Computer regularComputer= new RegularComputer();
    	Computer gamingComputer = new GamingComputer();
    	
    	System.out.println("********************************* REGULAR COMPUTER *********************************");
    	System.out.println(regularComputer.toString());
    	decorator= new DefaultCable(regularComputer);
    	System.out.println("\nComputer prices with ");
    	System.out.println("Default cable "+regularComputer.getTotalPrice());
    	decorator= new GoldenCable(regularComputer);
    	System.out.println("Golden cable "+regularComputer.getTotalPrice());
    	decorator= new SilverCable(regularComputer);
    	System.out.println("Silver cable "+regularComputer.getTotalPrice());
    	
    	System.out.println();
    	
    	System.out.println("********************************* GAMING COMPUTER *********************************");
    	System.out.println(gamingComputer.toString());
    	decorator= new DefaultCable(gamingComputer);
    	System.out.println("\nComputer prices with ");
    	System.out.println("Default cable "+gamingComputer.getTotalPrice());
    	decorator= new GoldenCable(gamingComputer);
    	System.out.println("Golden cable "+gamingComputer.getTotalPrice());
    	decorator= new SilverCable(gamingComputer);
    	System.out.println("Silver cable "+gamingComputer.getTotalPrice());
    	
    }
}