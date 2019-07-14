package com.mars.explorer.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.mars.explorer.data.MarsExplorerData;
import com.mars.explorer.util.MarsExplorerUtil;

public class MarsExplorerMain {

	public static void main(String[] args) throws IllegalArgumentException, IOException {
		// TODO Auto-generated method stub
		
		MarsExplorerUtil.place(0, 0);
		MarsExplorerUtil.block(0, 2);
		MarsExplorerUtil.explorer(0,3);
		
		MarsExplorerUtil.report();
		System.out.println("please select a option and enter:");
		System.out.println("1. PLACE");
		System.out.println("2. BLOCK");
		System.out.println("3. EXPLORER");
		System.out.println("4. REPORT");
		//Enter data using BufferReader 
        BufferedReader reader =  
                   new BufferedReader(new InputStreamReader(System.in)); 
        
  
         
		switch(Integer.parseInt(reader.readLine().trim())) {
        case 1 :
           
        case 2 :
           
           
        case 3 :
           
        case 4 :
           
           
        default :
           System.out.println("Invalid option selected");
     }
	}

}
