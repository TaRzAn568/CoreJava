package Design;



class FrontMiddleBackQueue {

    FrontMiddleBackQueue f;
    FrontMiddleBackQueue b;
    FrontMiddleBackQueue m;
    FrontMiddleBackQueue next;
    FrontMiddleBackQueue prev;
    int val;
    int size;

    public FrontMiddleBackQueue() {

    }
    public FrontMiddleBackQueue(int val){
        this.val = val;
        this.next = null;
        this.prev = null;
    }

    public void pushFront(int val) {
        FrontMiddleBackQueue temp = new FrontMiddleBackQueue(val);
        size++;

        if(size ==1){
            f = temp;
            m = f;
            b = f;
        }else {
            temp.next = f;
            temp.next.prev = temp;
            f = temp;

            if( (size&1) == 0){
                m = m.prev;
            }
        }


    }

    public void pushMiddle(int val) {
        FrontMiddleBackQueue temp = new FrontMiddleBackQueue(val);
        size++;
        if(size ==1){
            f = temp;
            m = f;
            b = f;
        }
        else if(size == 2){
            m.next = temp;
            temp.prev = m;
            b = temp;
        }
        else{
            temp.next = m.next;
            if(temp.next != null)
                temp.next.prev = temp;
            m.next = temp;
            m.next.prev = m;
          //  m = temp;

            if( (size&1) == 1){
                m = m.next;
            }
        }
    }

    public void pushBack(int val) {
        FrontMiddleBackQueue temp = new FrontMiddleBackQueue(val);
        size++;

        if(size ==1){
            f = temp;
            m = f;
            b = f;
        }else {
            temp.prev = b;
            temp.prev.next = temp;
            b = temp;

            if( (size&1) == 1){
                m = m.next;
            }
        }
    }

    public int popFront() {
        if(size == 0){
            return -1;
        }
        int popVal = f.val;
        if(size == 1){
            f = null;
            b = null;
            m = null;
        }else{
            if( (size&1) == 0){
                m = m.next;
            }
            f = f.next;
            f.prev.next = null;
            f.prev = null;

        }
        size--;
        return popVal;
    }

    public int popMiddle() {
        if(size == 0){
            return -1;
        }
        int popVal = m.val;
        if(size == 1){
            f = null;
            b = null;
            m = null;
        }else if(size == 2){
            FrontMiddleBackQueue newM = m.next;
            m.next = null;
            newM.prev = null;
            m = newM;
        }
        else{
            if((size&1) ==0){
                FrontMiddleBackQueue newM = m.next;
                m.prev.next = newM;
                newM.prev = m.prev;
                m.next = null;
                m.prev = null;
                m = newM;
            }else{

                FrontMiddleBackQueue newM = m.prev;
                m.next.prev = newM;
                newM.next = m.next;
                m.next = null;
                m.prev = null;
                m = newM;
            }

        }

        size--;
        return popVal;
    }



    public int popBack() {

        if(size == 0){
            return -1;
        }
        int popVal = b.val;
        if(size == 1){
            f = null;
            b = null;
            m = null;
        }else{
            b = b.prev;
            b.next = null;
            if( (size&1) == 1){
                m = m.prev;
            }
        }
        size--;
        return popVal;
    }
}

class FMBQDriver{
    public static void main(String[] args){
        /*["FrontMiddleBackQueue","pushFront","pushBack","pushMiddle","pushMiddle","popFront","popMiddle","popMiddle","popBack","popFront"]
            [[],[1],[2],[3],[4],[],[],[],[],[]]
            ["FrontMiddleBackQueue","pushMiddle","pushMiddle","pushMiddle","popMiddle","popMiddle","popMiddle"]
[[],[1],[2],[3],[],[],[]]

            */
        FrontMiddleBackQueue q = new FrontMiddleBackQueue();
        q.pushMiddle(1);
        q.pushMiddle(2);
        q.pushMiddle(3);
        System.out.println(q.popMiddle());
        System.out.println(q.popMiddle());
        System.out.println(q.popMiddle());
    }
}
