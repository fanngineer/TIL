# 10진법 수를 2진법으로 변환하는 함수

## 처음 작성했던 코드
```python
def dec_to_bina(n):
    m = n//2 #2로 나눈 몫
    na = n%2 #2로 나눈 나머지
    if m < 2: #종료 조건 : 나누는 수가 2보다 작을 때
        return str(m)+str(na) #몫+나머지를 문자열로 반환
    return dec_to_bina(m) + str(na) #나머지만 뒤에 문자열로 붙이고 재귀함수를 통해 계속 반복
```
## 모범 답안
```python
def dec_to_bina(n):
    if n < 2:
        return str(n)#종료 조건
    return dec_to_bina(n//2) + str(n%2)
```