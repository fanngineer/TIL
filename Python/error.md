# Python 실행 중 error case 정리
## 빈 리스트에 단어 하나씩 넣기
- error
```python
t = int(input())
test = list()
while i < t:
  test[i] = input()
  i +=1
```
- reason  
리스트 test가 비어있는 상황  
index를 직접 참조해서 값을 넣기위해서는 리스트의 크기가 정해져있어야한다.
- modified
```python
test=[]
i = 0
while i<t:
  test.append(input())
  i+=1
```
## 자릿수 더하기
- error
*TypeError: 'int' object is not callable*
```python
n = input('숫자를 입력해주세요 : ')
sum = sum(map(int,n))
print(s)
```
- reason
예약어를 번수명으로 사용했기때문
- modified
```python
del sum    #변수 삭제
n = input('숫자를 입력해주세요 : ')
s = sum(map(int,n))
```
print(s)
