

//Opgave 1 - Student klasse
/*
class Student {
    private String name;
    private int age;
    private String id;

    public Student(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public String toString() {
        return name + " : " + age;
    }

    public int getAge() {
        return age;
    }

    public void printInfo() {
        System.out.println("Students name: " + name);
        System.out.println("Students age: " + age + " years old");
    }

    public static Student findStudentFromId(String target, Student[] students) {
        for (Student student : students) {
            if (student.id.equals(target)) {
                System.out.println("Found student with ID:" + target + ": " + student);
                return student;
            }
        }
        return null;
    }
}

    public class Main {
        static void main() {
            Student s1 = new Student("Max", 20, "CTE");
            Student s2 = new Student("Phillip", 28, "213");
            Student s3 = new Student("Lucas", 21, "BDA");

            Student[] students = new Student[3];
            students[0] = s1;
            students[1] = s2;
            students[2] = s3;

            System.out.println("Print all Students:");
            for (Student student : students) {
                student.printInfo();
                System.out.println();
            }

            System.out.println();
            int oldestStudent = 0;
            for (int i = 0; i < students.length; i++) {
                if (students[i].getAge() > students[oldestStudent].getAge()) {
                    oldestStudent = i;
                }
            }
            System.out.println("Oldest student is: " + students[oldestStudent]);

            Student.findStudentFromId("BDA", students);
        }
    }*/



/*
import java.util.Arrays;

//Opgave 2 - product klasse
class Product{
    private String name;
    private double price;
    private String[] tags;


    public Product(String name, double price, String[] tags){
        this.name = name;
        this.price = price;
        this.tags = tags;

    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String[] getTags() {
        return tags;
    }

    public String toString(){
        return name + " : " + price + "kr - tags: " + Arrays.toString(tags);
    }

public void printInfo(){
    System.out.println("=== Product info ===");
    System.out.println("Product: " + name);
    System.out.println("Price: " + price);
    System.out.print("Tags: ");
    for (String tag : tags) {
        System.out.print(tag + " ");
    }
    }

    public boolean hasTag(String tag){
        for (String t : tags){
if (t.equals(tag)){
    return true;
}
        }
        return false;
    }

    public static void findRange(Product[] products, int min, int max){
        System.out.println("List of products with price between " + min + " - " + max );
        for (Product product : products){
        if (product.getPrice() >= min && product.getPrice() <= max){
            System.out.println(product);
        }
        }
    }

}


public class Main {
    static void main() {
        System.out.println();
        Product p1 = new Product("Banana", 2.5, new String[]{"organic", "sale"});
        Product p2 = new Product("Sword", 50, new String[]{"dangerous", "sharp"});
Product p3 = new Product("Beer", 5, new String[]{"adult", "sale"});
Product p4 = new Product("Soda", 20, new String[]{"sale"});

Product[] products = new Product[4];
products[0] = p1;
products[1] = p2;
products[2] = p3;
products[3] = p4;


        System.out.println("=== All items on sale ===");
for (Product product : products){
    if (product.hasTag("sale")){
        System.out.println(product);
    }
}
        System.out.println();
        System.out.println("=== Most expensive item ===");
int expensiveIndex = 0;
for (int i = 0 ; i < products.length ; i++){
    if (products[i].getPrice() > products[expensiveIndex].getPrice()){
        expensiveIndex = i;
    }
}
        System.out.println("Most expensive product: " + products[expensiveIndex]);
        System.out.println();
Product.findRange(products, 4, 50);
    }
}*/


//Opgave 3-BankAccount med arraylist

/*
import java.util.ArrayList;

class Transaction{
    private String type;
    private double amount;



    public Transaction(String type, double amount){
        this.type = type;
        this.amount = amount;
    }


    public String toString(){
        return type + " amount: " + amount + "kr";
    }

    public double getAmount() {
        return amount;
    }
}



class BankAccount{

    private String owner;
    private double balance;
    private ArrayList<Transaction> transactions;


    public BankAccount(String owner, double startBalance){
        this.owner = owner;
        this.balance = startBalance;
        this.transactions = new ArrayList<>();
    }


    public void deposit(double amount){
        if(amount > 0){
            balance += amount;
            System.out.println("Deposited: " + amount);
            transactions.add(new Transaction("deposit", amount));
        }else{
            System.out.println("Invalid, input amount above 0");
        }
    }

    public void withdraw(double amount){
        if (amount > 0){
            if (balance >= amount){
                balance -= amount;
                System.out.println("Withdrew: " + amount);
                transactions.add(new Transaction("withdrawel", amount));
            }else {
                System.out.println("Invalid, not enough money for this withdrawel in account");
            }
        }else{
            System.out.println("Invalid, input amount above 0");
        }
    }

    public void printTransactionHistory(){
        System.out.println();
        System.out.println("=== Transaction history ===");
        for (Transaction transaction : transactions){
            System.out.println(transaction);
        }
    }

    public double getBalance(){
        return balance;
    }

    public Transaction getLargestTransaction(){
        int largestIndex = 0;
        System.out.println("=== Largest transaction ===");
        for (int i = 0 ; i< transactions.size() ; i++){
            if (transactions.get(largestIndex).getAmount() < transactions.get(i).getAmount()){
                largestIndex = i;
            }
        }
        return transactions.get(largestIndex);
    }
}

public class Main {
    static void main() {

        BankAccount myAccount = new BankAccount("Max", 1500);
        myAccount.deposit(500);
        myAccount.withdraw(1500);
        myAccount.deposit(750);
        myAccount.printTransactionHistory();
        System.out.println();
        System.out.println("My balance: " + myAccount.getBalance());

        System.out.println();
        System.out.println(myAccount.getLargestTransaction());
    }
}*/


