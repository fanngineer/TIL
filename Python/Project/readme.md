# PJT 01
## 프로젝트 개요
- 커뮤니티 서비스 개발을 위한 데이터 구성 단계 학습을 위해서 필요한 영화 데이터를 추출하고 구성을 진행
 
## 프로젝트를 통해 배운 내용
- json file 과 같이 외부 파일을 불러와서 데이터를 할당하는 과정을 경험했다.
- A>B>C 로 진행하면서 문제 해결을 위해 단계적으로 진행하는것의 유용성을 느꼈다.
- Python의 Dictionary, List 자료형의 데이터를 처리하는 과정을 실제 데이터로 수행하며 좀 더 친숙하게 학습하였다.


## A. 제공되는 영화 데이터의 주요내용 수집
- 요구 사항 : 단일 샘플 영화 데이터에서 서비스 구성에 필요한 정보만 추출해 반환한다.

- 결과 : 영화 정보 중 id, title, poster_path, vote_average, overview, genre_ids에 해당하는 정보를 출력한다.

- 문제 접근 방법 및 코드 설명
dictionary 형태의 데이터에서 원하는 데이터 key에 해당하는 값들을 dictionary.get()함수를 통해서 할당한다.
```python
def movie_info(movie):    
    new_data = {
            'id': movie.get('id'),
            'title' : movie.get('title'),
            'poster_path' : movie.get('poster_path'),
            'vote_average' : movie.get('vote_average'),
            'overview' : movie.get('overview'),
            'genre_ids' : movie.get('genre_ids'),
      }
    return new_data
위와 같이 새로운 dictionary 에 값들을 할당한다.
```

## B. 제공되는 영화 데이터의 주요내용 수정
- 요구 사항 : A에서 작성한 데이터 중 genre_ids를 번호가 아닌 장르 이름 리스트로 바꿔 반환한다. 

- 결과 : 기존 'genre_ids' : [18, 80]으로 출력되던 부분이 'genre_names' : ['Drama','Crime']으로 변경되어 출력된다.

- 문제 접근 방법 및 코드 설명
genre_ids와 일치하는 genres.json file에 담긴 이름을 찾기 위해서 반복문을 활용한다. 일치하는 장르 이름들을 새로운 리스트에 할당하고 리스트를 genre_names의 value로 사용한다.

```python
def movie_info(movie, genres):
    #'genre_names':'genre_ids_value' 추가
    new_data['genre_names'] = new_data['genre_ids']
    #기존 'genre_ids':'genre_ids_value' 지우기
    del new_data['genre_ids']
    #'genre_names':'genre_names_value'
    gn = [] #genre names list
    for j in new_data['genre_names']: #id값 하나씩 찾기
        for i in genres: #id와 일치하는 이름 찾기
            if j == i['id']:
                gn.append(i['name']) # genre name list에 id일치하는 name 할당
    new_data['genre_names'] = gn # genre_names_value에 gn할당
    return new_data
```

## C. 다중 데이터 분석 및 수정
- 요구 사항 : 평점이 높은 20개 영화 데이터 중에서 서비스 구성에 필요한 정보만 추출한다.

- 결과 : 데이터에 담긴 모든 영화에 대해서 목표한 정보들이 출력된다.

- 문제 접근 방법 및 코드 설명
A의 데이터 추출방식과 B에서의 장르 이름 할당방법을 활용한 후, 반복문을 활용해 20개의 데이터에 적용한다.
```python
def movie_info(movies, genres):
    new_datas = []
    for movie in movies:
        new_data = {
            'id': movie.get('id'),
            'title' : movie.get('title'),
            'poster_path' : movie.get('poster_path'),
            'vote_average' : movie.get('vote_average'),
            'overview' : movie.get('overview'),
            'genre_ids' : movie.get('genre_ids'),
        }
        #'genre_names':'genre_ids_value' 추가
        new_data['genre_names'] = new_data['genre_ids']
        #기존 'genre_ids':'genre_ids_value' 지우기
        del new_data['genre_ids']
        #'genre_names':'genre_names_value'
        gn = [] #genre names list
        for j in new_data['genre_names']: #id값 하나씩 찾기
            for i in genres: #id와 일치하는 이름 찾기
                if j == i['id']:
                    gn.append(i['name']) # genre name list에 id일치하는 name 할당
        new_data['genre_names'] = gn # genre_names_value에 gn할당
        new_datas.append(new_data)
    return new_datas
'''
프로젝트 B의 코드를 for문을 통해 Movies안의 영화 정보들에 대해서 각각 수행하여 new_datas 라는 리스트로 반환한다.
'''
```

## D. 알고리즘을 사용한 데이터 출력
- 요구 사항 : 영화 세부 정보 중 수입 정보(revenue)를 통해 가장 수익을 많이 낸 영화를 출력한다.

- 결과 : 각각 영화에 대한 json file에 담긴 revenue 값이 가장 높은 영화의 제목이 출력된다.
  - 출력값 : 반지의 제왕: 왕의 귀환

