/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functions;

import entity.*;
import java.util.ArrayList;
import checkinput.CheckInput;
import java.io.IOException;
import java.util.Hashtable;

/**
 *
 * @author Admin
 */
public class Functions {

    CheckInput checkInput = new CheckInput();

    public int findByID(ArrayList<Fruit> list, String ID) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getID().equals(ID)) {
                return i;
            }
        }
        return -1;
    }

    public String NotDupID(ArrayList<Fruit> list) {
        String ID = "";
        do {
            ID = checkInput.inputNotEmptyString();
            if (findByID(list, ID) != -1) {
                System.out.print("Duplicated ID. Re-enter: ");
            } else {
                break;
            }
        } while (true);
        return ID;
    }

    Fruit createFruitWithID(String ID) {
        System.out.println("Input Fruit Name: ");
        String name = checkInput.inputName();
        System.out.println("Input Price: ");
        double price = checkInput.inputPositiveDouble();
        System.out.println("Input Quantity: ");
        int quantity = checkInput.inputPositiveInt();
        System.out.println("Input Origin: ");
        String origin = checkInput.inputName();
        return new Fruit(ID, name, price, quantity, origin);
    }

    public void addFruit(ArrayList<Fruit> list) {
        String yn;
        do {
            System.out.println("Input Fruit ID: ");
            String ID = NotDupID(list);
            list.add(createFruitWithID(ID));
            System.out.println("Do you want to continue?Y/N");
            yn = checkInput.inputYN();
        } while (yn.equalsIgnoreCase("Y"));
        list.forEach(k -> System.out.println(k));
    }

    public void displayListFruit(ArrayList<Fruit> list) {
        System.out.println("List Fruit:");
        System.out.printf("%-15s%-20s%-20s%-20s\n",
                "| ++ Item ++ ",
                "| ++ Fruit Name ++",
                "| ++ Origin ++ ",
                "| ++ Price ++ |");
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%-15d%-20s%-20s%-20s\n", i + 1, list.get(i).getName(), list.get(i).getOrigin(), list.get(i).getPrice());
        }
    }

    public void viewOrders(Hashtable<String, ArrayList<Order>> ht) {
        if (!ht.isEmpty()) {
            ht.forEach((k, v) -> {
                int total = 0;
                System.out.println("Customer name: " + k);
                System.out.printf("%-20s%-20s%-20s%-20s\n", "Product", "Quantity", "Price", "Amount");
                ArrayList<Order> list = ht.get(k);
                for (Order order : list) {
                    System.out.println(order);
                    total += order.getAmount();
                }
                System.out.println("Total: " + total + "$");
            });

        } else {
            System.out.println("No order!");
        }
    }

    boolean isStock(ArrayList<Fruit> listFr) {
        for (Fruit fruit : listFr) {
            if (fruit.getQuantity() > 0) {
                return true;
            }
        }
        return false;
    }

    public void shopping(Hashtable<String, ArrayList<Order>> ht, ArrayList<Fruit> listFr) throws IOException {
        if (isStock(listFr)) {
            String yn = "";
            ArrayList<Order> listOrd = new ArrayList<>();
            do {
                displayListFruit(listFr);
                int choice = new main.MainMenu().getChoice(1, listFr.size());
                Fruit selectedF = listFr.get(choice - 1);
                System.out.println("You selected: " + selectedF.getName());
                if (selectedF.getQuantity() > 0) {
                    System.out.println("Input quantity to buy: ");
                    int xQuan = checkInput.inputPositiveInt();
                    if (xQuan > selectedF.getQuantity()) {
                        System.out.println("Sorry! We only have " + selectedF.getQuantity() + ". Do you want to order another fruit? Y/N");
                        yn = checkInput.inputYN();
                        if (yn.equalsIgnoreCase("y")) {
                            continue;
                        } else {
                            break;
                        }
                    } else {
                        double total = 0;
                        listFr.get(choice - 1).setQuantity(listFr.get(choice - 1).getQuantity() - xQuan);
                        Order ord = new Order(selectedF.getID(), selectedF.getName(), xQuan, selectedF.getPrice());
                        listOrd.add(ord);
                        System.out.println("Do you want to order now?");
                        yn = checkInput.inputYN();
                        if (yn.equalsIgnoreCase("y")) {
                            System.out.printf("%-20s%-20s%-20s%-20s\n", "Product", "Quantity", "Price", "Amount");
                            for (Order order : listOrd) {
                                System.out.println(order);
                                total += order.getAmount();
                            }
                            System.out.println("Total: " + total + "$");
                            System.out.println("Input your name: ");
                            String cusName = checkInput.inputName();
                            if (ht.containsKey(cusName)) {
                                ArrayList<Order> listOldOrder = ht.get(cusName);
                                for (Order order : listOrd) {
                                    listOldOrder.add(order);
                                }
                                ht.put(cusName, listOldOrder);
                            } else {
                                ht.put(cusName, listOrd);
                            }
                            break;
                        } else {
                            continue;
                        }
                    }
                } else {
                    System.out.println("Sorry! It's out of stock. Do you want to order another fruit? Y/N");
                    yn = checkInput.inputYN();
                    if (yn.equalsIgnoreCase("y")) {
                        continue;
                    } else {
                        break;
                    }
                }
            } while (true);

        } else {
            System.out.println("Sold out. Please come back next time!");
            return;
        }
    }
}
