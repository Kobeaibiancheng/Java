/*class ListNode {
    public int data;
    public ListNode next;

    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}*/
class SingleList {
    public ListNode head;

    public SingleList() {
        this.head = null;
    }


    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        if(this.head == null) {
            this.head = node;
            return;
        }
        node.next = this.head;
        this.head = node;
    }

    public void addLast(int data) {
        ListNode node = new ListNode(data);
        if(this.head == null) {
            this.head = node;
            return;
        }
        ListNode cur = this.head;
        while(cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
    }

    public void display2(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
    }


    public ListNode reverseList() {
        ListNode prev = null;
        ListNode cur = this.head;
        ListNode newHead = null;
        while(cur != null) {
            ListNode curNext = cur.next;
            if(curNext == null) {
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return newHead;
    }

	//求倒数第k个节点，让fast先走k-1步
	public ListNode findKthToTail(int k) {
		ListNode slow = this.head;
		ListNode fast = this.head;
		for(int i = 0; i < k-1;i++) {
			if(fast.next != null) {
				fast = fast.next;
			}
			else{
				return null;
			}
		}
		
		while(fast.next != null){
			fast = fast.next;
			slow = slow.next;
		}
		return slow;
	}

}
