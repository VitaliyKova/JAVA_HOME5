import java.util.*;

public class Home5 {
    public static void addContacts(String key, String value, HashMap<String,HashSet<String>> hashMap) {
        if(hashMap.containsKey(key)){
            hashMap.get(key).add(value);
        }
        else{
            HashSet <String> h_set = new HashSet<>();
            h_set.add(value);
            hashMap.put(key,h_set);
        }
    }
    public static void PrintSortContact(HashMap<String, HashSet<String>> hashMap){
        ArrayList <Integer> sort = new ArrayList<>();
        for (HashSet<String> item: hashMap.values()) {
            sort.add(item.size());
        }
        sort.sort(Comparator.reverseOrder());
        for (int i = 0; i < sort.size(); i++) {
            for (HashMap.Entry<String, HashSet<String>> entry : hashMap.entrySet()) {
                if(sort.get(i) == entry.getValue().size()){
                    System.out.printf("Имя: %s \n Телефоны: %s \n",entry.getKey(),entry.getValue());
                }
            }

        }
    }

    public static void main(String[] args) {
        HashMap<String,HashSet<String>> phone_book = new HashMap<>();
        Scanner in = new Scanner(System.in);
        Boolean proces = true;
        String name = "";
        String phone = "";
        while (proces == true) {
            System.out.println("Введите Имя -> ");
            name = in.nextLine();
            System.out.println("Введите номер -> ");
            phone = in.nextLine();
            addContacts(name,phone,phone_book);
            System.out.println("Чтобы добавить еще контакт, нажмите ENTER.\n Чтобы выйти введите \"end\"");
            name = in.nextLine();
            if(name.equalsIgnoreCase("end")) proces = false;
        }
        in.close();
        PrintSortContact(phone_book);
    }
}