//Opgave 4 - Team Management System
/*
import java.util.ArrayList;

class Player{
    private String name;
    private int skillLevel;

    Player(String name, int skillLevel){
        this.name = name;
        this.skillLevel = skillLevel;

        int maxSkillLevel = 100;
        if (skillLevel > maxSkillLevel){
            this.skillLevel = maxSkillLevel;
        }
        int minSkillLevel = 1;
        if (skillLevel < minSkillLevel){
            this.skillLevel = minSkillLevel;
        }
    }

    public int getSkillLevel() {
        return skillLevel;
    }

    public String toString(){
        return name + " : skillLvl: " + skillLevel;
    }

}

class Team{
    private String teamname;
    private ArrayList<Player> players;

    Team(String teamname){
        this.teamname = teamname;
        this.players = new ArrayList<>();
    }

    public String getTeamname() {
        return teamname;
    }

    public void addPlayer(Player p){
        players.add(p);
    }

    public double getAverageSkill(){
        double sum = 0;
        for (Player p : players){
            sum += p.getSkillLevel();
        }
        return (sum / (players.size()));
    }


    public void printTeam(){
        System.out.println("=== " + teamname + " ===");
       for (int i = 0 ; i < players.size() ; i++){
           System.out.println(i + ": " + players.get(i));
       }
        System.out.println("Average skillLevel: " + getAverageSkill());
    }

    public void compete(Team opponent){
        System.out.println(teamname + " vs " + opponent.teamname);
        if (getAverageSkill() > opponent.getAverageSkill()){
            System.out.println(teamname + " wins! avg skill: " + getAverageSkill());
        }else if (getAverageSkill() == opponent.getAverageSkill()){
            System.out.println("The teams are even, its a tie");
        }else{
            System.out.println(opponent.teamname + " wins! avg skill: " + opponent.getAverageSkill());
        }
    }

    public Player findBestPlayer(){
        int bestIndex = 0;
        for (int i = 0 ; i< players.size() ; i++){
            if (players.get(bestIndex).getSkillLevel() < players.get(i).getSkillLevel()){
                bestIndex = i;
            }
        }
        return players.get(bestIndex);
    }
}

public class Main {
    static void main() {
Team t1 = new Team("My team");
Team t2 = new Team("Evil team...");

t1.addPlayer(new Player("Max", 65));
t1.addPlayer(new Player("Oscar", 75));
t1.addPlayer(new Player("Johny", 32));

t2.addPlayer(new Player("Peter", 15));
        t2.addPlayer(new Player("Johannes", 95));
        t2.addPlayer(new Player("Laura", 75));
        t2.addPlayer(new Player("Viktor", 25));


        t1.printTeam();
        System.out.println();
        t2.printTeam();
        System.out.println();
        t1.compete(t2);

        System.out.println();
        System.out.println("===Best player in " + t1.getTeamname() + "===");
        System.out.println(t1.findBestPlayer());
        System.out.println();
        System.out.println("===Best player in " + t2.getTeamname() + "===");
        System.out.println(t2.findBestPlayer());
    }
} */


//Opgave 5 -Library System med access modifiers

