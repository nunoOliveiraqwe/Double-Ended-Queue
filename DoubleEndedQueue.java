class DoubleEndedQueue<T>{
    private static class Node<T>{
        T data;
        Node next;
        Node prev;
    }
    
    private Node<T> top;
    private Node<T> bottom;
    
    public void enqueue(T data){
        Node<T> node = new Node();
        node.data = data;
        if(top==null){
            top = node;
            return;
        }
        if(bottom==null){
            bottom=node;
            top.next=bottom;
            bottom.prev=top;
            return;
        }
        bottom.next = node;
        node.prev=bottom;
        bottom = node;
    }
    
    public T dequeue(){
        if(top!=null){
            T data = top.data;   
            top = top.next;
            if(top!=null){
               top.prev = null;
            }
            return data;
        }
        //maybe throw Null pointer exception
        return null;
    }
    
    public T pop(){
        if(bottom!=null){
            T data = bottom.data;
            bottom = bottom.prev;
            if(bottom!=null){
                bottom.next = null;
            }            
            return data;
        }
        return null;
    }

    public T peekTop(){
        if(top!=null){
            T data = top.data;   
            return data;
        }
        return null;
    }
    
      public T peekBottom(){
        if(bottom!=null){
            T data = bottom.data;   
            return data;
        }
        return null;
    }
    
}
