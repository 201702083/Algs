public class UTECO_3 {
    public static void main(String[] args) {
        String[] ings = {"r 10", "a 23", "t 124", "k 9"};
        String[] menu = {"PIZZA arraak 145", "HAMBURGER tkar 180", "BREAD kkk 30", "ICECREAM rar 50", "SHAVEDICE rar 45", "JUICE rra 55", "WATER a 20"};
        String[] sell = {"BREAD 5", "ICECREAM 100", "PIZZA 7", "JUICE 10", "WATER 1"};
        System.out.println(solution3(ings,menu,sell));
    }
    public static int solution3(String[] ings, String[] menu, String[] sell) {
        int answer = 0;
        int[] earn = new int[menu.length];
        for (int i = 0 ; i < menu.length ; i ++){
            earn[i] = Integer.parseInt(menu[i].split(" ")[2]) - ingsPrice(ings, menu[i].split(" ")[1]) ;
        }
        for ( String line : sell){
            for ( int i = 0 ; i < menu.length ; i ++ ){
                if( line.split(" ")[0].equals(menu[i].split(" ")[0]))
                    answer += Integer.parseInt(line.split(" ")[1]) * earn[i];
            }
        }



        return answer;
    }


    static int ingsPrice(String[] in, String menuin){
        int price = 0;
        for (int i = 0 ; i < menuin.length() ; i++ ){
            for (String ing : in){
                if ( ing.charAt(0) == menuin.charAt(i)){
                    price += Integer.parseInt(ing.split(" ")[1]);
                }
            }
        }
        return price;
    }
}
