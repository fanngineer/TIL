# Stack
- 물건을 쌓아 올리듯 자료를 쌓아 올린 형태의 자료구조
- 저장된 자료는 선형 구조를 갖는다.
- 마지막에 삽입한 자료를 가장 먼저 꺼내는 후입선출의 특성을 가짐

## Stack의 연산
- 마지막 삽입된 원소의 위치를 top
- 삽입 : 저장소에 자료를 저장. push
- 삭제 : 자료를 삽입의 역순으로 꺼낸다. pop
- 스택이 공백인지 아닌지 확인하는 연산. isEmpty
- 스택의 top에 있는 item을 반환하는 연산. peek

## stack의 구현
- top을 -1로 초기화.
- 자료를 추가할 때마다 top++
- 자료를 꺼낼때마다 top--

## 스택의 구현
```Java
  static int[] stack = new int[?];
  static int top = -1;
  public static main(String[] args){
  }
  
  static boolean isFull(){
    return top == stack.length-1;
  }
  static boolean isEmpty(){
    return top == -1;
  }
  static void stackPush(int value){
    if(stack.isFull())
      return;
    stack[++top] = value;
  }
  stack int stackPop(){
    if(stack.isEmpty())
      return 0;
    return stack[top--];
  }
```


