public class GenericListsTester {

    public static void main(String[] args) {
        GenericArrayList<Integer> aList = new GenericArrayList<>();
        aList.add(5); aList.add(3); aList.add(8);
        printList("aList", aList);

        GenericArrayList<String> aSecondList = new GenericArrayList<>();
        aSecondList.add("Tom"); aSecondList.add("Dick"); aSecondList.add("Harry");
        printList("aSecondList", aSecondList);

        //Now - a similar test for the generic linked list class
        GenericLinkedList<String> aThirdList = new GenericLinkedList<>();
        aThirdList.add("Me"); aThirdList.add("Myself"); aThirdList.add("I");
        printList("aThirdList", aThirdList);

        }

        private static <T> void printList(String listName, GenericList<T>
                listToPrint) {
            System.out.println(listName + " contains:");
            for(int i = 0; i < listToPrint.size(); i++)
            {
                System.out.print(listToPrint.get(i) + " ");
            }
            System.out.println();
        }

}

