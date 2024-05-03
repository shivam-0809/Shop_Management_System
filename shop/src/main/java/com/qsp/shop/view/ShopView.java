package com.qsp.shop.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.sound.midi.SysexMessage;

import com.qsp.shop.controller.ShopController;
import com.qsp.shop.model.Product;

public class ShopView {
	static Scanner myInput = new Scanner(System.in);
	static Product product = new Product();
	static ShopController shopController = new ShopController();


	public static void main(String[] args) throws SQLException {
		do {
			System.out.println("Select operation to perfrom: ");
			System.out.println("1.Add product\n2.Remove product\n3.Update product details\n4.Fetch product\n0.Exit \n"
					+ "-----------------------------------------------------------------------------------------------------------------");
			System.out.print("Enter digit respective to desired option: ");
			int userInput=myInput.nextInt();
			myInput.nextLine();
			switch (userInput) {
			case 0:
				myInput.close();
				System.out.println("*******************************************EXITED*****************************************************");
				System.exit(0);
				
				break;
            case 1:
            	System.out.print("How many products do you want to add ?\n1.Single Product: \n2.Multiple Product: ");
            	int productsCount=myInput.nextInt();
            	myInput.nextLine();
            	if(productsCount==1) {
	            	System.out.print("Enter product id: ");
	            	int i_p_d=myInput.nextInt(); // i_p_id--- input p id
	            	myInput.nextLine();
	            	System.out.print("Enter product name: ");
	            	String i_p_name=myInput.nextLine();
	            	System.out.print("Enter price: ");
	            	int i_p_price=myInput.nextInt(); 
	            	myInput.nextLine();
	            	System.out.print("Enter quantity: ");
	            	int i_p_quantity=myInput.nextInt(); 
	            	myInput.nextLine();
	            	boolean i_p_availability=false;
	            	if (i_p_quantity>0) {
	            		i_p_availability=true;
						
					} 
	            	if ((shopController.addProduct(i_p_d, i_p_name, i_p_price, i_p_quantity, i_p_availability))!=0) {
						System.out.println("--------------------------------------PRODUCT ADDED TO SHOP-------------------------------");
					}else {
						System.out.println("------------------------------------PRODUCT NOT ADDED-----------------------------------------------");
					}
            	}
            	else if(productsCount==2) {
            		Boolean toContinue=true;
            		ArrayList<Product> products = new ArrayList<Product>();
            		do {
						Product product = new Product();
						System.out.print("Enter product id: ");
		            	product.setP_id(myInput.nextInt());
		            	myInput.nextLine();
		            	System.out.print("Enter product name: ");
		            	product.setP_name(myInput.nextLine());
		            	System.out.print("Enter price: ");
		            	product.setP_price(myInput.nextInt());
		            	myInput.nextLine();
		            	System.out.print("Enter quanity: ");
		            	int quantity =myInput.nextInt();
		            	product.setP_qauntity(quantity);
		            	myInput.nextLine();
		            	boolean i_p_availability=false;
		            	if (quantity>0) {
		            		i_p_availability=true;
							
						} 
		            	product.setP_availability(i_p_availability);
		            	products.add(product);
		            	System.out.print("------press 1 to continue adding products-----,---press 0 to stoop adding products---: ");
		            	int toAdd=myInput.nextInt();
		            	System.out.println("---------------------------------------------------------------------------------------------");
		            	if (toAdd==0) {
							toContinue=false;
			            	System.out.println("************************************ WELCOME VISIT AGAIN************************************** ");

						}
					} while (toContinue);
            		shopController.addMultipleProducts(products);
            	
            	}
				break;
            case 2:
//            	-----------------HANDLE PRODUCT HANDLE--------------------------------
            	System.out.print("Enter product id to remove: ");
            	int productIdtoRemove = myInput.nextInt();
            	myInput.nextLine();
            	
            	if (shopController.removeProduct(productIdtoRemove)!=0) {
					System.out.println("----------------SUCCESSFULLY REMOVE--------------------");
				} else {
					System.out.println("-----Product with given id does not exists, no remove operation perform-----");

				}
            	System.out.println();
            	
	
	            break;
            case 3:
//				-------------------HANDLE PRODUCT DETAILS UPDATE---------------------
            	System.out.print("Enter product id to update:");
            	int productIdtoUpdate = myInput.nextInt();
            	myInput.nextLine();
            	ResultSet Product = shopController.fetchProduct(productIdtoUpdate);
            	if (Product.next()) {
            		System.out.println("What do u want to update ?");
            		System.out.println("1.Name\n2.Price\n3.Quantity");
            		System.out.print("Enter number respective to desired option: ");
            		byte updateOption = myInput.nextByte();
            		myInput.nextLine();
            		switch (updateOption) {
					case 1:
						System.out.print("Enter name to update: ");
						String nametoUpdate = myInput.nextLine();
						if (shopController.updateProductName(productIdtoUpdate, nametoUpdate)!=0) {
							System.out.println("---------------------RECORD UPDATED---------------------------");
							
						} else {
							System.out.println("----------------------RECORD NOT UPDATED-------------------------");

						}
						break;
//                    case 2:
//						
//						break;
//                    case 3:
//						
//						break;

					default:
						System.out.println("-------------------------INVALID SELECTION------------------------------");
						break;
					}
            		
				} else {
					System.out.println("Product with given id does not exists,Update operation can not be perfromed");

				}
				break;
            case 4:
//           ---------------handle product id to fetch---------------------
            	System.out.print("Enter product id to fetch: ");
            	int productIdtofind=myInput.nextInt();
            	myInput.nextLine();
            	ResultSet fetchProduct = shopController.fetchProduct(productIdtofind);
            	 boolean next=fetchProduct.next();
            	if (next) {
            		System.out.println(" PRODUCT DETAILS ");
            		System.out.println("Id: "+ fetchProduct.getInt(1));
            		System.out.println("Name: "+fetchProduct.getString(2));
            		System.out.println("Price: "+fetchProduct.getInt(3));
            		System.out.println("Quantity: "+fetchProduct.getInt(4));
            		if (fetchProduct.getBoolean(5)) {
            			System.out.println("Availability: Availability");
						
					} else {
						System.out.println("Availbility: Available");

					}
					
				} else {
					System.out.println("Product with id: " +productIdtofind+ " Does not exists ");

				}
            	
				
				break;

			default:
				System.out.println("--------------------------INVALID SECTION----------------------------");
				break;
			}
			
		} while (true);
	}

}
