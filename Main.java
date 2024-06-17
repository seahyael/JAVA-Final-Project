package project;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main Pstudio = new Main();
        Pstudio.run();
    }

    public void run() {
        int menu, quit = 0;
        Scanner s = new Scanner(System.in);
        ShopCRUD manager = new ShopCRUD();
        while (true) {
            System.out.println("Menu> 1.Add 2.Edit 3.List 4.Delete 5.Save 0.Exit");
            menu = s.nextInt();
            switch (menu) {
                case 1: manager.addShop(); break;
                case 2: manager.editShop(); break;
                case 3: manager.listShop(); break;
                case 4: manager.deleteShop(); break;
                case 5: manager.saveShop(); break;
                default: quit = 1;
            }
            if (quit == 1) break;
        }
        s.close();
    }
}
