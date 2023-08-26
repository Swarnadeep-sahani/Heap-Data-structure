class minHeap{
    int arr[];
    int size;
    int capacity;
    minHeap(int c)
    {
        arr=new int[c];
        capacity=c;
         size=0;
    }
    int left(int i) { return (2*i+1); }
    int right(int i) { return (2*i+2); }
    int parent(int i) { return (i-1)/2; }
    void insert(int x){
        if(size==capacity) return;
         size++;
         arr[size-1]=x;
         int i=size-1;
         while (i!=0 && arr[parent(i)]>arr[i]) {
            int temp=arr[i];
            arr[i]=arr[parent(i)];
            arr[parent(i)]=temp;
            i=parent(i);
         }
    }
    void minHeapify(int i)
    {
        int li=left(i),ri=right(i);
        int smallest=i;
        if(li<size && arr[li]<arr[smallest])
           smallest=li;
        if(ri<size && arr[ri]<arr[smallest])
           smallest=ri;  
        if(i!=smallest)
        {
            int temp=arr[i];
            arr[i]=arr[smallest];
            arr[smallest]=temp;
            minHeapify(smallest);
        }    
    }
    
}
class solution{
    public static void main(String[] args) {
        minHeap mh=new minHeap(10);
        mh.insert(10);
        mh.insert(45);
        mh.insert(20);
        mh.insert(15);
        mh.insert(25);
        mh.insert(100);
        for (int i = 0; i < mh.size; i++) {
            System.out.print(mh.arr[i]+" ");
        }
    }
}