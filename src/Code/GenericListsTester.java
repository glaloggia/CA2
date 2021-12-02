package Code;

public class GenericListsTester {

    public static void main(String[] args) {
        IArrayList<Integer> aList = new IArrayList<>();
        aList.add(5); aList.add(3); aList.add(8);
        printList("aList", aList);

        IArrayList<String> aSecondList = new IArrayList<>();
        aSecondList.add("Tom"); aSecondList.add("Dick"); aSecondList.add("Harry");
        printList("aSecondList", aSecondList);

        //Now - a similar test for the generic linked list class
        ILinkedList<String> aThirdList = new ILinkedList<>();
        aThirdList.add("Me"); aThirdList.add("Myself"); aThirdList.add("I");
        printList("aThirdList", aThirdList);

    }

        private static <T> void printList(String listName, IList<T>
                listToPrint) {
            System.out.println(listName + " contains:");
            for(int i = 0; i < listToPrint.size(); i++)
            {
                System.out.print(listToPrint.get(i) + " ");
            }
            System.out.println();
        }

}

