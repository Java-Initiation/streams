import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        ArrayList<User> users = new ArrayList<>();
        users.add(new User("toto", 32));
        users.add(new User("tutu", 12));
        users.add(new User("tata", 68));
        users.add(new User("titi", 99));
        users.add(new User("tete", 11));

        // on recupère les users de plus de 40 ans dans une nouvelle liste
        List<User> usersDePlusDe40Ans = users.stream()
                .filter( user -> user.getAge()  > 40)
                .collect(Collectors.toList());

        // on additionne tous les ages
        int totalAges = users.stream()
                .mapToInt(User::getAge)
                .sum();
        System.out.println(totalAges);

        // on calcule la moyenne des ages
        double moyenneAges = users.stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0.0);

        // est-ce que tous les utilisateurs ont plus de 40 ans ?
        boolean areAllMore40 = users.stream().allMatch( user -> user.getAge() > 40);

        // on récupère un utilisateur qui a plus de 40 ans (le premier)
        User userLePlusJeune = users.stream()
                .filter(user -> user.getAge() > 40)
                .min(Comparator.comparingInt(User::getAge))
                .orElse(null);

    }

}
