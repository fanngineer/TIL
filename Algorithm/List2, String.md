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
## 문자열
