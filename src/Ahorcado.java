import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Alumne-GS
 */
public class Ahorcado {
    public static void mostrar_solucio(ArrayList<Character> solu){
        for (int i = 0; i < solu.size(); i++) {
            System.out.print(solu.get(i)+ " ");
        }
        System.out.println("");
    }
//
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        ArrayList<String> paraules=new ArrayList<>();
        paraules.add("Ahorcado");
        int vides=5;
        String paraula_clau=paraules.get((int)(Math.random()*paraules.size()));
        paraula_clau=paraula_clau.toLowerCase();
        ArrayList<Character> paraula_secreta=new ArrayList<>();
        for (int i = 0; i < paraula_clau.length(); i++) {
            paraula_secreta.add(paraula_clau.charAt(i));
        }
        ArrayList<Character> lletres=new ArrayList<>();
        
        for (int i = 'a'; i < 26+'a'; i++) {
            char lletra=(char)i;
            //System.out.println(lletra);
            lletres.add(lletra);
        }
        lletres.add('ç');
        
        ArrayList<Character> lletres_disponibles=new ArrayList<>();
        ArrayList<Character> lletres_utilitzades=new ArrayList<>();
        ArrayList<Character> solucio=new ArrayList<>();
        for (int i = 0; i < paraula_clau.length(); i++) {
            solucio.add('_');
        }
        lletres_disponibles.addAll(lletres);
        
        System.out.println("Començam");
        while (!paraula_secreta.equals(solucio) || vides==0) {
            System.out.println("VIDES: " + vides);
            System.out.println("Digues una lletra");
            System.out.println("Disponibles:" + lletres_disponibles);
            System.out.println("Utilitzades:" + lletres_utilitzades);
            mostrar_solucio(solucio);
            char lletra=s.next().charAt(0);
            if (lletres_disponibles.contains(lletra) && paraula_secreta.contains(lletra)) {
                System.out.println("S'ha trobat la teva lletra");
                lletres_utilitzades.add(Character.valueOf(lletra));
                lletres_disponibles.remove(Character.valueOf(lletra));
                for (int i = 0; i < solucio.size(); i++) {
                    if (paraula_secreta.get(i)==lletra) {
                        solucio.remove(i);
                        solucio.add(i, Character.valueOf(lletra));
                    }
                }
            } else{
                if (lletres_utilitzades.contains(lletra)) {
                    System.out.println("Aquesta ja l'has dita");
                }else if(!lletres.contains(lletra)){
                        System.out.println("Lletra no existent");
                        } else{
                    System.out.println("No s'ha trobat la lletra, perds una vida");
                    lletres_utilitzades.add(Character.valueOf(lletra));
                    lletres_disponibles.remove(Character.valueOf(lletra));
                    
                    vides--;
                }
            }
        }
        
        
    }
}