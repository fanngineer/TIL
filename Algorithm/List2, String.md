# List2, String
## 2차원 배열
- 2차원 배열의 요소인 배열은 크기가 달라도 된다.
- int[행][열]
- 델타이동 : 2차 배열의 한 좌표에서 4방향의 인접 배열 요소를 탐색하는 방법
- 전치행렬 : 대각선을 기준으로 뒤집은 행렬
```Java
int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
for(int i =0; i<arr.length; i++){
  for(int j =i+1; j<arr.length; j++){
    int tmp = arr[i][j];
    arr[i][j] = arr[j][i];
    arr[j][i] = tmp;
  }
}
```
## 카운팅 정렬
- 항목들의 순서를 결정하기 위해 집합에 각 항목이 몇 개씩 있는지 세는 작업을 하여, 선형 시간에 정렬하는 효율적인 알고리즘
- 정수나 정수로 표현할 수 있는 자료에 대해서만 적용 가능
- 각 항목의 발생 회수를 기록하기 위해, 정수 항목으로 인덱스 되는 카운트들의 배열을 사용하기 때문
- 카운트들을 위한 충분한 공간을 할당하려면 집합 내의 가장 큰 정수를 알아야 한다.
- 시간 복잡도 O(n+k) : n은 배열의 길이, k는 정수의 최대값
- 1. Data에서 각 항목들의 발생 회수를 세고 정수 항목들로 직접 인덱스되는 카운트 배열에 저장
- 누적합을 구한 후, 원본 배열의 끝에서부터 탐색하여 카운팅 배열 원소를 -1후에 새 배열의 해당 인덱스에 값 저장
- 카운팅 정렬은 안정 정렬(똑같은 값을 정렬할때 원래 순서를 보장해준다.(원본 배열의 뒤에서부터 탐색하기 때문에))
- n이 비교적 작을때만 가능하다.
```Java
  int[] arr = {42, 95, 33, 7, 88, 5, 77, 10, 31, 5};
  int max = 0;
  for(int i=0; i<arr.length;i++){
    if(arr[i]>max)
      max = arr[i];
  }
  //카운팅 배열 생성
  int[] counting = new int[max+1];
  //카운팅하기
  for(int i=0; i<arr.length;i++){
    counting[arr[i]] +=1;
  }
  //누적합 구하기
  for(int i=1; i<max+1;i++){
    counting[i] += counting[i-1];
  }
  //배열을 거꾸로 탐색하며 새로운 배열에 넣기
  int[] sorted = new int[arr.length];
  for(int i=arr.length-1; i>=0;i--){
    counting[arr[i]]-=1;
    sorted[counting[arr[i]]] = arr[i];
  }
  System.out.println(Arrays.toString(sorted));
```

## 문자열
- Java에서 문자열 처리
  - 문자열 데이터를 저장, 처리해주는 클래스를 제공
  - String 클래스를 사용
  - 문자열 처리에 필요한 연산자, 메소드 형태로 제공 : length(), replace(), split(), substring()
- C와 Java의 String처리의 기본적인 차이점
  - c는 아스키 코드로 저장
  - java는 유니코드(UTF-16)로 저장
  - 파이썬은 유니코드(UTF-8)로 저장
- 문자열 뒤집기
  - 자기 문자열에서 뒤집는 방법이 있고 새로운 빈 문자열을 만들어 소스의 뒤에서부터 읽어서 타겟에 쓰는 방법이 있다.
  - 자기 문자열을 이용할 경우는 swap을 위한 임시 변수가 필요하며, 반복 수행으로 길이의 반만을 수행한다.
  - java에서는 StringBuffer클래스의 reverse() 메소드를 이용한다.

## 패턴 매칭
- Brute Force : 본문 문자열을 처음부터 끝까지 순회하며 패턴 내의 문자들을 일일이 비교하는 방식
- 
