import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Wallet {
    private int balance;
    private List<String> expences;
    private List<String> items;

    public Wallet() {
        this.balance = 0;
        this.expences = new ArrayList<>();
        this.items = new ArrayList<>();
    }

    public void getInfos() {
        if (items.isEmpty()) {
            System.out.println("Votre solde est de " + balance);
        } else {
            System.out.println("Votre solde est de " + balance + " et vous avez " + items + " dans votre portefeuille");
        }
    }

    public void addMoney(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez entrer le montant d'argent que vous souhaitez ajouter : ");
        int amount = scanner.nextInt();
        balance += amount;
        System.out.println("Votre solde est de " + balance);
    }

    public void getMoney(){
        if(balance==0){
            System.out.println("Vous pouvez pas faire un retrait parce que votre solde est de 0 ariary");
        }else {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Veuillez entrer le montant que vous voulez avoir : ");
            int amount = scanner.nextInt();
            scanner.nextLine();

            if(amount>balance){
                System.out.println("Vous ne pouvez pas faire le retrait");
            }else {
                System.out.println("Pour quelle raison vous faite le retrait : ");
                String description = scanner.nextLine();
                balance -= amount;
                System.out.println("Vous avez pris "+ amount + " pour " + description);
                expences.add(amount + " pour " + description);
            }
        }
    }

    public void getExpences(){
        if(expences.size()==0){
            System.out.println("Vous n'avez pas de depense");
        }else {
            for(int i=0 ; i<expences.size();i++){
                System.out.println(expences.get(i));
            }
        }
    }

    public void store(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vous voulez ajouter quoi --> ");
        String item = scanner.nextLine();
        items.add(item);
        System.out.println("Vous avez ajoutet " + item + " dans votre portefeuille .");
    }

    public static void main(String[] args) {
        System.out.println("Que voulez-vous faire ?");
        System.out.println("1. Ajouter de l'argent");
        System.out.println("2. Prendre de l'argent ");
        System.out.println("3. Suivre les depenses ");
        System.out.println("4. Ranger vous affaires dans le portefeuille");
        System.out.println("5. Voir des informations ");
        System.out.println("6. quitter ");
        Wallet wallet = new Wallet();
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        while (option != 6) {
            switch (option) {
                case 1:
                    wallet.addMoney();
                    break;
                case 2:
                    wallet.getMoney();
                    break;
                case 3:
                    wallet.getExpences();
                    break;
                case 4:
                    wallet.store();
                    break;
                case 5:
                    wallet.getInfos();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Option invalide.");
            }
            option = scanner.nextInt();
        }
    }
}
