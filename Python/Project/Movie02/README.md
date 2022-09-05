# PJT 02
## 프로젝트 개요
API를 활용하여 영화 데이터를 요청하고 수집한다. 수집한 데이터에서 파이썬을 통해 목표한 데이터를 추출한다. 커뮤니티 서비스에 활용되는 기능들을 구현하며 문제 해결능력을 기른다.
## 프로젝트를 통해 배운 내용
API를 활용해보는 경험을 할 수 있었으며, 요청과 응답에 대해서 공부할 수 있었다. 수집한 데이터를 파이썬을 통해서 추출하며 데이터 구조에 대한 분석과 이해력을 향상시킬 수 있었다.
## A. 인기 영화 조회
- 요구 사항
  - TMDB에서 인기 영화 목록을 응답 받아 개수를 출력한다.
- 결과 : TMDB의 Get Popular에서 제공하는 인기 영화 목록의 개수가 출력된다.
- 문제 접근 방법 및 코드 설명
```python
def popular_count():
    URL = 'https://api.themoviedb.org/3/movie/popular?api_key=c8f63acafb8d64e6ecd6d44111b7ba2b&language=ko&page=1'
    # 인기 영화 목록 데이터 요청
    Get_Popular = requests.get(URL).json()
    #영화 목록 할당
    movies = Get_Popular['results']
    # 영화 목록의 개수 반환
    return len(movies)
```

## B. 특정 조건에 맞는 인기 영화 조회
- 요구 사항
  - 인기 영화 목록 중 평점이 8점 이상인 영화 목록을 출력한다.
- 결과 : 인기 영화 목록 중 평점이 8점 이상인 영화에 대한 정보들이 출력된다.
- 문제 접근 방법 및 코드 설명
```python
def vote_average_movies():
    # 인기 영화 목록 데이터 요청
    URL = 'https://api.themoviedb.org/3/movie/popular?api_key=c8f63acafb8d64e6ecd6d44111b7ba2b&language=ko&page=1'
    Get_Popular = requests.get(URL).json()
    # 영화 목록 데이터 할당
    movies = Get_Popular['results']
    # 빈 리스트 생성
    over_eight = []
    # 모든 데이터에 대해서 평점이 8이상이면 리스트에 추가
    for i in movies:
      if i['vote_average']>=8:
        over_eight.append(i)
    # 수집한 리스트 반환    
    return over_eight
```
## C. 특정 조건에 맞는 인기 영화 조회
- 요구 사항
  - 인기 영화 목록을 평점이 높은 순으로 5개의 영화 데이터 목록을 출력한다.
- 결과 : 평점이 1~5번째로 높은 영화 데이터 목록이 순서대로 출력된다.
- 문제 접근 방법 및 코드 설명
```python
def ranking():
    # 인기 영화 목록 데이터 요청  
    URL = 'https://api.themoviedb.org/3/movie/popular?api_key=c8f63acafb8d64e6ecd6d44111b7ba2b&language=ko&page=1'
    Get_Popular = requests.get(URL).json()
    # 영화 목록 데이터 할당
    movies = Get_Popular['results']
    # 평점 순으로 영화 목록 정렬
    to_sort = sorted(movies, key = lambda x : -x['vote_average'])
    # 상위 5개 할당
    top_five = to_sort[0:5]
    return top_five
```
## D. 특정 추천 영화 조회
- 요구 사항
  - 특정 영화 제목을 검색하여 추천 영화 목록을 출력한다.
- 결과 : 검색한 영화 제목에 따른 추천 영화 목록을 출력한다. 추천 영화가 없을 경우 []를 반환하며, 검색한 영화 정보가 없다면 None을 반환한다.
- 문제 접근 방법 및 코드 설명
```python
def recommendation(title):
    #영화 검색
    try :
        # 요청할 API 주소
        URL = 'https://api.themoviedb.org/3/search/movie'
        # 사용될 parameter들, 입력한 영화 제목을 할당
        params = {
            'api_key': 'c8f63acafb8d64e6ecd6d44111b7ba2b',
            'language' : 'ko',
            'query': title   
        }
        # 데이터 요청
        response = requests.get(URL, params=params).json()
        # 검색 결과의 첫번째 영화 정보 추출
        movie = response['results'][0]
        # 영화 id 추출
        movie_id = int(movie['id'])
        #영화 추천 목록 데이터 수집
        URL2 = f'https://api.themoviedb.org/3/movie/{movie_id}/recommendations'
        params = {
            'api_key': 'c8f63acafb8d64e6ecd6d44111b7ba2b',
            'language' : 'ko'
        }
        response2 = requests.get(URL2, params=params).json()    
        recos = response2['results']
        # 영화 추천 목록에서 영화 제목 데이터 리스트 추출
        Get_Recommendations = list(m['title'] for m in recos)
    # 검색 불가능 시 None 리턴
    except :
        return None
    # 이상 없을 시 추천 영화 목록 리턴
    return Get_Recommendations
```
## E. 출연진, 연출진 데이터 조회
- 요구 사항
  - 제공된 영화 제목을 검색해서 해당 영화의 출연진, 스태프 중 연출진 목록만을 출력한다.
- 결과 : 입력된 영화 제목에 해당하는 연출진 목록이 출력되며, 검색한 영화 정보가 없을 경우 None을 반환한다.
- 문제 접근 방법 및 코드 설명
```python
def credits(title):
    # 영화 검색 D와 동일하게 id 추출
    try :
        URL = 'https://api.themoviedb.org/3/search/movie'
        params = {
            'api_key': 'c8f63acafb8d64e6ecd6d44111b7ba2b',
            'language' : 'ko',
            'query': title
        }
        response = requests.get(URL, params=params).json()
        movie = response['results'][0]
        movie_id = int(movie['id'])
    # 출연진, 연출진 데이터 조회
        URL2 = f'https://api.themoviedb.org/3/movie/{movie_id}/credits'
        params = {
            'api_key': 'c8f63acafb8d64e6ecd6d44111b7ba2b',
            'language' : 'ko'
        }
        response2 = requests.get(URL2, params=params).json()
        credits1 = response2['cast'] # 출연진 리스트 할당
        credits2 = response2['crew'] # 스태프 리스트 할당
        cast = [] # 조건에 맞는 출연진 리스트 생성
        directing = [] # 조건에 맞는 연출진 리스트 생성
        for i in credits1: # 출연진은 cast_id가 10 미만인 경우만 추출
            if i['cast_id']<10:
                cast.append(i['name'])
        for i in credits2: # 연출진은 부서가 Directing인 데이터만 추출
            if i['department'] == 'Directing':
                directing.append(i['name'])
        # Dictionary 형태의 credit 목록 반환
        Get_Credits = {'cast' : cast, 'directing' : directing}
        return Get_Credits
    # 검색이 불가능한 경우 None
    except :
        return None
```
## 프로젝트 후기
API 활용이 처음이라 데이터를 수집하는 과정이 낯설고 어려웠다. 모르는 부분은 찾아가며 프로젝트를 수행하니, 원하는 결과들이 도출되는 것이 신기하였다. 실제 커뮤니티에서 활용될 수 있는 기능들이라 더욱 몰입할 수 있었으며, 발전시켜서 다양한 분야에 활용할 수 있을 것이라는 생각이 들었다.
