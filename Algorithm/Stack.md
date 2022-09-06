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

## Stack의 구현
- top을 -1로 초기화.
- 자료를 추가할 때마다 top++
- 자료를 꺼낼때마다 top--

## Stack의 구현
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

## Stack의 응용
### Function call
- 프로그램에서의 함수 호출과 복귀에 따른 수행 순서를 관리
- 가장 마지막에 호출된 함수가 가장 먼저 실행을 완료하고 복귀하는 후입선출 구조로, 후입선출 구조의 스택을 이용하여 수행순서 관리
- 함수 호출이 발생하면 호출한 함수 수행에 필요한 지역변수, 매개변수 및 수행 후 복귀할 주소 등의 정보를 스택 프레임에 저장하여 시스템 스택에 삽입
- 함수의 실행이 끝나면 시스템 스택의 top원소를 삭제하면서 프레임에 저장되어 있던 복귀주소를 확인하고 복귀
- 함수 호출과 복귀에 따라 과정을 반복하며 전체 프로그램 수행이 종료되면 시스템 스택은 공백 스택이 됨.