- 문제 접근 방법 및 코드 설명
반복문을 통해 영화들에 대한 id값을 얻어, 이에 해당하는 영화정보 파일(json)을 오픈한다. 그 후, 수익정보를 찾아 비교하면서 최대치를 찾는다. 최대치를 가진 영화의 제목을 변수에 저장해서 return한다.
```python
def max_revenue(movies):  
    top_revenue = 0
    for movie in movies:
        id = movie['id']
        info_json = open(f'data/movies/{id}.json', encoding='utf-8')
        movie_info = json.load(info_json)    
        revenue = movie_info['revenue']
        if top_revenue < revenue :
            top_revenue = revenue
            top_name = movie['title']
    return top_name
```

## E. 알고리즘을 사용한 데이터 출력
- 요구 사항 : 영화 세부 정보 중 개봉일 정보를 이용하여 12월에 개봉한 영화 제목 리스트를 출력한다.

- 결과 : 영화 목록 중에서 세부 정보 파일에 개봉일이 12월인 영화들을 출력한다.
  - 출력값 : ['그린 마일', '인생은 아름다워', '반지의 제왕: 왕의 귀환', '스파이더맨: 뉴 유니버스']

- 문제 접근 방법 및 코드 설명
영화 목록에서 반복문을 활용해 영화마다 id를 찾고, 이에 해당하는 세부 정보 파일을 오픈한다. 세부 정보에서 개봉일 정보를 찾은 후, 개봉 월에 해당하는 위치가 '12'와 동일한 영화의 제목을 리스트에 추가한다.
```python
def dec_movies(movies):
    dec_list = []  
    for movie in movies:
        id = movie['id']
        info_json = open(f'data/movies/{id}.json', encoding='utf-8')
        movie_info = json.load(info_json)    
        release_date = movie_info['release_date']
        if release_date[5:7] == '12':
            dec_list.append(movie_info['title'])
    return dec_list
```

## F. 알고리즘을 사용한 데이터 출력
- 요구 사항 : 사용자가 검색한 장르의 영화 정보를 제공한다. 사용자가 잘못 입력하였을때는 "해당 장르는 존재하지 않습니다"를 출력하고 다시 입력받는다.
- 결과 : 사용자의 입력을 받아 해당하는 장르에 해당하는 영화의 title, overview, id, poster_path, vote_average를 출력한다.
  - 출력값 : 다음 장르중 원하는 장르를 검색하세요.
              [*장르목록*]
             >>> Action
             { 'id' : 55
               'overview' : \~~~~~~~~~~~
                  ...
                  ...                  
             }
- 문제 접근 방법 및 코드 설명
genres.json file에서 사용자가 입력한 장르에 해당하는 genre_id를 추출한다. 반복문을 통해서 영화 목록 중 genre_id를 가진 영화 제목을 리스트에 저장하여 출력한다.
```python
import json
from pprint import pprint

def whatdoyouwant(movies, genres):
    # 입력창에 보여줄 장르 이름 리스트 할당
    genre_names = []
    for gr in genres:
        genre_names.append(gr['name'])
    # 사용자가 원하는 장르 입력
    while 1 :
        want = input(f'다음 장르중 원하는 장르를 검색하세요.\n{genre_names}\n >>>')
        # 입력된 장르의 아이디 찾기
        for genre in genres:
            if want == genre['name']:
                genre_id = genre['id'] ## 입력된 장르 이름이 같으면 아이디 할당
                break
        else : 
            print("해당 장르의 영화는 존재하지 않습니다.\n")
            continue ## 입력된 장르가 없는 경우 다시 입력
        break ## 입력된 장르가 존재하면 입력 중지
    # 장르 아이디에 해당하는 영화 목록 찾기
    wanted_movie = [] ## 원하는 영화 목록
    for movie in movies:
        grs = movie['genre_ids'] ##  각 영화의 장르  id리스트 불러오기
        for gr in grs :
            if genre_id == gr: ## 입력받은 장르와 아이디가 일치하면
                wanted_movie.append(movie) ## 원하는 영화 목록에 영화 정보 전부 저장
    # 원하는 영화 목록에서 모든 정보 중 원하는 정보만 추출
    new_wanted_list = []       
    for movie in wanted_movie:
        new_data = {
            'id': movie.get('id'),
            'title' : movie.get('title'),
            'poster_path' : movie.get('poster_path'),
            'vote_average' : movie.get('vote_average'),
            'overview' : movie.get('overview'),
        }
        new_wanted_list.append(new_data)
    
    return new_wanted_list  


# 파일 open 및 출력
if __name__ == '__main__':
    movies_json = open('data/movies.json', encoding='utf-8')
    movies = json.load(movies_json)

    genres_json = open('data/genres.json', encoding='utf-8')
    genres_list = json.load(genres_json)

    pprint(whatdoyouwant(movies, genres_list))

```

## 프로젝트 후기
- 실제 데이터를 활용해서 코드를 작성하여서 몰입할 수 있었고, 즐거웠다.
- 프로젝트 F의 경우 스스로 목표를 설정하고 해결하는 과정에서 많은 보람을 느꼈다.
- 공부했던 Python 기본 지식을 활용하여 데이터 처리에 활용할 수 있다는 것을 깨달았고, 더욱 많은 부분을 공부해서 심화된 프로젝트도 진행하고싶은 욕구가 생겼다.
