import java.util.*;

public class Main {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        //Products list
        String[][] products = {{"1", "chips", "2"},
                                {"2", "beer", "3"},
                                {"3", "grill", "50"}};
        //Users list
        String[][] users = {{"1", "Tom", "Adler", "120"},
                            {"2", "Jef", "Cliff", "15"},
                            {"3", "John", "Rider", "30"}};
        //List of user products by user id
        String[][] productsByUserId = {{"User Id = 1 ", ""},
                                        {"User Id = 2 ", ""},
                                        {"User Id = 3 ", ""}};
        //List of users that bought product by product id
        String[][] usersByProductId = {{"Product Id = 1 ", ""},
                                        {"Product Id = 2 ", ""},
                                        {"Product Id = 3 ", ""}};

        //boolean variable for while loop
        boolean loop = true;
        while(loop)
        {
            //Main operations
            System.out.println();
            System.out.print("1. Display list of all users\n" +
                    "2. Display list of all products\n" +
                    "3. User buying product\n" +
                    "4. Display list of user products by user id\n" +
                    "5. Display list of users that bought product by product id\n" +
                    "6. Exit\n\n" +
                    "Choose option:");
            int choose = scanner.nextInt();

            switch(choose){
                case 1:
                    for(int i = 0; i < 3; i ++)
                    {
                        for(int j = 0; j < 3; j ++)
                        {
                            System.out.print(" " + products[i][j]);
                        }
                        System.out.println("$");
                    }
                    break;
                case 2:
                    for(int i = 0; i < 3; i ++)
                    {
                        for(int j = 0; j < 4; j ++)
                        {
                            System.out.print(" " + users[i][j]);
                        }
                        System.out.println("$");
                    }
                    break;
                case 3:
                    int idUser, idProduct;
                    while(true) {
                        //list have only 3 users
                        System.out.print("Choose Id of of user(1<=Id<=3):");
                        idUser = scanner.nextInt();
                        if(idUser<=3 && idUser>=1)
                        {break;}
                    }
                    while(true) {
                        //list have only 3 products
                        System.out.print("Choose Id of of product(1<=Id<=3):");
                        idProduct = scanner.nextInt();
                        if(idProduct<=3 && idProduct>=1)
                        {break;}
                    }
                    //If user doesn't have enough money to buy product, throw exception
                    if(Integer.parseInt(users[idUser-1][3])<Integer.parseInt(products[idProduct-1][2]))
                    {throw new RuntimeException();}
                    else
                    {
                        //If user successfully bought the product display message about successful purchase
                        System.out.println("User successfully bought the product");

                        //When user is buying product, his amount of money decreases by product price
                        int newValue = Integer.parseInt(users[idUser-1][3]) - Integer.parseInt(products[idProduct-1][2]);
                        users[idUser-1][3] = String.valueOf(newValue);

                        //After successful purchase, information about user and his products has to be stored in collection
                        productsByUserId[idUser-1][1] += products[idProduct-1][1] + " ";
                        if(!(usersByProductId[idProduct-1][1].contains(users[idUser-1][1])))
                            usersByProductId[idProduct-1][1] += users[idUser-1][1] + " ";
                    }
                    break;
                case 4:
                    for(int i = 0; i < 3; i ++)
                    {
                        if(productsByUserId[i][1].equals(""))
                            continue;
                        for(int j = 0; j < 2; j ++)
                        {
                            System.out.print(" " + productsByUserId[i][j]);
                        }
                        System.out.println();
                    }
                    break;
                case 5:
                    for(int i = 0; i < 3; i ++)
                    {
                        if(usersByProductId[i][1].equals(""))
                            continue;
                        for(int j = 0; j < 2; j ++)
                        {
                            System.out.print(" " + usersByProductId[i][j]);
                        }
                        System.out.println();
                    }
                    break;
                case 6:
                    loop = false;
            }
        }
    }
}
