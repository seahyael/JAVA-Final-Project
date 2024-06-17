package project;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class ShopCRUD {
    private ArrayList<Shop> shopList;

    public ShopCRUD() {
        shopList = new ArrayList<>();
    }

    void addShop() {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter name> ");
        String name = s.nextLine();

        System.out.print("Enter makers> ");
        String makers = s.nextLine();

        System.out.print("Enter price> ");
        double price = s.nextDouble();

        System.out.print("Enter num> ");
        int num = s.nextInt();

        Shop newShop = new Shop(name, makers, price, num);
        shopList.add(newShop);
        System.out.println("List added");
    }

    void editShop() {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter number of shopping list> ");
        int index = s.nextInt();
        s.nextLine();

        if (index <= 0 || index > shopList.size()) {
            System.out.println("Invalid index");
            return;
        }

        Shop shop = shopList.get(index - 1);

        System.out.print("Enter new name> ");
        String newName = s.nextLine();
        if (!newName.trim().isEmpty()) {
            shop.setName(newName);
        }

        System.out.print("Enter new makers> ");
        String newMakers = s.nextLine();
        if (!newMakers.trim().isEmpty()) {
            shop.setMakers(newMakers);
        }


        System.out.print("Enter new price> ");
        double newPrice = s.nextDouble();
        if (newPrice > 0) {
            shop.setPrice(newPrice);
        }

        System.out.print("Enter new number> ");
        int newNum = s.nextInt();
        if (newNum > 0) {
            shop.setNum(newNum);
        }

        System.out.println("Shopping list edited");
    }

    void listShop() {
        for (int i = 0; i < shopList.size(); i++) {
            System.out.printf("%d - %s\n", i + 1, shopList.get(i).toString());
        }
    }

    void deleteShop() {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter number of shop> ");
        int index = s.nextInt();

        if (index <= 0 || index > shopList.size()) {
            System.out.println("Invalid index");
            return;
        }

        Shop removedBook = shopList.remove(index - 1);
        System.out.println("Shopping list deleted: " + removedBook);
    }

    void saveShop() {
        // 채우기
        Scanner s = new Scanner(System.in);
        File file = new File("shoppinglist.txt");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


        try(FileWriter wr = new FileWriter(file);) {
            PrintWriter writer = new PrintWriter(wr);
            for(Shop shop : shopList) {
                writer.write(shop.toString() + "\n");
            }
            writer.close();
            System.out.println("Shopping list saved");
        } catch (IOException e) {
            System.out.println("Error!!");
            e.printStackTrace();
        }


    }
}