/*
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;

class Book{
    private String title;
    private String author;
    private boolean available;


    public Book(String title, String author){


        if (title.isEmpty() || title.equals(" ")){
            this.title = "Unknown";
        }else {
            this.title = title;
        }
        if (author.isEmpty() || author.equals(" ")){
            this.author = "Unknown";
        }else {
            this.author = author;
        }

        this.available = true;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return available;
    }


    public void borrow(){
        if (available){
            available = false;
            System.out.println( title + " borrowed");
        }else{
            System.out.println(title+ " not available");
        }
    }

    public void returnBook(){
        if (!available){
            available = true;
            System.out.println("Book returned!");
        }else{
            System.out.println("Cant return what is already here");
        }
    }

    public String toString(){
        return title + " - by " + author + " - is available: " + available;
    }
}


class Library{
    private String libraryName;
    private ArrayList<Book> books;


    public Library(String libraryName){

        this.libraryName = libraryName;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book){
        books.add(book);
    }

    public void findAvailableBooks(){
        System.out.println();
        System.out.println("=== Available books ===");
        for (Book book : books){
            if (book.isAvailable()){
                System.out.println(book);
            }
        }
    }

    public Book findBookByTitle(String title){

        for (Book book : books){
            if (book.getTitle().toLowerCase().trim().equals(title.toLowerCase().trim())){
                return book;
            }
        }
        return null;
    }

    public void printAllBooks(){
        System.out.println();
        System.out.println("=== All books ===");
        for (Book book : books){
            System.out.println(book);
        }
    }
}

public class Main {
    static void main() {

        Library myLibrary = new Library("Great library of Alexandria");
myLibrary.addBook(new Book("Animal farm", "George orwell"));
myLibrary.addBook(new Book("Harry potter", "J.K rowling"));
myLibrary.addBook(new Book("Mistborn", "Brandon Sanderson"));
myLibrary.addBook(new Book("The Sunlit man", "Brandon Sanderson"));
myLibrary.addBook(new Book("Fahrenheit 451", "Ray Bradbury"));
//Test af validering
        myLibrary.addBook(new Book("", ""));

        System.out.println();

myLibrary.findBookByTitle("Animal farm").borrow();

myLibrary.findBookByTitle("The Sunlit man").borrow();
//Test for at se om borrow virker
myLibrary.findBookByTitle("The Sunlit man").borrow();
myLibrary.findBookByTitle("Mistborn").borrow();

myLibrary.findAvailableBooks();
myLibrary.findBookByTitle("The Sunlit man").returnBook();
        myLibrary.findBookByTitle("Animal farm").returnBook();
        myLibrary.printAllBooks();
    }
}*/

//Opgave 6 - Game inventory med Static
/*

import java.util.ArrayList;

class Item{

    private String name;
    private int value;
    private String type;
    private static int totalItemsCreated = 0;
    private static int totalValue = 0;

    public Item(String name, int value, String type){
        this.name = name;
        this.value = value;
        this.type = type;
        totalItemsCreated++;
        totalValue += value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public String getType() {
        return type;
    }

    public static int getTotalItemsCreated() {
        return totalItemsCreated;
    }

    public static int getAverageItemValue(){
        return totalValue / totalItemsCreated;
    }

    public String toString(){
        return name + " - " + type + " - " + value + "kr";
    }
}



class Inventory{
    private String playerName;
    private ArrayList<Item> items;
    private int maxCapacity;



    public Inventory(String playerName, int maxCapacity){
        this.playerName = playerName;
        this.items = new ArrayList<>();
        this.maxCapacity = maxCapacity;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void addItem(Item item){
        if (items.size() < maxCapacity){
            items.add(item);
        }else{
            System.out.println("Cant add " + item.getName() + " no room in inventory");
        }
    }

    public int getTotalValue(){
        int sum = 0;
        for (Item item : items){
            sum += item.getValue();
        }
        return sum;
    }

    public ArrayList<Item> findItemsByType(String type){
        ArrayList<Item> arrayListWithType = new ArrayList<>();
        for (Item item : items){
            if (item.getType().equals(type)){
                arrayListWithType.add(item);
            }
        }
        return arrayListWithType;
    }

    public void printInventory(){
        System.out.println();
        System.out.println("=== " +playerName + "'s Inventory ===");
        for (Item item : items){
            System.out.println(item);
        }
    }
}



public class Main {
    static void main() {
Inventory myInventory = new Inventory("Player 1", 3);
Inventory inv2 = new Inventory("Player 2", 5);

myInventory.addItem(new Item("Sword", 150, "Weapon"));
myInventory.addItem(new Item("Apple", 2, "Food"));
myInventory.addItem(new Item("Bow", 100, "Weapon"));
//Does not get added, testing max capacity
myInventory.addItem(new Item("Bow", 100, "Weapon"));

inv2.addItem(new Item("Staff", 85, "Weapon"));
        inv2.addItem(new Item("Magic book", 200, "Weapon"));
        inv2.addItem(new Item("Apple", 2, "Food"));
        inv2.addItem(new Item("Wine", 20, "Food"));
        inv2.addItem(new Item("Beer", 5, "Food"));

        myInventory.printInventory();

        inv2.printInventory();

        System.out.println();
        System.out.println("Total items created: " + Item.getTotalItemsCreated());
        System.out.println("Average value of all items created: " + Item.getAverageItemValue());

        System.out.println();
        System.out.println("Player 1 inventory total value:" + myInventory.getTotalValue());
        System.out.println("Player 2 inventory total value:" + inv2.getTotalValue());
        System.out.println();


        //Not part of assignment just wanted to test it out myself:)
        ArrayList <Item> byType = inv2.findItemsByType("Food");
        System.out.println("Items in " + inv2.getPlayerName() + "'s inventory with " + byType.getFirst().getType() +" type");
        for (Item item : byType){
            System.out.println(item);
        }

    }
} */