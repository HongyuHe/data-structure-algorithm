# Doubly Linked-list

> Linked lists provide a simple, flexible representation for **dynamic sets**

## 1. Pseudocode
(1) Without sentinels

![d42c494bc6606e1e822dfdecb431f9b0.png](:/b92b14f1aad544c3bb7bd01a28235d98)

```haskell
algorithm ListSearch(L, k):
    x := L.head
    While x.next != NIL and x.key != k do
        x = x.next
    return x

algorithm ListInsert(L, x):
    x.next = L.head
    if L.head != NIL then --> this is necessary because if head is NIL, there is no L.head.prev (the 1st node)
        L.head.prev = x
    L.head = x
    x.prev = NIL --> this is important as well. The prev pointer of the 1st node is NIL

algorithm ListDelete(L, x):
    if x.prev != NIL then --> Whether it's head or not
        x.prev.next = x.next
    else 
        L.head = x
    if x.next != NIL then --> Whether it's tail or not
        x.next.prev = x.prev

```

(2) With sentinels

![3b8b8a4834b0331873426bff5659ffe4.png](:/757caabc64634db4ae5cb93ba2ea69fd)

```haskell
algorithm ListSearch(L, k):
    x := L.nil
    While x != L.nil and x.key != k do
        x = x.next
        
algorithm ListInsert(L, x):
    x.next = L.nil.next
    L.next.prev = x
    L.nil.next = x
    x.prev = L.nil

```










