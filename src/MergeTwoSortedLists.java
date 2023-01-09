public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode node2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        Solution solution = new Solution();
        showNode(solution.mergeTwoLists(node1, node2));
    }

    static void showNode(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    /**
     * Uz: <br>
     * <b>Masala sharti:</b> Funksiya kiruvchi parameter sifatida ikkita kichikdan kattaga qarab tartiblangan ListNode kirib keladi. Kirib kelgan Ikkita ListNodeni bita o'sish tartibida bita ListNode ga yigib chiqarish kerak.
     *
     * <b>Yechim:</b> Bita ListNode ochiladi, va unga ikkita ListNodedan birdaniga yigib chiqiladi.
     * <br>
     * <b>Kod teziligi: </b> 100%
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode node = new ListNode();
        ListNode result = node;

        if (list1 != null && list2 != null && list1.val <= list2.val) {
            node.val = list1.val;
            list1 = list1.next;
        } else if (list2 != null) {
            node.val = list2.val;
            list2 = list2.next;
        } else {
            return null;
        }

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                node.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                node.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            node = node.next;
        }
        if (list1 != null) {
            while (list1 != null) {
                node.next = new ListNode(list1.val);
                list1 = list1.next;
                node = node.next;
            }
        } else {
            while (list2 != null) {
                node.next = new ListNode(list2.val);
                list2 = list2.next;
                node = node.next;
            }
        }
        return result;
    }
}


